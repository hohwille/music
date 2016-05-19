/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * A {@link Chord} is a combination of {@link TonePitch}es played simultaneously. Typical {@link Chord}s have a
 * {@link #getTonalSystem() tonal system} which is either {@link TonalSystem#MAJOR} or {@link TonalSystem#MINOR}. Such
 * {@link Chord}s consists of a least three tones:
 * <ul>
 * <li>the {@link #getFundamentalTone() fundamental tone}</li>
 * <li>the {@link ChromaticInterval#MINOR_THIRD} on the {@link #getFundamentalTone() fundamental tone} for
 * {@link TonalSystem#MINOR} or the {@link ChromaticInterval#MAJOR_THIRD} on the {@link #getFundamentalTone()
 * fundamental tone} for {@link TonalSystem#MAJOR}.</li>
 * <li>the {@link ChromaticInterval#PERFECT_FIFTH} on the {@link #getFundamentalTone() fundamental tone}.</li>
 * </ul>
 * Simple examples:
 * <ul>
 * <li>the {@link #Chord(String) Chord} {@link #getName() named} "C" stands for {@link TonePitch#C C}-
 * {@link TonalSystem#MAJOR major}) and is composed of {@link TonePitch#C C}, {@link TonePitch#E E}, and
 * {@link TonePitch#G G}.</li>
 * <li>the {@link #Chord(String) Chord} {@link #getName() named} "cm" stands for {@link TonePitch#C c}-
 * {@link TonalSystem#MINOR minor}) and is composed of {@link TonePitch#C C}, {@link TonePitch#ES E&#9837;}, and
 * {@link TonePitch#G G}.</li>
 * </ul>
 * Further, a {@link Chord} can have {@link #getExtensions() extensions} that {@link ChordExtension#getIntervals() add}
 * or {@link ChordExtension#isRemoveThird() remove} tones from the {@link Chord}. A very common example is
 * {@link ChordExtension#_7} that adds a {@link ChromaticInterval#MINOR_SEVENTH minor seventh} relative to the
 * {@link #getFundamentalTone() fundamental tone} to the {@link Chord}. However, there can also be complex combinations
 * such as "Csus4no5add11". Also there are the special {@link ChordExtension extensions} {@link ChordExtension#DIM} and
 * {@link ChordExtension#AUG} that change the chord character totally. <br/>
 * Finally, a {@link Chord} can have a different {@link #getBaseTone() base tone}. This tone is not only added but has
 * to be the lowest tone in the {@link Chord}.<br/>
 * {@link Chord}s can be inverted what means that the tones except for a {@link #getBaseTone() base tone} (if different
 * from {@link #getFundamentalTone() fundamental tone}) can be {@link ChromaticInterval#PERFECT_OCTAVE octavated} so the
 * order of the tones from lower to higher tones will change. Instances of this {@link Chord} class do not distinguish
 * inversions of chords.
 *
 * @author hohwille
 */
public class Chord {

  private static final char MINOR_INDICATOR = 'm';

  private final String name;

  private final String extensionsString;

  private final List<ChordExtension> extensions;

  private final TonePitch fundamentalTone;

  private final TonePitch baseTone;

  private final TonalSystem tonalSystem;

  /**
   * The constructor.
   *
   * @param chord is the {@link #getName() name} to parse as {@link Chord}.
   */
  public Chord(String chord) {

    super();
    Objects.requireNonNull(chord, "chord");
    this.name = chord.trim();
    int length = this.name.length();
    String fundamental = TonePitch.getTonePrefix(this.name);
    this.fundamentalTone = TonePitch.fromString(fundamental);
    if (this.fundamentalTone == null) {
      throw new IllegalArgumentException(chord);
    }
    char f0 = this.name.charAt(0);
    TonalSystem system;
    if (Character.isUpperCase(f0)) {
      system = TonalSystem.MAJOR;
    } else {
      system = TonalSystem.MINOR;
    }
    String extensionsStr = "";
    List<ChordExtension> extensionList = new ArrayList<>();
    TonePitch base = this.fundamentalTone;
    int index = fundamental.length();
    if (index < length) {
      char c = this.name.charAt(index);
      // "m" or "mi" for minor
      if ((c == MINOR_INDICATOR) || (c == 'M')) {
        char next = '\0';
        if (index + 1 < length) {
          next = this.name.charAt(index + 1);
        }
        if (next != 'a') {
          system = TonalSystem.MINOR;
          index++;
          if ((next == 'i') || (next == 'I')) {
            index++;
          }
        }
      }
      // parse base tone...
      int slashIndex = this.name.lastIndexOf('/');
      if (slashIndex > 0) {
        String baseString = this.name.substring(slashIndex + 1);
        TonePitch pitch = TonePitch.fromString(baseString);
        if (pitch == null) {
          // maybe we want to support chords like C6/9 via extension...
          extensionsStr = this.name.substring(index);
        } else {
          base = pitch;
          extensionsStr = this.name.substring(index, slashIndex);
        }
      } else {
        extensionsStr = this.name.substring(index);
      }
      // parse extensions...
      String extStr = extensionsStr;
      while (!extStr.isEmpty()) {
        if (isFiller(extStr.charAt(0))) {
          extStr = extStr.substring(1);
        }
        String ext = ChordExtension.getExtensionPrefix(extStr);
        ChordExtension extension = ChordExtension.fromString(ext);
        if (extension == null) {
          throw new IllegalArgumentException(chord);
        }
        extensionList.add(extension);
        if (extension.isRemoveThird()) {
          // actually something like "EmSus4" makes no sense but we better stay tolerant
          system = null;
        }
        extStr = extStr.substring(ext.length());
      }
    }
    this.tonalSystem = system;
    this.baseTone = base;
    this.extensions = Collections.unmodifiableList(extensionList);
    this.extensionsString = extensionsStr;
  }

  private boolean isFiller(char c) {

    return (c == '-') || (c == ' ') || (c == '_');
  }

  /**
   * The constructor.
   *
   * @param fundamental - see {@link #getFundamentalTone()}.
   * @param system - see {@link #getTonalSystem()}.
   */
  public Chord(TonePitch fundamental, TonalSystem system) {

    this(fundamental, system, null, null, Collections.EMPTY_LIST);
  }

  /**
   * The constructor.
   *
   * @param fundamental - see {@link #getFundamentalTone()}.
   * @param system - see {@link #getTonalSystem()}.
   * @param base - see {@link #getBaseTone()}.
   */
  public Chord(TonePitch fundamental, TonalSystem system, TonePitch base) {

    this(fundamental, system, base, null, Collections.EMPTY_LIST);
  }

  /**
   * The constructor.
   *
   * @param fundamental - see {@link #getFundamentalTone()}.
   * @param system - see {@link #getTonalSystem()}.
   * @param extensions - see {@link #getExtensions()}.
   */
  public Chord(TonePitch fundamental, TonalSystem system, ChordExtension... extensions) {

    this(fundamental, system, null, extensions);
  }

  /**
   * The constructor.
   *
   * @param fundamental - see {@link #getFundamentalTone()}.
   * @param system - see {@link #getTonalSystem()}.
   * @param base - see {@link #getBaseTone()}.
   * @param extensions - see {@link #getExtensions()}.
   */
  public Chord(TonePitch fundamental, TonalSystem system, TonePitch base, ChordExtension... extensions) {

    this(fundamental, system, base, null, Collections.unmodifiableList(Arrays.asList(extensions)));
  }

  private Chord(TonePitch fundamental, TonalSystem system, TonePitch base, String extensionsString,
      List<ChordExtension> extensions) {

    super();
    Objects.requireNonNull(fundamental, "fundamental");
    Objects.requireNonNull(extensions, "extensions");
    this.fundamentalTone = fundamental;
    this.tonalSystem = system;
    if (base == null) {
      this.baseTone = fundamental;
    } else {
      this.baseTone = base;
    }
    this.extensions = extensions;
    if (extensionsString == null) {
      this.extensionsString = buildExtensionsString(this.extensions);
    } else {
      this.extensionsString = extensionsString;
    }
    this.name = buildName();
  }

  private String buildName() {

    StringBuilder sb = new StringBuilder();
    if (this.tonalSystem == TonalSystem.MINOR) {
      sb.append(this.fundamentalTone.getUnicode().toLowerCase(Locale.US));
      sb.append("m");
    } else {
      sb.append(this.fundamentalTone.getUnicode());
    }
    sb.append(this.extensionsString);
    if (this.baseTone != this.fundamentalTone) {
      sb.append('/');
      sb.append(this.baseTone.getUnicode());
    }
    return sb.toString();
  }

  private static String buildExtensionsString(List<ChordExtension> extensions) {

    StringBuilder sb = new StringBuilder();
    for (ChordExtension ext : extensions) {
      sb.append(ext.getName());
    }
    return sb.toString();
  }

  /**
   * @return the name (textual representation) of this {@link Chord}.
   */
  public String getName() {

    return this.name;
  }

  /**
   * @return {@link TonalSystem#MAJOR}, {@link TonalSystem#MINOR} or <code>null</code> otherwise (e.g. for "sus4", "aug"
   *         or "dim")
   */
  public TonalSystem getTonalSystem() {

    return this.tonalSystem;
  }

  /**
   * @return the fundamentalTone
   */
  public TonePitch getFundamentalTone() {

    return this.fundamentalTone;
  }

  /**
   * @return the baseTone
   */
  public TonePitch getBaseTone() {

    return this.baseTone;
  }

  /**
   * @return the extensions
   */
  public List<ChordExtension> getExtensions() {

    return this.extensions;
  }

  /**
   * @return the extensionsString
   */
  public String getExtensionsString() {

    return this.extensionsString;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {

    return Objects.hash(this.baseTone, this.extensions, this.fundamentalTone, this.tonalSystem);
  }

  /**
   * {@inheritDoc}
   */
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
    Chord other = (Chord) obj;
    if (!Objects.equals(this.fundamentalTone, other.fundamentalTone)) {
      return false;
    }
    if (!Objects.equals(this.tonalSystem, other.tonalSystem)) {
      return false;
    }
    if (!Objects.equals(this.baseTone, other.baseTone)) {
      return false;
    }
    if (!Objects.equals(this.extensions, other.extensions)) {
      return false;
    }
    return true;
  }

  /**
   * Like {@link #transposeChromatic(int, MusicalKey)} but without {@link MusicalKey}. Will
   * {@link TonePitch#transposeChromatic(int, EnharmonicStyle) transpose} with {@link EnharmonicStyle#NORMAL normal
   * style}.
   *
   * @param semitoneSteps is the number of semitone steps to transpose. A positive value transposes towards a higher
   *        pitch, a negative value transposes towards a lower pitch. A value of zero (<code>0</code>) will have no
   *        change of the pitch.
   * @return the transposed {@link Chord}.
   */
  public Chord transposeChromatic(int semitoneSteps) {

    return transposeChromatic(semitoneSteps, null);
  }

  /**
   * Transposes this {@link Chord} by the given number of {@code semitoneSteps}.
   *
   * @see TonePitch#transposeChromatic(int, MusicalKey)
   *
   * @param semitoneSteps is the number of semitone steps to transpose. A positive value transposes towards a higher
   *        pitch, a negative value transposes towards a lower pitch. A value of zero (<code>0</code>) will have no
   *        change of the pitch.
   * @param key is the used for enharmonic change of the {@link TonePitch}es.
   * @return the transposed {@link Chord}.
   */
  public Chord transposeChromatic(int semitoneSteps, MusicalKey key) {

    TonePitch newFundamental;
    TonePitch newBase;
    if (key == null) {
      newFundamental = this.fundamentalTone.transposeChromatic(semitoneSteps, EnharmonicStyle.NORMAL);
      newBase = this.baseTone.transposeChromatic(semitoneSteps, EnharmonicStyle.NORMAL);
    } else {
      newFundamental = this.fundamentalTone.transposeChromatic(semitoneSteps, key);
      newBase = this.baseTone.transposeChromatic(semitoneSteps, key);
    }
    return new Chord(newFundamental, this.tonalSystem, newBase, this.extensionsString, this.extensions);
  }

  /**
   * Transposes this {@link Chord} by the given {@link Interval}.
   *
   * @see TonePitch#transposeChromatic(int, MusicalKey)
   *
   * @param interval is the {@link Interval} such as e.g. {@link Solmization#MI}, {@link ChromaticInterval#MAJOR_THIRD},
   *        or {@link DiatonicInterval#THIRD}.
   * @param targetKey is the target {@link MusicalKey key}.
   * @return the transposed {@link Chord}.
   */
  public Chord transpose(Interval interval, MusicalKey targetKey) {

    TonePitch newFundamental = this.fundamentalTone.transpose(interval, targetKey);
    // we need to transpose the base chromatic so that in case of diatonic transposing the chromatic interval from
    // the base to the fundamental does not change.
    ChromaticInterval chromaticInterval = this.fundamentalTone.getInterval(newFundamental);
    TonePitch newBase = this.baseTone.transpose(chromaticInterval, targetKey);
    return new Chord(newFundamental, this.tonalSystem, newBase, this.extensionsString, this.extensions);
  }

  @Override
  public String toString() {

    return this.name;
  }

}
