/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * Solmization is a system of attributing a distinct syllable to each note in a {@link MusicalKey#getDiatonicScale()
 * musical scale}. In general there are different variants of solmization grown over history. However, the most
 * interesting is the relative solmization that associates tones of a {@link MusicalKey#getDiatonicScale() scale} with
 * syllables and is therefore independent of a {@link MusicalKey}.<br/>
 * So for a {@link TonalSystem#MAJOR major} {@link MusicalKey#getDiatonicScale() scale} the {@link Solmization} order is
 * {@link #DO}, {@link #RE}, {@link #MI}, {@link #FA}, {@link #SO}, {@link #LA}, {@link #TI}. In
 * {@link MusicalKey#C_MAJOR C-major} this would be equivalent to {@link TonePitch#C C}, {@link TonePitch#D D},
 * {@link TonePitch#E E}, {@link TonePitch#F F}, {@link TonePitch#G G}, {@link TonePitch#A A}, {@link TonePitch#H H}.<br/>
 * For a {@link TonalSystem#MINOR minor} {@link MusicalKey#getDiatonicScale() scale} the {@link Solmization} order is
 * {@link #LA}, {@link #TI}, {@link #DO}, {@link #RE}, {@link #MI}, {@link #FA}, {@link #SO}. In
 * {@link MusicalKey#A_MINOR A-minor} this would be equivalent to {@link TonePitch#A A}, {@link TonePitch#H H},
 * {@link TonePitch#C C}, {@link TonePitch#D D}, {@link TonePitch#E E}, {@link TonePitch#F F}, {@link TonePitch#G G}.<br/>
 *
 * @author hohwille
 */
public enum Solmization {

  /**
   * The first tone in case of a {@link TonalSystem#MAJOR major} and the third tone in case of a
   * {@link TonalSystem#MINOR minor} {@link MusicalKey#getDiatonicScale() scale}.
   */
  DO(0, 4),

  /**
   * The second tone in case of a {@link TonalSystem#MAJOR major} and the fourth tone in case of a
   * {@link TonalSystem#MINOR minor} {@link MusicalKey#getDiatonicScale() scale}.
   */
  RE(2, 5),

  /**
   * The third tone in case of a {@link TonalSystem#MAJOR major} and the fifth tone in case of a
   * {@link TonalSystem#MINOR minor} {@link MusicalKey#getDiatonicScale() scale}.
   */
  MI(4, 7),

  /**
   * The fourth tone in case of a {@link TonalSystem#MAJOR major} and the sixth tone in case of a
   * {@link TonalSystem#MINOR minor} {@link MusicalKey#getDiatonicScale() scale}.
   */
  FA(5, 9),

  /**
   * The fifth tone in case of a {@link TonalSystem#MAJOR major} and the seventh tone in case of a
   * {@link TonalSystem#MINOR minor} {@link MusicalKey#getDiatonicScale() scale}. It may also be called sol instead of
   * so.
   */
  SO(7, 11),

  /**
   * The sixth tone in case of a {@link TonalSystem#MAJOR major} and the first tone in case of a
   * {@link TonalSystem#MINOR minor} {@link MusicalKey#getDiatonicScale() scale}.
   */
  LA(9, 0),

  /**
   * The seventh tone in case of a {@link TonalSystem#MAJOR major} and the second tone in case of a
   * {@link TonalSystem#MINOR minor} {@link MusicalKey#getDiatonicScale() scale}.
   */
  TI(11, 2);

  /** @see #getMajorChromaticSteps() */
  private final int majorChromaticSteps;

  /** @see #getMinorChromaticSteps() */
  private final int minorChromaticSteps;

  private Solmization(int majorStep, int minorStep) {

    this.majorChromaticSteps = majorStep;
    this.minorChromaticSteps = minorStep;
  }

  /**
   * @return the number of semitone steps from {@link MusicalKey#getTonika() tonika} in a {@link TonalSystem#MAJOR
   *         major} {@link MusicalKey#getDiatonicScale() scale}.
   */
  public int getMajorChromaticSteps() {

    return this.majorChromaticSteps;
  }

  /**
   * @return the number of semitone steps from {@link MusicalKey#getTonika() tonika} in a {@link TonalSystem#MINOR
   *         minor} {@link MusicalKey#getDiatonicScale() scale}.
   */
  public int getMinorChromaticSteps() {

    return this.minorChromaticSteps;
  }

  /**
   * @return the number of diatonic steps from {@link MusicalKey#getTonika() tonika} in a {@link TonalSystem#MAJOR
   *         major} {@link MusicalKey#getDiatonicScale() scale}.
   */
  public int getMajorDiatonicSteps() {

    return (this.majorChromaticSteps + 1) / 2;
  }

  /**
   * @return the number of diatonic steps from {@link MusicalKey#getTonika() tonika} in a {@link TonalSystem#MINOR
   *         minor} {@link MusicalKey#getDiatonicScale() scale}.
   */
  public int getMinorDiatonicSteps() {

    return (this.minorChromaticSteps + 1) / 2;
  }

}
