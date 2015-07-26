/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This enum represents a musical key. It represents a {@link #getDiatonicScale() diatonic scale} based on a fundamental
 * tone (called {@link #getTonika() tonika}) and a {@link #getTonalSystem() tonal system}.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public enum MusicalKey {

  /**
   * The {@link MusicalKey} Ces-{@link TonalSystem#MAJOR major} (with 7 &#9837; signs).
   */
  CES_MAJOR(TonePitch.CES, TonalSystem.MAJOR, "Ces"),

  /**
   * The {@link MusicalKey} as-{@link TonalSystem#MINOR minor} (with 7 &#9837; signs).
   */
  AS_MINOR(TonePitch.AS, TonalSystem.MINOR, "as"),

  /**
   * The {@link MusicalKey} Ges-{@link TonalSystem#MAJOR major} (with 6 &#9837; signs).
   */
  GES_MAJOR(TonePitch.GES, TonalSystem.MAJOR, "Ges"),

  /**
   * The {@link MusicalKey} es-{@link TonalSystem#MINOR minor} (with 6 &#9837; signs).
   */
  ES_MINOR(TonePitch.ES, TonalSystem.MINOR, "es"),

  /**
   * The {@link MusicalKey} Des-{@link TonalSystem#MAJOR major} (with 5 &#9837; signs).
   */
  DES_MAJOR(TonePitch.DES, TonalSystem.MAJOR, "Des"),

  /**
   * The {@link MusicalKey} b&#9837;-{@link TonalSystem#MINOR minor} (with 5 &#9837; signs).
   */
  B_MINOR(TonePitch.B_FLAT, TonalSystem.MINOR, "b\u266D"),

  /**
   * The {@link MusicalKey} As-{@link TonalSystem#MAJOR major} (with 4 &#9837; signs).
   */
  AS_MAJOR(TonePitch.AS, TonalSystem.MAJOR, "As"),

  /**
   * The {@link MusicalKey} f-{@link TonalSystem#MINOR minor} (with 4 &#9837; signs).
   */
  F_MINOR(TonePitch.F, TonalSystem.MINOR, "f"),

  /**
   * The {@link MusicalKey} Es-{@link TonalSystem#MAJOR major} (with 3 &#9837; signs).
   */
  ES_MAJOR(TonePitch.ES, TonalSystem.MAJOR, "Es"),

  /**
   * The {@link MusicalKey} c-{@link TonalSystem#MINOR minor} (with 3 &#9837; signs).
   */
  C_MINOR(TonePitch.C, TonalSystem.MINOR, "c"),

  /**
   * The {@link MusicalKey} B&#9837;-{@link TonalSystem#MAJOR major} (with 2 &#9837; signs).
   */
  B_MAJOR(TonePitch.B_FLAT, TonalSystem.MAJOR, "Bb"),

  /**
   * The {@link MusicalKey} g-{@link TonalSystem#MINOR minor} (with 2 &#9837; signs).
   */
  G_MINOR(TonePitch.G, TonalSystem.MINOR, "g"),

  /**
   * The {@link MusicalKey} F-{@link TonalSystem#MAJOR major} (with 1 &#9837; signs).
   */
  F_MAJOR(TonePitch.F, TonalSystem.MAJOR, "F"),

  /**
   * The {@link MusicalKey} d-{@link TonalSystem#MINOR minor} (with 1 &#9837; signs).
   */
  D_MINOR(TonePitch.D, TonalSystem.MINOR, "d"),

  /**
   * The {@link MusicalKey} C-{@link TonalSystem#MAJOR major} (without any signs).
   */
  C_MAJOR(TonePitch.C, TonalSystem.MAJOR, "C"),

  /**
   * The {@link MusicalKey} a-{@link TonalSystem#MINOR minor} (without any signs).
   */
  A_MINOR(TonePitch.A, TonalSystem.MINOR, "a"),

  /**
   * The {@link MusicalKey} G-{@link TonalSystem#MAJOR major} (with 1 &#9839; signs).
   */
  G_MAJOR(TonePitch.G, TonalSystem.MAJOR, "G"),

  /**
   * The {@link MusicalKey} e-{@link TonalSystem#MINOR minor} (with 1 &#9839; signs).
   */
  E_MINOR(TonePitch.E, TonalSystem.MINOR, "e"),

  /**
   * The {@link MusicalKey} D-{@link TonalSystem#MAJOR major} (with 2 &#9839; signs).
   */
  D_MAJOR(TonePitch.D, TonalSystem.MAJOR, "D"),

  /**
   * The {@link MusicalKey} b&#9838;-{@link TonalSystem#MINOR minor} (with 2 &#9839; signs).
   */
  H_MINOR(TonePitch.H, TonalSystem.MINOR, "b\u266E"),

  /**
   * The {@link MusicalKey} A-{@link TonalSystem#MAJOR major} (with 3 &#9839; signs).
   */
  A_MAJOR(TonePitch.A, TonalSystem.MAJOR, "A"),

  /**
   * The {@link MusicalKey} fis-{@link TonalSystem#MINOR minor} (with 3 &#9839; signs).
   */
  FIS_MINOR(TonePitch.FIS, TonalSystem.MINOR, "fis"),

  /**
   * The {@link MusicalKey} E-{@link TonalSystem#MAJOR major} (with 4 &#9839; signs).
   */
  E_MAJOR(TonePitch.E, TonalSystem.MAJOR, "E"),

  /**
   * The {@link MusicalKey} cis-{@link TonalSystem#MINOR minor} (with 4 &#9839; signs).
   */
  CIS_MINOR(TonePitch.CIS, TonalSystem.MINOR, "cis"),

  /**
   * The {@link MusicalKey} B&#9838;-{@link TonalSystem#MAJOR major} (with 5 &#9839; signs).
   */
  H_MAJOR(TonePitch.H, TonalSystem.MAJOR, "B\u266E"),

  /**
   * The {@link MusicalKey} gis-{@link TonalSystem#MINOR minor} (with 5 &#9839; signs).
   */
  GIS_MINOR(TonePitch.GIS, TonalSystem.MINOR, "gis"),

  /**
   * The {@link MusicalKey} Fis-{@link TonalSystem#MAJOR major} (with 6 &#9839; signs).
   */
  FIS_MAJOR(TonePitch.FIS, TonalSystem.MAJOR, "Fis"),

  /**
   * The {@link MusicalKey} dis-{@link TonalSystem#MINOR minor} (with 6 &#9839; signs).
   */
  DIS_MINOR(TonePitch.DIS, TonalSystem.MINOR, "dis"),

  /**
   * The {@link MusicalKey} Cis-{@link TonalSystem#MAJOR major} (with 7 &#9839; signs). The enharmonic identical
   * {@link MusicalKey key} is {@link #DES_MAJOR}.
   */
  CIS_MAJOR(TonePitch.CIS, TonalSystem.MAJOR, "Cis"),

  /**
   * The {@link MusicalKey} ais-{@link TonalSystem#MAJOR major} (with 7 &#9839; signs). The enharmonic identical
   * {@link MusicalKey key} is {@link #B_MINOR}.
   */
  AIS_MINOR(TonePitch.AIS, TonalSystem.MINOR, "ais");

  /** @see #getTonika() */
  private final TonePitch tonika;

  /** @see #getTonalSystem() */
  private final TonalSystem tonalSystem;

  /** @see #getName() */
  private final String name;

  /** @see #getEnharmonicStyle() */
  private final EnharmonicStyle enharmonicStyle;

  /** @see #getDiatonicScale() */
  private final List<TonePitch> tonesDiatonic;

  /** @see #getChromaticScale() */
  private final List<TonePitch> tonesChromatic;

  /** @see #getChromaticSignTones() */
  private final List<TonePitch> chromaticSignTones;

  /**
   * The constructor.
   *
   * @param tonika - see {@link #getTonika()}.
   * @param tonalSystem - see {@link #getTonalSystem()}.
   * @param name - see {@link #getName()}.
   */
  private MusicalKey(TonePitch tonika, TonalSystem tonalSystem, String name) {

    this.tonika = tonika;
    this.tonalSystem = tonalSystem;
    this.name = name;

    // determine chromaticSignTones
    EnharmonicStyle style = EnharmonicStyle.NORMAL;
    int pos = (ordinal() / 2);
    int flatSigns = 7 - pos;
    int sharpSigns = pos - 7;
    List<TonePitch> chromaticSigns = new ArrayList<>(7);
    if (flatSigns > 0) {
      style = EnharmonicStyle.FLAT;
      List<TonePitch> flatSignTones = TonePitch.getFlatSignTones();
      for (int i = 0; i < flatSigns; i++) {
        chromaticSigns.add(flatSignTones.get(i));
      }
    } else if (sharpSigns > 0) {
      style = EnharmonicStyle.SHARP;
      List<TonePitch> sharpSignTones = TonePitch.getSharpSignTones();
      for (int i = 0; i < sharpSigns; i++) {
        chromaticSigns.add(sharpSignTones.get(i));
      }
    }
    this.enharmonicStyle = style;
    this.chromaticSignTones = Collections.unmodifiableList(chromaticSigns);

    // determine tonesDiatoic and tonesChromatic
    List<TonePitch> diatonic = new ArrayList<>(7);
    List<TonePitch> chromatic = new ArrayList<>(12);
    TonePitch tone = tonika;
    boolean addDiatonic = true;
    int firstSemitone = tonalSystem.getFirstSemitone();
    int secondSemitone = tonalSystem.getSecondSemitone();
    for (int i = 0; i < 12; i++) {
      if (addDiatonic) {
        diatonic.add(tone);
      }
      chromatic.add(tone);
      TonePitch nextTone = tone.transposeChromatic(1, style);
      for (TonePitch signTone : this.chromaticSignTones) {
        if (signTone.getStep() == nextTone.getStep()) {
          nextTone = signTone;
          break;
        }
      }
      tone = nextTone;
      int size = diatonic.size();
      if (!addDiatonic || ((size != firstSemitone) && (size != secondSemitone))) {
        addDiatonic = !addDiatonic;
      }
    }
    assert (chromatic.size() == 12);
    this.tonesChromatic = Collections.unmodifiableList(chromatic);
    assert (diatonic.size() == 7);
    this.tonesDiatonic = Collections.unmodifiableList(diatonic);
  }

  /**
   * @return the textual representation in short form (Capitalized for {@link TonalSystem#MAJOR major} and lower case
   *         for {@link TonalSystem#MINOR minor}).
   */
  public String getName() {

    return this.name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {

    return getName() + "-" + this.tonalSystem.toString();
  }

  /**
   * This method gets the {@link TonalSystem} of this key.
   *
   * @return the {@link TonalSystem}.
   */
  public TonalSystem getTonalSystem() {

    return this.tonalSystem;
  }

  /**
   * This method gets the {@link TonePitch} of the tonika (base-tone) for this key.
   *
   * @return the {@link TonePitch}.
   */
  public TonePitch getTonika() {

    return this.tonika;
  }

  /**
   * @return the {@link List} with the seven {@link TonePitch}es of the {@link TonalSystem} for this {@link MusicalKey}
   *         starting from {@link #getTonika() tonika}.
   */
  public List<TonePitch> getDiatonicScale() {

    return this.tonesDiatonic;
  }

  /**
   * @return the {@link List} with twelve {@link TonePitch}es of the chromatic scale for this {@link MusicalKey}
   *         starting from {@link #getTonika() tonika}.
   */
  public List<TonePitch> getChromaticScale() {

    return this.tonesChromatic;
  }

  /**
   * @return the {@link List} with the {@link TonePitch tones} for the chromatic signs of this {@link MusicalKey}. Will
   *         be empty for {@link #C_MAJOR} or {@link #A_MINOR}. Will contain only {@link TonePitch#isSharp() sharp} or
   *         only {@link TonePitch#isFlat() flat} {@link TonePitch tones}. E.g. for {@link #D_MAJOR} it will contain
   *         {@link TonePitch#FIS} and {@link TonePitch#CIS} and for {@link #C_MINOR} it will contain
   *         {@link TonePitch#B_FLAT}, {@link TonePitch#ES}, {@link TonePitch#AS}.
   */
  public List<TonePitch> getChromaticSignTones() {

    return this.chromaticSignTones;
  }

  /**
   * @return the {@link EnharmonicStyle}. {@link EnharmonicStyle#NORMAL} for {@link #C_MAJOR} and {@link #A_MINOR}.
   *         {@link EnharmonicStyle#SHARP} if the {@link #getChromaticSignTones() chromatic sign tones} are
   *         {@link TonePitch#isSharp() sharp}. {@link EnharmonicStyle#FLAT} if the {@link #getChromaticSignTones()
   *         chromatic sign tones} are {@link TonePitch#isFlat() flat}.
   */
  public EnharmonicStyle getEnharmonicStyle() {

    return this.enharmonicStyle;
  }

  /**
   * Transposes this {@link MusicalKey}.
   *
   * @param semitoneSteps is the number of semitone steps to transpose. A positive value transposes towards a higher
   *        pitch, a negative value transposes towards a lower pitch. A value of zero (<code>0</code>) will have no
   *        change.
   * @return the transposed {@link MusicalKey}.
   */
  public MusicalKey transposeChromatic(int semitoneSteps) {

    TonePitch newTonika = this.tonika.transposeChromatic(semitoneSteps, this.enharmonicStyle);
    for (MusicalKey key : values()) {
      if (key.tonalSystem == this.tonalSystem) {
        if (key.tonika == newTonika) {
          return key;
        }
      }
    }
    throw new IllegalStateException(toString() + "+" + semitoneSteps);
  }

  /**
   * This method gets the {@link MusicalKey} for the given <code>value</code>.
   *
   * @param value is the {@link #getName() value} of the requested {@link MusicalKey}.
   * @return the requested {@link MusicalKey} or <code>null</code> if no such {@link MusicalKey} exists.
   */
  public static MusicalKey fromString(String value) {

    for (MusicalKey instance : values()) {
      if (instance.name.equals(value)) {
        return instance;
      }
    }
    return null;
  }

}
