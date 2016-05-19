/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * A {@link Beat} indicates the {@link MusicalValue} of a single bar in a {@link net.sf.mmm.music.partiture.MusicStaff}.
 * E.g. a {@link #_4_4 4/4} beat allows to fit 4 {@link MusicalValue#QUARTER quarters} into one bar.<br/>
 * The {@link #getFaction() fraction} indicates the unit of a regular beat. Therefore a {@link #_4_4 4/4} beat is not
 * the same as a {@link #_2_2 2/2} beat even though they can cover the same {@link MusicalValue}s per bar.
 *
 * @author hohwille
 */
public class Beat implements Fraction {

  /** A 3/4 beat. */
  public static final Beat _3_4 = new Beat(3, 4);

  /** A 4/4 beat. */
  public static final Beat _4_4 = new Beat(4, 4);

  /** A 2/2 beat. */
  public static final Beat _2_2 = new Beat(2, 2);

  /** A 3/4 beat. */
  public static final Beat _6_8 = new Beat(6, 8);

  private final int beats;

  private final int fraction;

  private Beat(int beats, int perUnit) {

    this.beats = beats;
    this.fraction = perUnit;
  }

  @Override
  public int getBeats() {

    return this.beats;
  }

  @Override
  public int getFaction() {

    return this.fraction;
  }

  @Override
  public int hashCode() {

    return 31 * this.beats + this.fraction;
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
    Beat other = (Beat) obj;
    if (this.beats != other.beats) {
      return false;
    }
    if (this.fraction != other.fraction) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {

    return this.beats + "/" + this.fraction;
  }

}
