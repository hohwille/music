/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * @author hohwille
 *
 */
public enum ChromaticInterval implements Interval {

  /** The "empty" interval. */
  PERFECT_UNISON(0, 0),

  /** One semitone step. */
  MINOR_SECOND(1, 1),

  /** Two semitone steps. */
  MAJOR_SECOND(2, 1),

  /** Three semitone steps (the third of a {@link TonalSystem#MINOR minor} {@link Chord} or {@link MusicalKey key}). */
  MINOR_THIRD(3, 2),

  /** Three semitone steps (the third of a {@link TonalSystem#MAJOR major} {@link Chord} or {@link MusicalKey key}). */
  MAJOR_THIRD(4, 2),

  /** Five semitone steps. Same as {@link DiatonicInterval#FOURTH} also called <em>quartum</em>. */
  PERFECT_FOURTH(5, 3),

  /** Six semitone steps. */
  DIMINISHED_FIFTH(6, 4),

  /**
   * Seven semitone steps. Same as {@link DiatonicInterval#FIFTH} also called <em>quintium</em>, the total interval of a
   * regular {@link TonalSystem#MAJOR major} or {@link TonalSystem#MINOR minor} {@link Chord}.
   */
  PERFECT_FIFTH(7, 4),

  /** Eight semitone steps. */
  MINOR_SIXT(8, 5),

  /** Nine semitone steps. */
  MAJOR_SIXT(9, 5),

  /**
   * Ten semitone steps. The regular {@link DiatonicInterval#SEVENTH seventh} used e.g. for {@link ChordExtension#_7}.
   * Especially important for dominant {@link Chord}s.
   */
  MINOR_SEVENTH(10, 6),

  /** Eigth semitone steps. */
  MAJOR_SEVENTH(11, 6),

  /** Twelve semitone steps. Results in the logically same {@link TonePitch} on a higher octave. */
  PERFECT_OCTAVE(12, 7),

  /** Thirteen semitone steps. */
  MINOR_NINTH(13, 8),

  /** Fourteen semitone steps. */
  MAJOR_NINTH(14, 8),

  /** Fifteen semitone steps. */
  MINOR_TENTH(15, 9),

  /** Sixteen semitone steps. */
  MAJOR_TENTH(16, 9),

  /** Seventeen semitone steps. */
  PERFECT_ELEVENTH(17, 10),

  /** Eighteen semitone steps. */
  DIMINISHED_TWELVE(18, 11),

  /** Nineteen semitone steps. */
  PERFECT_TWELVE(19, 11),

  /** Twenty semitone steps. */
  MINOR_THIRTEENTH(20, 12),

  /** Twenty-one semitone steps. */
  MAJOR_THIRTEENTH(21, 12);

  private final int chromaticSteps;

  private final int diatonicSteps;

  private ChromaticInterval(int chromatic, int diatonic) {

    this.chromaticSteps = chromatic;
    this.diatonicSteps = diatonic;
  }

  /**
   * @see #getChromaticSteps(TonalSystem)
   *
   * @return the number of semitone steps.
   */
  public int getChromaticSteps() {

    return this.chromaticSteps;
  }

  /**
   * @see #getDiatonicSteps(TonalSystem)
   *
   * @return the number of diatonic steps.
   */
  public int getDiatonicSteps() {

    return this.diatonicSteps;
  }

  @Override
  public Integer getChromaticSteps(TonalSystem system) {

    return Integer.valueOf(this.chromaticSteps);
  }

  @Override
  public Integer getDiatonicSteps(TonalSystem system) {

    return Integer.valueOf(this.diatonicSteps);
  }

  /**
   * @param chromaticSteps the number of {@link #getChromaticSteps() chromatic steps}.
   * @return the corresponding {@link ChromaticInterval} or <code>null</code> if no such {@link ChromaticInterval}
   *         exists (given value is negative or too high).
   */
  public static ChromaticInterval fromChromaticSteps(int chromaticSteps) {

    for (ChromaticInterval interval : values()) {
      if (interval.chromaticSteps == chromaticSteps) {
        return interval;
      }
    }
    return null;
  }

}
