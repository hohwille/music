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
 * A {@link ChordExtension} extends a {@link Chord} with additional {@link ChromaticInterval intervals} or may also
 * {@link #isRemoveThird() replace} existing intervals. These are typically numbers, specific strings or symbols added
 * to a {@link Chord}-{@link Chord#getName() name}.
 *
 * @author hohwille
 */
public enum ChordExtension {

  /** Adds a {@link ChromaticInterval#MAJOR_SECOND} to the {@link Chord}. */
  _2("2", false, false, null, null, ChromaticInterval.MAJOR_SECOND),

  /** Adds a {@link ChromaticInterval#MAJOR_SECOND} to the {@link Chord}. */
  ADD_2("add2", false, false, null, "+2", ChromaticInterval.MAJOR_SECOND),

  /**
   * {@link #isRemoveThird() Replaces the third} (suspended) of the {@link Chord} with a
   * {@link ChromaticInterval#MAJOR_SECOND}.
   */
  SUS_2("sus2", true, false, null, null, ChromaticInterval.MAJOR_SECOND, ChromaticInterval.PERFECT_FIFTH),

  /** {@link #isRemoveThird() Removes the third} of the {@link Chord}. */
  NO_3("no3", true, false, null, null, ChromaticInterval.PERFECT_FIFTH),

  /** Adds a {@link ChromaticInterval#PERFECT_FOURTH} to the {@link Chord}. */
  _4("4", true, false, null, null, ChromaticInterval.PERFECT_FOURTH),

  /** Adds a {@link ChromaticInterval#PERFECT_FOURTH} to the {@link Chord}. */
  ADD_4("add4", false, false, null, "+4", ChromaticInterval.PERFECT_FOURTH),

  /**
   * {@link #isRemoveThird() Replaces the third} (suspended) of the {@link Chord} with a
   * {@link ChromaticInterval#PERFECT_FOURTH}.
   */
  SUS_4("sus4", true, false, null, null, ChromaticInterval.PERFECT_FOURTH, ChromaticInterval.PERFECT_FIFTH),

  /** {@link #isRemoveThird() Removes the third} of the {@link Chord}. */
  _5("5", true, false, null, null),

  /** {@link #isRemoveFifth() Removes the fifth} of the {@link Chord}. */
  NO_5("no5", false, true, null, null, ChromaticInterval.PERFECT_FIFTH),

  /** Adds a {@link ChromaticInterval#MAJOR_SIXT} to the {@link Chord}. */
  _6("6", false, false, null, "maj6", ChromaticInterval.MAJOR_SIXT),

  /** Adds a {@link ChromaticInterval#MINOR_SEVENTH} to the {@link Chord}. */
  _7("7", false, false, null, "7", ChromaticInterval.MINOR_SEVENTH),

  /** Adds a {@link ChromaticInterval#MAJOR_SEVENTH} to the {@link Chord}. */
  MAJ_7("maj7", false, false, "Δ", "j7", ChromaticInterval.MINOR_SEVENTH),

  /** Adds a {@link ChromaticInterval#MINOR_SEVENTH} and {@link ChromaticInterval#MAJOR_NINTH} to the {@link Chord}. */
  _9("9", false, false, null, null, ChromaticInterval.MINOR_SEVENTH, ChromaticInterval.MAJOR_NINTH),

  /** Adds a {@link ChromaticInterval#MAJOR_NINTH} to the {@link Chord}. */
  ADD_9("add9", false, false, null, "+9", ChromaticInterval.MAJOR_NINTH),

  /** Adds a {@link ChromaticInterval#MAJOR_SEVENTH} and {@link ChromaticInterval#MAJOR_NINTH} to the {@link Chord}. */
  MAJ_9("maj9", false, false, null, "j9", ChromaticInterval.MAJOR_SEVENTH, ChromaticInterval.MAJOR_NINTH),

  /**
   * Adds a {@link ChromaticInterval#MINOR_SEVENTH}, a {@link ChromaticInterval#MAJOR_NINTH}, and a
   * {@link ChromaticInterval#PERFECT_ELEVENTH} to the {@link Chord}.
   */
  _11("11", false, false, null, null, ChromaticInterval.MINOR_SEVENTH, ChromaticInterval.MAJOR_NINTH,
      ChromaticInterval.PERFECT_ELEVENTH),

  /** Adds a {@link ChromaticInterval#PERFECT_ELEVENTH} to the {@link Chord}. */
  ADD_11("add11", false, false, null, "+11", ChromaticInterval.PERFECT_ELEVENTH),

  /**
   * Adds a {@link ChromaticInterval#MINOR_SEVENTH}, a {@link ChromaticInterval#MAJOR_NINTH}, a
   * {@link ChromaticInterval#PERFECT_ELEVENTH}, and a {@link ChromaticInterval#MAJOR_THIRTEENTH} to the {@link Chord}.
   */
  _13("13", false, false, null, null, ChromaticInterval.MINOR_SEVENTH, ChromaticInterval.MAJOR_NINTH,
      ChromaticInterval.PERFECT_ELEVENTH, ChromaticInterval.MAJOR_THIRTEENTH),

  /** Adds a {@link ChromaticInterval#MAJOR_THIRTEENTH} to the {@link Chord}. */
  ADD_13("add13", false, false, null, null, ChromaticInterval.MAJOR_THIRTEENTH),

  /**
   * Diminished extension that {@link #isRemoveThird() removes the third} and {@link #isRemoveFifth() fifth} of the
   * {@link Chord} and replaces them with a {@link ChromaticInterval#MINOR_THIRD} and a
   * {@link ChromaticInterval#DIMINISHED_FIFTH}.
   */
  DIM("dim", true, true, "°", "0", ChromaticInterval.MINOR_THIRD, ChromaticInterval.DIMINISHED_FIFTH),

  /**
   * Augmented triad is an extension that {@link #isRemoveThird() removes the third} and {@link #isRemoveFifth() fifth}
   * of the {@link Chord} and replaces them with a {@link ChromaticInterval#MAJOR_THIRD} and a
   * {@link ChromaticInterval#MAJOR_SIXT}.
   */
  AUG("aug", true, false, null, "+", ChromaticInterval.MAJOR_THIRD, ChromaticInterval.MINOR_SIXT);

  private static final Map<String, ChordExtension> NAME2EXT_MAP = new HashMap<>();

  static {
    for (ChordExtension ext : ChordExtension.values()) {
      NAME2EXT_MAP.put(ext.name, ext);
      if (ext.altName != null) {
        NAME2EXT_MAP.put(ext.altName, ext);
      }
      if (ext.symbol != null) {
        NAME2EXT_MAP.put(ext.symbol, ext);
      }
    }
  }

  private final String name;

  private final boolean removeThird;

  private final boolean removeFifth;

  private final String symbol;

  private final String altName;

  private final List<ChromaticInterval> intervals;

  private ChordExtension(String name, boolean removeThird, boolean removeFifth, String symbol, String altName,
      ChromaticInterval... intervals) {

    this.name = name;
    this.removeThird = removeThird;
    this.removeFifth = removeFifth;
    this.symbol = symbol;
    this.altName = altName;
    this.intervals = Collections.unmodifiableList(Arrays.asList(intervals));
  }

  /**
   * @return the name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @return the symbol
   */
  public String getSymbol() {

    return this.symbol;
  }

  /**
   * @return the altName
   */
  public String getAltName() {

    return this.altName;
  }

  /**
   * @see #isRemoveFifth()
   *
   * @return {@code true} if the {@link DiatonicInterval#THIRD third} is removed from the original {@link Chord}
   *         (applies to all {@link ChordExtension}s starting with "sus" for suspended but also to others),
   *         {@code false} otherwise.
   */
  public boolean isRemoveThird() {

    return this.removeThird;
  }

  /**
   * @see #isRemoveThird()
   *
   * @return {@code true} if the {@link DiatonicInterval#FIFTH fifth} is removed from the original {@link Chord},
   *         {@code false} otherwise.
   */
  public boolean isRemoveFifth() {

    return this.removeFifth;
  }

  /**
   * @return the intervals
   */
  public List<ChromaticInterval> getIntervals() {

    return this.intervals;
  }

  /**
   * Gets the {@link ChordExtension} for the given <code>string</code>.
   *
   * @param string is the {@link #getName() name}, {@link #getAltName() alternative name}, or {@link #getSymbol()
   *        symbol} of the requested {@link ChordExtension}.
   * @return the requested {@link ChordExtension} or {@code null} if no such {@link ChordExtension} exists.
   */
  public static ChordExtension fromString(String string) {

    ChordExtension result = null;
    if (string != null) {
      result = NAME2EXT_MAP.get(string.toLowerCase(Locale.US));
    }
    return result;
  }

  /**
   * This method gets the longest {@link ChordExtension#fromString(String) string representation} of the
   * {@link ChordExtension} that is a {@link String#startsWith(String) prefix} of the given <code>string</code> ignoring
   * the case. E.g. for "add9sus4" it would return "add9" and for "49" it would return "4".
   *
   * @see #fromString(String)
   *
   * @param string is a {@link String} supposed to {@link String#startsWith(String) start} with the title of the
   *        {@link ChordExtension} which is the {@link #getName() name}, {@link #getAltName() alternative name} or
   *        {@link #getSymbol() symbol} representation in any {@link String#toLowerCase() case}.
   * @return the requested {@link ChordExtension} or <code>null</code> if no such {@link ChordExtension} exists.
   */
  public static String getExtensionPrefix(String string) {

    String result = null;
    if (string != null) {
      String lowerCase = string.toLowerCase(Locale.US);
      int length = lowerCase.length();
      for (int i = 5; i > 0; i--) {
        if (length >= i) {
          String prefix = lowerCase.substring(0, i);
          ChordExtension extension = NAME2EXT_MAP.get(prefix);
          if (extension != null) {
            result = prefix;
            break;
          }
        }
      }
    }
    return result;
  }

}
