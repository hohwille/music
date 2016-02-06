/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * A {@link Tone} is an absolute tone as the combination of a {@link TonePitch} with an {@link #getOctave() octave}.
 * While a {@link TonePitch} only identifies a tone within an octave a {@link Tone} can identify any
 *
 * @author hohwille
 */
public class Tone implements Transposable<Tone> {

  private final TonePitch pitch;

  private final int octave;

  /**
   * The constructor.
   *
   * @param name the {@link #toString() String representation} of this new {@link Tone}.
   */
  public Tone(String name) {

    super();
    String prefix = TonePitch.fromStringAsPrefix(name);
    this.pitch = TonePitch.fromString(prefix);
    String suffix = name.substring(prefix.length());
    this.octave = Integer.parseInt(suffix);
  }

  /**
   * The constructor.
   *
   * @param pitch - see {@link #getPitch()}.
   * @param octave - see {@link #getOctave()}.
   */
  public Tone(TonePitch pitch, int octave) {

    super();
    this.pitch = pitch;
    this.octave = octave;
  }

  /**
   * @return the {@link TonePitch} within the {@link #getOctave() octave}.
   */
  public TonePitch getPitch() {

    return this.pitch;
  }

  /**
   * @return the octave the {@link #getPitch() pitch} is located. A value of {@code 0} is the regular octave in
   *         {@link ClefSymbol#G violin-clef} starting with the low {@link TonePitch#C C} (below the scale) and ending
   *         with {@link TonePitch#H B} in the middle of the scale. A positive value is used to go up an octave to
   *         higher pitches and a negative value is used to go down (e.g. {@code -1} and {@code -2} for
   *         {@link ClefSymbol#F bass-clef}).
   */
  public int getOctave() {

    return this.octave;
  }

  /**
   * @see TonePitch#transposeChromatic(int, EnharmonicStyle)
   *
   * @param semitoneSteps is the number of semitone steps to transpose.
   * @param style the {@link EnharmonicStyle}.
   * @return the transposed {@link Tone}.
   */
  @Override
  public Tone transposeChromatic(int semitoneSteps, EnharmonicStyle style) {

    TonePitch resultPitch = this.pitch.transposeChromatic(semitoneSteps, style);
    return transposeOctaveChromatic(resultPitch, semitoneSteps);
  }

  /**
   * @see TonePitch#transposeChromatic(int, MusicalKey)
   *
   * @param semitoneSteps is the number of semitone steps to transpose.
   * @param targetKey is the target {@link MusicalKey key}.
   * @return the transposed {@link Tone} with enharmonic change according to the given {@link MusicalKey}.
   */
  @Override
  public Tone transposeChromatic(int semitoneSteps, MusicalKey targetKey) {

    TonePitch resultPitch = this.pitch.transposeChromatic(semitoneSteps, targetKey);
    return transposeOctaveChromatic(resultPitch, semitoneSteps);
  }

  private Tone transposeOctaveChromatic(TonePitch resultPitch, int semitoneSteps) {

    int pitchSteps = resultPitch.getStep() - this.pitch.getStep();
    int octaveSteps;
    if (semitoneSteps < 0) {
      octaveSteps = semitoneSteps / 12;
      if (pitchSteps > 0) {
        // extra octave step when stepping below C
        octaveSteps--;
      }
    } else {
      octaveSteps = semitoneSteps / 12;
      if (pitchSteps < 0) {
        // extra octave step when stepping above H
        octaveSteps++;
      }
    }
    int resultOctave = this.octave + octaveSteps;
    return new Tone(resultPitch, resultOctave);
  }

  /**
   * @see TonePitch#transposeDiatonic(int, MusicalKey)
   *
   * @param diatonicSteps is the number of semitone steps to transpose.
   * @param targetKey is the target {@link MusicalKey key}.
   * @return the transposed {@link Tone} with enharmonic change according to the given {@link MusicalKey}.
   */
  @Override
  public Tone transposeDiatonic(int diatonicSteps, MusicalKey targetKey) {

    TonePitch resultPitch = this.pitch.transposeDiatonic(diatonicSteps, targetKey);
    int targetStep = (this.pitch.getStep() + diatonicSteps - targetKey.getTonika().getStep()) % 8;
    int octaveStep = targetStep / 8;
    int resultOctave = this.octave + octaveStep;
    return new Tone(resultPitch, resultOctave);
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + this.octave;
    result = prime * result + ((this.pitch == null) ? 0 : this.pitch.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Tone other = (Tone) obj;
    if (this.octave != other.octave) {
      return false;
    }
    if (this.pitch != other.pitch) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {

    String result = this.pitch.toString();
    if (this.octave > 0) {
      result = result + "+" + this.octave;
    } else if (this.octave < 0) {
      result = result + this.octave;
    }
    return result;
  }

}
