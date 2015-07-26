/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * @author hohwille
 *
 */
public enum ChromaticInterval {

  PERFECT_UNISON(0),

  MINOR_SECOND(1),

  MAJOR_SECOND(2),

  MINOR_THIRD(3),

  MAJOR_THIRD(4),

  PERFECT_FOURTH(5),

  DIMINISHED_FIFTH(6),

  PERFECT_FIFTH(7),

  MINOR_SIXT(8),

  MAJOR_SIXT(9),

  MINOR_SEVENTH(10),

  MAJOR_SEVENTH(11),

  PERFECT_OCTAVE(12),

  MINOR_NINTH(13),

  MAJOR_NINTH(14),

  MINOR_TENTH(15),

  MAJOR_TENTH(16),

  PERFECT_ELEVENTH(17),

  DIMINISHED_TWELVE(18),

  PERFECT_TWELVE(19),

  MINOR_THIRTEENTH(20),

  MAJOR_THIRTEENTH(21);

  private final int step;

  private ChromaticInterval(int step) {

    this.step = step;
  }

  /**
   * @return the step
   */
  public int getStep() {

    return this.step;
  }

}
