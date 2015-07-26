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
 * @author hohwille
 *
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
    this.name = chord.trim().replaceAll(" ", "");
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
      while (!extensionsStr.isEmpty()) {
        String ext = ChordExtension.getExtensionPrefix(extensionsStr);
        ChordExtension extension = ChordExtension.fromString(ext);
        if (extension == null) {
          throw new IllegalArgumentException(chord);
        }
        extensionList.add(extension);
        if (extension.isReplaceChord()) {
          // actually something like "EmSus4" makes no sense but we better stay tolerant
          system = null;
        }
        extensionsStr = extensionsStr.substring(ext.length());
      }
    }
    this.tonalSystem = system;
    this.baseTone = base;
    this.extensions = Collections.unmodifiableList(extensionList);
    this.extensionsString = extensionsStr;
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
    if (!Objects.equals(this.baseTone, other.baseTone)) {
      return false;
    }
    if (!Objects.equals(this.extensions, other.extensions)) {
      return false;
    }
    if (!Objects.equals(this.fundamentalTone, other.fundamentalTone)) {
      return false;
    }
    if (!Objects.equals(this.tonalSystem, other.tonalSystem)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {

    return this.name;
  }

}
