/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * This enum represents the {@link TonePitch} of a musical note. It is based on the twelve tone music system and only
 * represents a single octave instead of an absolute pitch value.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public enum TonePitch {

  /**
   * <code>C</code> is the {@link MusicalKey#getTonika() tonika} (base tone) of the common {@link MusicalKey#C_MAJOR}
   * key.
   */
  C("C", "C", "C", 0, null),

  /** <code>H&#9839;</code> (H#) is the sharpened enharmonic change of {@link #C}. */
  HIS("H\u266F", "H#", "His", 0, C),

  /** <code>D&#119083;<code> (Dbb) is the flattened enharmonic change of {@link #C}. */
  DESES("D\uD834\uDD2B", "Dbb", "Deses", 0, C),

  /** <code>C&#9839;</code> (C#) is a semitone (half step) higher than the pitch {@link #C}. */
  CIS("C\u266F", "C#", "Cis", 1, null),

  /** <code>H&#119082;</code> (H##) is the sharpened enharmonic change of {@link #CIS}. */
  HISIS("H\uD834\uDD2A", "H##", "Hisis", 1, CIS),

  /** <code>D&#9837;</code> (Db) is the flattened enharmonic change of {@link #CIS}. */
  DES("D\u266D", "Db", "Des", 1, CIS),

  /** <code>D</code> is two semitones (half steps) higher than the pitch {@link #C}. */
  D("D", "D", "D", 2, null),

  /** <code>C&#119082;</code> (C##) is the sharpened enharmonic change of {@link #D}. */
  CISIS("C\uD834\uDD2A", "C##", "Cisis", 2, D),

  /** <code>D&#119083;</code> (Ebb) is the flattened enharmonic change of {@link #D}. */
  ESES("E\uD834\uDD2B", "Ebb", "Eses", 2, D),

  /** <code>E&#9837;</code> (Eb) is three semitones (half steps) higher than the pitch {@link #C}. */
  ES("E\u266D", "Eb", "Es", 3, null),

  /** <code>D&#9839;</code> (D#) is the sharpened enharmonic change of {@link #ES}. */
  DIS("D\u266F", "D#", "Dis", 3, ES),

  /** <code>F&#119083;</code> (Fbb) is the flattened enharmonic change of {@link #ES}. */
  FESES("F\uD834\uDD2B", "Fbb", "Feses", 3, ES),

  /** <code>E</code> is four semitones (half steps) higher than the pitch {@link #C}. */
  E("E", "E", "E", 4, null),

  /** <code>D&#119082;</code> (D##) is the sharpened enharmonic change of {@link #E}. */
  DISIS("D\uD834\uDD2A", "D##", "Disis", 4, E),

  /** <code>F&#9837;</code> (Fb) is the flattened enharmonic change of {@link #E}. */
  FES("F\u266D", "Fb", "Fes", 4, E),

  /** <code>F</code> is five semitones (half steps) higher than the pitch {@link #C}. */
  F("F", "F", "F", 5, null),

  /** <code>E&#9839;</code> (E#) is the sharpened enharmonic change of {@link #F}. */
  EIS("E\u266F", "E#", "Eis", 5, F),

  /** <code>G&#119083;</code> (Gbb) is the flattened enharmonic change of {@link #F}. */
  GESES("G\uD834\uDD2B", "Gbb", "Geses", 5, F),

  /** <code>F&#9839;</code> (Fis) is six semitones (half steps) higher than the pitch {@link #C}. */
  FIS("F\u266F", "F#", "Fis", 6, null),

  /** <code>E&#119082;</code> (E##) is the sharpened enharmonic change of {@link #FIS}. */
  EISIS("E\uD834\uDD2A", "E##", "Eisis", 6, FIS),

  /** <code>G&#9837;</code> (Gb) is the flattened enharmonic change of {@link #FIS}. */
  GES("G\u266D", "Gb", "Ges", 6, FIS),

  /** <code>G</code> is seven semitones (half steps) higher than the pitch {@link #C}. */
  G("G", "G", "G", 7, null),

  /** <code>F&#119082;</code> (F##) is the sharpened enharmonic change of {@link #G}. */
  FISIS("F\uD834\uDD2A", "F##", "Fisis", 7, G),

  /** <code>A&#119083;</code> (Abb) is the flattened enharmonic change of {@link #G}. */
  ASES("A\uD834\uDD2B", "Abb", "Ases", 7, G),

  /** <code>G&#9839;</code> (G#) is eight semitones (half steps) higher than the pitch {@link #C}. */
  GIS("G\u266F", "G#", "Gis", 8, null),

  /** <code>A&#9837;</code> (Ab) is the flattened enharmonic change of {@link #GIS}. */
  AS("A\u266D", "Ab", "As", 8, GIS),

  /**
   * <code>A</code> is nine semitones (half steps) higher than the pitch {@link #C}. The middle a (a<sup>1</sup>,
   * Concert A reference) is normalized to 440Hz.
   */
  A("A", "A", "A", 9, null),

  /** <code>G&#119082;</code> (G##) is the sharpened enharmonic change of {@link #A}. */
  GISIS("G\uD834\uDD2A", "G##", "Gisis", 9, A),

  /** <code>H&#119083;</code> (Hbb) is the flattened enharmonic change of {@link #A}. */
  HESES("H\uD834\uDD2B", "Hbb", "Heses", 9, A),

  /**
   * <code>B&#9837;</code> (Bb) is ten semitones (half steps) higher than the pitch {@link #C}. In most countries this
   * pitch is simply called <em>B</em>. See {@link #H} for further details.
   */
  B_FLAT("B\u266D", "Bb", "B", 10, null),

  /** <code>A&#9839;</code> (A#) is the sharpened enharmonic change of {@link #B_FLAT}. */
  AIS("A\u266F", "A#", "Ais", 10, B_FLAT),

  /** <code>C&#119083;</code> (Cbb) is the flattened enharmonic change of {@link #B_FLAT}. */
  CESES("C\uD834\uDD2B", "Cbb", "Ceses", 10, B_FLAT),

  /**
   * B&#9838; is eleven semitones (half steps) higher than the pitch {@link #C}. In most countries this pitch is simply
   * called <em>H</em>. However the Americans use <em>B</em> instead of <em>H</em> what can cause confusion with
   * {@link #B_FLAT}. The international notation therefore suggests the following notation:
   * <table border="1">
   * <tr>
   * <th>International</th>
   * <th>American</th>
   * <th>European</th>
   * </tr>
   * <tr>
   * <td>B&#9838;</td>
   * <td>B</td>
   * <td>H</td>
   * </tr>
   * <tr>
   * <td>B&#9837;</td>
   * <td>B&#9837;</td>
   * <td>B</td>
   * </tr>
   * </table>
   */
  H("B\u266E", "H", "H", 11, null),

  /** <code>A&#119082;</code> (A##) is the sharpened enharmonic change of {@link #H}. */
  AISIS("A\uD834\uDD2A", "A##", "Aisis", 11, H),

  /** <code>C&#9837;</code> (Cb) is the flattened enharmonic change of {@link #H}. */
  CES("C\u266D", "Cb", "Ces", 11, H);

  private static final Map<String, TonePitch> NAME2PITCH_MAP = new HashMap<>();

  static {
    for (TonePitch pitch : TonePitch.values()) {
      NAME2PITCH_MAP.put(pitch.ascii.toLowerCase(Locale.US), pitch);
      NAME2PITCH_MAP.put(pitch.unicode.toLowerCase(Locale.US), pitch);
      NAME2PITCH_MAP.put(pitch.text.toLowerCase(Locale.US), pitch);
    }
  }

  private static final List<TonePitch> SHARP_SIGN_TONES = Collections.unmodifiableList(Arrays.asList(
      TonePitch.FIS, TonePitch.CIS, TonePitch.GIS, TonePitch.DIS, TonePitch.AIS, TonePitch.EIS, TonePitch.HIS));

  private static final List<TonePitch> FLAT_SIGN_TONES = Collections.unmodifiableList(Arrays.asList(
      TonePitch.B_FLAT, TonePitch.ES, TonePitch.AS, TonePitch.DES, TonePitch.GES, TonePitch.CES, TonePitch.FES));

  /** @see #getUnicode() */
  private final String unicode;

  /** @see #getAscii() */
  private final String ascii;

  /** @see #toString() */
  private final String text;

  /** @see #getStep() */
  private final int step;

  /** @see #getNormal() */
  private final TonePitch normal;

  /**
   * The constructor.
   *
   * @param unicode - see {@link #getUnicode()}.
   * @param ascii - see {@link #getAscii()}
   * @param text - see {@link #toString()}.
   * @param step - see {@link #getStep()}.
   * @param normal - see {@link #getNormal()}.
   */
  private TonePitch(String unicode, String ascii, String text, int step, TonePitch normal) {

    this.unicode = unicode;
    this.ascii = ascii;
    this.text = text;
    this.step = step;
    if (normal == null) {
      this.normal = this;
    } else {
      this.normal = normal;
      assert (step == normal.step);
    }
    if (unicode.endsWith(MusicSymbols.DOUBLE_FLAT_SIGN_STRING)) {
      assert (ascii.endsWith("bb"));
    }
    if (unicode.endsWith(MusicSymbols.DOUBLE_SHARP_SIGN_STRING)) {
      assert (ascii.endsWith("##"));
    }
  }

  /**
   * @return the number of half-tone steps upwards from {@link #C}.
   */
  public int getStep() {

    return this.step;
  }

  /**
   * @return the short title using unicode characters for musical symbols (E.g. "B&#9838;" or "E&#9837;").
   */
  public String getUnicode() {

    return this.unicode;
  }

  /**
   * @return the short title using ASCII characters for musical symbols (E.g. "C#" or "Eb").
   */
  public String getAscii() {

    return this.ascii;
  }

  /**
   * @return the title as plain text without musical symbols as plain ASCII (E.g. "Cis" or "Es").
   */
  public String getText() {

    return this.text;
  }

  /**
   * @return {@code true} if this {@link TonePitch} requires a single (&#9839;) or double (&#119082;) sharp sign,
   *         {@code false} otherwise.
   */
  public boolean isSharp() {

    return this.unicode.endsWith(MusicSymbols.SINGLE_SHARP_SIGN_STRING)
        || this.unicode.endsWith(MusicSymbols.DOUBLE_SHARP_SIGN_STRING);
  }

  /**
   * @return {@code true} if this {@link TonePitch} requires a single (&#9837;) or double (&#119083;) sharp sign,
   *         {@code false} otherwise.
   */
  public boolean isFlat() {

    return this.unicode.endsWith(MusicSymbols.SINGLE_FLAT_SIGN_STRING)
        || this.unicode.endsWith(MusicSymbols.DOUBLE_FLAT_SIGN_STRING);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {

    return this.text;
  }

  /**
   * @return the normal form of this {@link TonePitch} in case this is an enharmonic change or this {@link TonePitch}
   *         itself if it is already {@link #isNormal() normal}.
   */
  public TonePitch getNormal() {

    return this.normal;
  }

  /**
   * @return {@code true} if this is the {@link #getNormal() normal form} (that would be used in
   *         {@link MusicalKey#C_MAJOR}), {@code false} in case of an <em>enharmonic change</em>.
   */
  public boolean isNormal() {

    return (this == this.normal);
  }

  /**
   * @param targetTone is the target {@link TonePitch}.
   * @return the {@link ChromaticInterval} to {@link #transposeChromatic(int, EnharmonicStyle) get} from this
   *         {@link TonePitch} to the given {@code targetTone}.
   */
  public ChromaticInterval getInterval(TonePitch targetTone) {

    int interval = targetTone.step - this.step;
    if (interval < 0) {
      interval = interval + 12;
    }
    return ChromaticInterval.fromChromaticSteps(interval);
  }

  /**
   * This method transposes this {@link TonePitch} by the given number of <code>semitoneSteps</code> and returns the
   * {@link #getNormal() normalized} tone. The {@link TonePitch} will wrap so
   * {@link #transposeChromatic(int, EnharmonicStyle) transpose(12)} will return the {@link #getNormal() normalized}
   * {@link TonePitch} just like {@link #transposeChromatic(int, EnharmonicStyle) transpose(0)} or e.g.
   * {@link #transposeChromatic(int, EnharmonicStyle) transpose(-24)}.
   *
   * @param semitoneSteps is the number of semitone steps to transpose. A positive value transposes towards a higher
   *        pitch, a negative value transposes towards a lower pitch. A value of zero (<code>0</code>) will cause no
   *        change of the {@link #getStep() step}.
   * @param style the {@link EnharmonicStyle}.
   * @return the transposed and {@link #isNormal() normalized} {@link TonePitch}.
   */
  public TonePitch transposeChromatic(int semitoneSteps, EnharmonicStyle style) {

    int targetStep = (this.step + semitoneSteps) % 12;
    if (targetStep < 0) {
      targetStep = targetStep + 12;
    }
    TonePitch result = null;
    for (TonePitch pitch : values()) {
      if (pitch.step == targetStep) {
        result = pitch.getNormal();
        switch (style) {
          case NORMAL:
            return result;
          case FLAT:
            if (!result.isSharp()) {
              return result;
            }
            if (pitch.isFlat()) {
              return pitch;
            }
            break;
          case SHARP:
            if (!result.isFlat()) {
              return result;
            }
            if (pitch.isSharp()) {
              return pitch;
            }
        }
      }
    }
    if (result == null) {
      throw new IllegalArgumentException(this.text + "+" + semitoneSteps);
    }
    return result.getNormal();
  }

  /**
   * This method transposes this {@link TonePitch} by the given number of <code>semitoneSteps</code> wrapping within the
   * {@link MusicalKey#getChromaticScale() chromatic scale} of the given {@link MusicalKey}.
   *
   * @see #transposeChromatic(int, EnharmonicStyle)
   *
   * @param semitoneSteps is the number of semitone steps to transpose. A positive value transposes towards a higher
   *        pitch, a negative value transposes towards a lower pitch. A value of zero (<code>0</code>) will have no
   *        change.
   * @param targetKey is the target {@link MusicalKey key}.
   * @return the transposed {@link TonePitch} with enharmonic change according to the given {@link MusicalKey}.
   */
  public TonePitch transposeChromatic(int semitoneSteps, MusicalKey targetKey) {

    int targetStep = (this.step + semitoneSteps - targetKey.getTonika().getStep()) % 12;
    if (targetStep < 0) {
      targetStep = targetStep + 12;
    }
    return targetKey.getChromaticScale().get(targetStep);
  }

  /**
   * This method transposes this {@link TonePitch} by the given number of <code>diatonicSteps</code> wrapping within the
   * {@link MusicalKey#getDiatonicScale() diatonic scale} of the given {@link MusicalKey}.
   *
   * @see #transposeChromatic(int, EnharmonicStyle)
   *
   * @param diatonicSteps is the number of semitone steps to transpose. A positive value transposes towards a higher
   *        pitch, a negative value transposes towards a lower pitch. A value of zero (<code>0</code>) will have no
   *        change.
   * @param targetKey is the target {@link MusicalKey key}.
   * @return the transposed {@link TonePitch} with enharmonic change according to the given {@link MusicalKey}.
   */
  public TonePitch transposeDiatonic(int diatonicSteps, MusicalKey targetKey) {

    int targetStep = (this.step + diatonicSteps - targetKey.getTonika().getStep()) % 8;
    if (targetStep < 0) {
      targetStep = targetStep + 8;
    }
    return targetKey.getDiatonicScale().get(targetStep);
  }

  /**
   * Transposes this {@link TonePitch} by the given {@link Interval} within the given {@code targetKey}.
   *
   * @param interval is the {@link Interval} such as e.g. {@link Solmization#MI}, {@link ChromaticInterval#MAJOR_THIRD},
   *        or {@link DiatonicInterval#THIRD}.
   * @param targetKey is the target {@link MusicalKey key}.
   * @return the resulting {@link TonePitch}.
   */
  public TonePitch transpose(Interval interval, MusicalKey targetKey) {

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

  /**
   * This method gets the {@link TonePitch} for the given <code>title</code>.
   *
   * @param title is the title of the {@link TonePitch} which is the {@link #getUnicode() unicode}, {@link #getAscii()
   *        ASCII} or {@link #getText() text} representation in any {@link String#toLowerCase() case}.
   * @return the requested {@link TonePitch} or <code>null</code> if no such {@link TonePitch} exists.
   */
  public static TonePitch fromString(String title) {

    TonePitch pitch = null;
    if (title != null) {
      pitch = NAME2PITCH_MAP.get(title.toLowerCase(Locale.US));
    }
    return pitch;
  }

  /**
   * This method gets the {@link TonePitch} that represents the longest {@link String#startsWith(String) prefix} of the
   * given <code>string</code> ignoring the case. E.g. for "aSeS4" it would return {@link TonePitch#ASES} and for "Asis"
   * it would return {@link TonePitch#AS}.
   *
   * @param string is a {@link String} supposed to {@link String#startsWith(String) start} with the title of the
   *        {@link TonePitch} which is the {@link #getUnicode() unicode}, {@link #getAscii() ASCII} or
   *        {@link #getText() text} representation in any {@link String#toLowerCase() case}.
   * @return the requested {@link TonePitch} or <code>null</code> if no such {@link TonePitch} exists.
   */
  public static TonePitch fromStringAsPrefix(String string) {

    TonePitch pitch = null;
    if (string != null) {
      String lowerCase = string.toLowerCase(Locale.US);
      int length = lowerCase.length();
      for (int i = 5; i > 0; i--) {
        if (length >= i) {
          pitch = NAME2PITCH_MAP.get(lowerCase.subSequence(0, i));
          if (pitch != null) {
            break;
          }
        }
      }
    }
    return pitch;
  }

  /**
   * This method gets the longest {@link TonePitch#fromString(String) string representation} of the {@link TonePitch}
   * that is a {@link String#startsWith(String) prefix} of the given <code>string</code> ignoring the case. E.g. for
   * "aSeS4" it would return "ases" and for "Asis" it would return "as".
   *
   * @see #fromStringAsPrefix(String)
   *
   * @param string is a {@link String} supposed to {@link String#startsWith(String) start} with the title of the
   *        {@link TonePitch} which is the {@link #getUnicode() unicode}, {@link #getAscii() ASCII} or
   *        {@link #getText() text} representation in any {@link String#toLowerCase() case}.
   * @return the requested {@link TonePitch} or <code>null</code> if no such {@link TonePitch} exists.
   */
  public static String getTonePrefix(String string) {

    String result = null;
    if (string != null) {
      String lowerCase = string.toLowerCase(Locale.US);
      int length = lowerCase.length();
      for (int i = 5; i > 0; i--) {
        if (length >= i) {
          String prefix = lowerCase.substring(0, i);
          TonePitch pitch = NAME2PITCH_MAP.get(prefix);
          if (pitch != null) {
            result = prefix;
            break;
          }
        }
      }
    }
    return result;
  }

  /**
   * @return the {@link List} of (single) {@link #isFlat() flat} sign tones in the order of the
   *         <em>circle of fifths</em>.
   */
  public static List<TonePitch> getFlatSignTones() {

    return FLAT_SIGN_TONES;
  }

  /**
   * @return the {@link List} of (single) {@link #isSharp() sharp} sign tones in the order of the
   *         <em>circle of fifths</em>.
   */
  public static List<TonePitch> getSharpSignTones() {

    return SHARP_SIGN_TONES;
  }

}
