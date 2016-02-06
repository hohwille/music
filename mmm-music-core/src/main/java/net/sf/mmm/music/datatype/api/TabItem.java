/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * @author hohwille
 *
 */
public class TabItem extends ToneItem {

  private final Tone stringBaseTone;

  private int fret;

  /**
   * The constructor.
   *
   * @param value - the {@link #getValue() value}.
   * @param tone - the {@link #getTone() tone}.
   * @param fret - the {@link #getFret() fret}.
   * @param stringBaseTone - the {@link #getStringBaseTone() string base tone}.
   */
  public TabItem(MusicalValue value, Tone tone, int fret, Tone stringBaseTone) {

    super(value, tone);
    this.stringBaseTone = stringBaseTone;
    this.fret = fret;
  }

  /**
   * The constructor.
   *
   * @param value - the {@link #getValue() value}.
   * @param tone - the {@link #getTone() tone}.
   * @param fret - the {@link #getFret() fret}.
   */
  public TabItem(MusicalValue value, Tone tone, int fret) {

    this(value, tone, fret, tone.transposeChromatic(-fret, EnharmonicStyle.NORMAL));
  }

  /**
   * The constructor.
   *
   * @param value - the {@link #getValue() value}.
   * @param fret - the {@link #getFret() fret}.
   * @param stringBaseTone - the {@link #getStringBaseTone() string base tone}.
   */
  public TabItem(MusicalValue value, int fret, Tone stringBaseTone) {

    this(value, stringBaseTone.transposeChromatic(fret, EnharmonicStyle.NORMAL), fret, stringBaseTone);
  }

  /**
   * @return the fret which actually represents the {@link Interval#getChromaticSteps(TonalSystem) chromatic interval}
   *         of the {@link #getTone() tone} relative to the {@link #getStringBaseTone() string base tone}. Should not be
   *         negative.
   */
  public int getFret() {

    return this.fret;
  }

  /**
   * @return the base {@link Tone} of the string to be played at the specified {@link #getFret() fret} for this
   *         {@link TabItem}.
   */
  public Tone getStringBaseTone() {

    return this.stringBaseTone;
  }

  @Override
  public TabItem transpose(Interval interval, MusicalKey targetKey) {

    return (TabItem) super.transpose(interval, targetKey);
  }

  @Override
  public TabItem transposeChromatic(int semitoneSteps, EnharmonicStyle style) {

    return new TabItem(getValue(), getTone().transposeChromatic(semitoneSteps, style), this.fret,
        this.stringBaseTone.transposeChromatic(semitoneSteps, style));
  }

  @Override
  public ToneItem transposeChromatic(int semitoneSteps, MusicalKey targetKey) {

    return new TabItem(getValue(), getTone().transposeChromatic(semitoneSteps, targetKey), this.fret,
        this.stringBaseTone.transposeChromatic(semitoneSteps, targetKey));
  }

  @Override
  public ToneItem transposeDiatonic(int diatonicSteps, MusicalKey targetKey) {

    return new TabItem(getValue(), getTone().transposeDiatonic(diatonicSteps, targetKey), this.fret,
        this.stringBaseTone.transposeDiatonic(diatonicSteps, targetKey));
  }

}
