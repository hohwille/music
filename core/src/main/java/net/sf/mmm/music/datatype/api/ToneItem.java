/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * {@link MusicalItem} for a {@link Tone}.
 *
 * @author hohwille
 */
public class ToneItem extends MusicalItem implements Transposable<ToneItem> {

  private final Tone tone;

  /**
   * The constructor.
   *
   * @param value - the {@link #getValue() value}.
   * @param tone - the {@link #getTone() tone}.
   */
  public ToneItem(MusicalValue value, Tone tone) {

    super(value);
    this.tone = tone;
  }

  @Override
  public Tone getTone() {

    return this.tone;
  }

  @Override
  public ToneItem transposeChromatic(int semitoneSteps, EnharmonicStyle style) {

    return new ToneItem(getValue(), this.tone.transposeChromatic(semitoneSteps, style));
  }

  @Override
  public ToneItem transposeChromatic(int semitoneSteps, MusicalKey targetKey) {

    return new ToneItem(getValue(), this.tone.transposeChromatic(semitoneSteps, targetKey));
  }

  @Override
  public ToneItem transposeDiatonic(int diatonicSteps, MusicalKey targetKey) {

    return new ToneItem(getValue(), this.tone.transposeChromatic(diatonicSteps, targetKey));
  }

}
