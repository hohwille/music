/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * A {@link TonalSystem} is a scale composed of seven distinct {@link TonePitch pitch} classes. The diatonic scale
 * includes five whole steps and two half steps for each octave, in which the two half steps are separated from each
 * other by either two or three whole steps, depending on their position in the scale.
 *
 * @author Joerg Hohwiller (hohwille at users.sourceforge.net)
 * @since 1.0.0
 */
public enum TonalSystem {

  // DORIAN("dor", "dorian"),
  //
  // HYPODORIAN("hdor", "hypodorian"),
  //
  // PHRYGIAN("phr", "phrygian"),
  //
  // HYPOPHRYGIAN("hphr", "hypophrygian"),
  //
  // LYDIAN("lyd", "lydian"),
  //
  // HYPOLYDIAN("hlyd", "hypolydian"),
  //
  // MIXOLYDIAN("mix", "mixolydian"),
  //
  // HYPOMIXOLYDIAN("hmix", "hypomixolydian"),

  /**
   * {@link TonalSystem} of a major {@link MusicalKey key}. Its scale sequence has semitone intervals from the 3. to the
   * 4. tone as well as from the 7. to the 8. tone (1-1-½-1-1-1-½).
   */
  MAJOR("maj", "major"),

  /**
   * {@link TonalSystem} of a minor {@link MusicalKey key}. Its scale sequence has semitone intervals from the 2. to the
   * 3. tone as well as from the 5. to the 6. tone (1-½-1-1-½-1-1).
   */
  MINOR("min", "minor");

  /** @see #getValue() */
  private final String value;

  /** @see #toString() */
  private final String title;

  /**
   * The constructor.
   *
   * @param value - see {@link #getValue()}.
   * @param title - see {@link #toString()}.
   */
  private TonalSystem(String value, String title) {

    this.value = value;
    this.title = title;
  }

  /**
   * @return the value (short and stable {@link #toString() name}).
   */
  public String getValue() {

    return this.value;
  }

  /**
   * @return the {@link java.util.List#get(int) zero-based index} of the first tone that is a semitone higher than its
   *         predecessor (3 for {@link #MAJOR} and 2 for {@link #MINOR}).
   */
  public int getFirstSemitone() {

    switch (this) {
      case MAJOR:
        return 3;
      case MINOR:
        return 2;
      default:
        throw new IllegalStateException(toString());
    }
  }

  /**
   * @return the {@link java.util.List#get(int) zero-based index} of the second tone that is a semitone higher than its
   *         predecessor (7 for {@link #MAJOR} and 5 for {@link #MINOR}).
   */
  public int getSecondSemitone() {

    switch (this) {
      case MAJOR:
        return 7;
      case MINOR:
        return 5;
      default:
        throw new IllegalStateException(toString());
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {

    return this.title;
  }

  /**
   * This method gets the {@link TonalSystem} for the given <code>value</code> .
   *
   * @param value is the {@link #getValue() value} of the requested {@link TonalSystem}.
   * @return the requested {@link TonalSystem} or <code>null</code> if no such {@link TonalSystem} exists.
   */
  public static TonalSystem fromValue(String value) {

    for (TonalSystem instance : values()) {
      if (instance.value.equals(value)) {
        return instance;
      }
    }
    return null;
  }

}
