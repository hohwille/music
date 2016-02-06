/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import java.util.Objects;

/**
 * @author hohwille
 *
 */
public abstract class MusicalItem {

  private final MusicalValue value;

  /**
   * The constructor.
   *
   * @param value - the {@link #getValue() value}.
   */
  public MusicalItem(MusicalValue value) {

    super();
    this.value = value;
  }

  /**
   * @return the {@link MusicalValue} that defines the duration of this {@link MusicalItem}.
   */
  public MusicalValue getValue() {

    return this.value;
  }

  /**
   * @return the {@link Tone} of this item or <code>null</code> if this item does not represent a tone (e.g. rest,
   *         percussion item, etc.).
   */
  public Tone getTone() {

    return null;
  }

  /**
   * @return {@code true} if this item represents a {@link Tone} and {@link #getTone()} will NOT return {@code null},
   *         {@code false} otherwise.
   */
  public boolean isTone() {

    return (getTone() != null);
  }

  /**
   * @return {@code true} if this item represents a rest (break), {@code false} otherwise.
   */
  public boolean isRest() {

    return false;
  }

  @Override
  public int hashCode() {

    int hash = ((this.value == null) ? 0 : ~this.value.hashCode());
    Tone tone = getTone();
    if (tone != null) {
      hash = 31 * hash + tone.hashCode();
    }
    return hash;
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
    MusicalItem other = (MusicalItem) obj;
    if (!Objects.equals(this.value, other.value)) {
      return false;
    }
    if (!Objects.equals(getTone(), other.getTone())) {
      return false;
    }
    return true;
  }

}
