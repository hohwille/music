/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * Common interface for Beat and {@link MusicalValue}.
 *
 * @author hohwille
 */
public interface Fraction {

  /**
   * @return the beats
   */
  int getBeats();

  /**
   * @return the perUnit
   */
  int getFaction();

}
