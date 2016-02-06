/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * {@link MusicalItem} for a {@link #isRest() rest}.
 *
 * @author hohwille
 */
public class RestItem extends MusicalItem {

  /**
   * The constructor.
   *
   * @param value - the {@link #getValue() value}.
   */
  public RestItem(MusicalValue value) {

    super(value);
  }

  @Override
  public boolean isRest() {

    return true;
  }

}
