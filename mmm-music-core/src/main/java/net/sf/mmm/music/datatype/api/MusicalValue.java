/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import java.util.Objects;

/**
 * The value of a {@link Tone} or rest.
 *
 * @author hohwille
 */
public class MusicalValue implements Fraction {

  /**
   * Whole (1/1). Unlike other predefined {@link MusicalValue}s this value does not have a fixed length in
   * {@link #QUARTER quarters} but lasts a full bar whatever the {@link Beat} may be. This is used for a whole rest that
   * lasts a full bar (instead of {@link #SEMIBREVE}).
   */
  public static final MusicalValue WHOLE = new MusicalValue(1, 1);

  /**
   * Whole (4/4) tone.
   *
   * @see #WHOLE
   */
  public static final MusicalValue SEMIBREVE = new MusicalValue(4, 4);

  /** Half (1/2). */
  public static final MusicalValue MINIM = new MusicalValue(2, 4);

  /** Fourth (1/4) also called <em>crotchet</em>. */
  public static final MusicalValue QUARTER = new MusicalValue(1, 4);

  /** Eighth (1/8). */
  public static final MusicalValue QUAVER = new MusicalValue(1, 8);

  /** Sixteenth (1/16). */
  public static final MusicalValue SEMIQUAVER = new MusicalValue(1, 16);

  /** Thirtysecondth (1/32). */
  public static final MusicalValue DEMISEMIQUAVER = new MusicalValue(1, 32);

  private final int beats;

  private final int fraction;

  private final Variation variation;

  /**
   * The constructor.
   *
   * @param beats - see {@link #getBeats()}.
   * @param fraction - see {@link #getFaction()}.
   */
  public MusicalValue(int beats, int fraction) {

    this(beats, fraction, Variation.NONE);
  }

  /**
   * The constructor.
   *
   * @param beats - see {@link #getBeats()}.
   * @param fraction - see {@link #getFaction()}.
   * @param variation - see {@link #getVariation()}.
   */
  public MusicalValue(int beats, int fraction, Variation variation) {

    super();
    Objects.requireNonNull(variation, "variation");
    this.beats = beats;
    this.fraction = fraction;
    this.variation = variation;
  }

  @Override
  public int getBeats() {

    return this.beats;
  }

  @Override
  public int getFaction() {

    return this.fraction;
  }

  /**
   * @return the {@link Variation} of this {@link MusicalValue}.
   */
  public Variation getVariation() {

    return this.variation;
  }

  /**
   * Determines if this value is relative. E.g. a {@link #SEMIBREVE} (whole value, 1/1) is often consider to be
   * equivalent to 4/4 as 4 times a {@link #QUARTER}, what is actually wrong.
   *
   * @return {@code true} if {@link #getFaction() fraction} is {@code 1} and the value is relative to the {@link Beat},
   *         {@code false} otherwise.
   */
  public boolean isRelative() {

    return (this.fraction == 1);
  }

  /**
   * @return {@code true} if NOT {@link #isRelative() relative} (absolute), <code>false</code> otherwise.
   */
  public boolean isAbsolute() {

    return !isRelative();
  }

  /**
   * @return {@code true} if {@link #getVariation() variation} is {@link Variation#NONE}, {@code false} otherwise.
   */
  public boolean isNormalized() {

    return this.variation == Variation.NONE;
  }

  /**
   * @param beat the {@link Beat} used as base to make this {@link MusicalValue} absolute.
   * @return the {@link #isAbsolute() absolute} {@link MusicalValue} according to the given {@link Beat}. Will return
   *         the current {@link MusicalValue} ({@code this}) if already {@link #isAbsolute() absolute}.
   */
  public MusicalValue toAbsoluteValue(Beat beat) {

    if (this.fraction == 1) {
      return new MusicalValue(beat.getBeats() * this.beats, beat.getFaction(), this.variation);
    }
    return this;
  }

  /**
   * @return the normalized {@link Fraction fraction} of this {@link MusicalValue} so that {@link #getVariation()
   *         variation} is {@link Variation#NONE}. Will return the current {@link MusicalValue} ({@code this}) if
   *         already {@link #isNormalized() normalized}.
   */
  public MusicalValue toNormalizedValue() {

    if (this.variation == Variation.NONE) {
      return this;
    }
    return new MusicalValue(this.variation.beats * this.beats, this.variation.fraction * this.fraction);
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
    MusicalValue other = (MusicalValue) obj;
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

  /**
   * A {@link Variation} is a {@link Fraction} that modifies a {@link MusicalValue}. There are particular symbols to
   * visualize a {@link Variation} in a partiture.
   */
  public enum Variation implements Fraction {

    /** No variation. */
    NONE(1, 1),

    /**
     * Increases the {@link MusicalValue} by adding half of its value. Visualized as a single dot right to the musical
     * symbol.
     */
    PUNCTURED(3, 2),

    /**
     * Like {@link #PUNCTURED} but additionally adding a quarter of the value. Visualized as a double dot right to the
     * musical symbol.
     */
    DOUBLE_PUNCTURED(7, 4),

    /**
     * Increases the {@link MusicalValue} such that three tones of that value actually last as long as two {@link #NONE
     * regular} ones. Visualized as a small three ({@code 3} centered below or on top of the tones. Typically used with
     * barred tones otherwise a bar-bracket is added to group the tones.
     */
    TRIPLET(2, 3);

    private final int beats;

    private final int fraction;

    private Variation(int beats, int fraction) {

      this.beats = beats;
      this.fraction = fraction;
    }

    @Override
    public int getBeats() {

      return this.beats;
    }

    @Override
    public int getFaction() {

      return this.fraction;
    }

  }

}
