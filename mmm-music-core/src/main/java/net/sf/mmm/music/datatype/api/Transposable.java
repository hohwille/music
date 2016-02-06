/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * This is the interface for a musical object that can be transposed.
 *
 * @param <SELF> the generic type of this object itself.
 *
 * @author hohwille
 */
public interface Transposable<SELF> {

  /**
   * This method transposes this object by the given number of <code>semitoneSteps</code> wrapping {@link TonePitch}es
   * within the {@link MusicalKey#getChromaticScale() chromatic scale} and using the given {@link EnharmonicStyle style}
   * for enharmonic changes.
   *
   * @param semitoneSteps is the number of semitone steps to transpose. A positive value transposes towards a higher
   *        pitch, a negative value transposes towards a lower pitch. A value of zero ({@code 0}) will cause no change
   *        of the {@link TonePitch#getStep() step}. {@link TonePitch}es will wrap modulo {@code 12}.
   * @param style the {@link EnharmonicStyle}.
   * @return the transposed and {@link TonePitch#isNormal() normalized} instance.
   */
  SELF transposeChromatic(int semitoneSteps, EnharmonicStyle style);

  /**
   * This method transposes this object by the given number of <code>semitoneSteps</code> wrapping {@link TonePitch}es
   * within the {@link MusicalKey#getChromaticScale() chromatic scale} of the given {@link MusicalKey}.
   *
   * @see #transposeChromatic(int, EnharmonicStyle)
   *
   * @param semitoneSteps is the number of semitone steps to transpose. A positive value transposes towards a higher
   *        pitch, a negative value transposes towards a lower pitch. A value of zero ({@code 0}) will cause no change
   *        of the {@link TonePitch#getStep() step}. {@link TonePitch}es will wrap modulo {@code 12}.
   * @param targetKey is the target {@link MusicalKey key}.
   * @return the transposed {@link TonePitch} with enharmonic change according to the given {@link MusicalKey}.
   */
  SELF transposeChromatic(int semitoneSteps, MusicalKey targetKey);

  /**
   * This method transposes this object by the given number of <code>diatonicSteps</code> wrapping {@link TonePitch}es
   * within the {@link MusicalKey#getDiatonicScale() diatonic scale} of the given {@link MusicalKey}.
   *
   * @see #transposeChromatic(int, EnharmonicStyle)
   *
   * @param diatonicSteps is the number of semitone steps to transpose. A positive value transposes towards a higher
   *        pitch, a negative value transposes towards a lower pitch. A value of zero ({@code 0}) will cause no change
   *        of the {@link TonePitch#getStep() step}. {@link TonePitch}es will wrap modulo {@code 8}.
   * @param targetKey is the target {@link MusicalKey key}.
   * @return the transposed instance with enharmonic change according to the given {@link MusicalKey}.
   */
  SELF transposeDiatonic(int diatonicSteps, MusicalKey targetKey);

  /**
   * Transposes this object by the given {@link Interval} within the given {@link MusicalKey}.
   *
   * @param interval is the {@link Interval} such as e.g. {@link Solmization#MI}, {@link ChromaticInterval#MAJOR_THIRD},
   *        or {@link DiatonicInterval#THIRD}.
   * @param targetKey is the target {@link MusicalKey key}.
   * @return the transposed instance.
   */
  default SELF transpose(Interval interval, MusicalKey targetKey) {

    TonalSystem system = targetKey.getTonalSystem();
    Integer chromaticSteps = interval.getChromaticSteps(system);
    if (chromaticSteps != null) {
      return transposeChromatic(chromaticSteps.intValue(), targetKey);
    }
    Integer diatonicSteps = interval.getDiatonicSteps(system);
    if (diatonicSteps != null) {
      return transposeDiatonic(diatonicSteps.intValue(), targetKey);
    }
    throw new IllegalArgumentException(interval.toString());
  }
}
