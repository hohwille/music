/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;


/**
 * The clef specifying the {@link ClefSymbol} in combination with a {@link #getShift() shift}.
 *
 * @author hohwille
 */
public class Clef {

  private ClefSymbol symbol;

  private int shift;

  /**
   * The constructor.
   */
  public Clef() {

    super();
  }

  /**
   * @return the symbol
   */
  public ClefSymbol getSymbol() {

    return this.symbol;
  }

  /**
   * @param symbol is the symbol to set
   */
  public void setSymbol(ClefSymbol symbol) {

    this.symbol = symbol;
  }

  /**
   * @return the shift
   */
  public int getShift() {

    return this.shift;
  }

  /**
   * @param shift is the shift to set
   */
  public void setShift(int shift) {

    this.shift = shift;
  }

}
