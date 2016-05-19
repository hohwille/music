/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * The style of an enharmonic change.
 *
 * @author hohwille
 */
public enum EnharmonicStyle {

  /** The {@link TonePitch#isFlat() flattened} enharmonic form of a {@link TonePitch}. */
  FLAT,

  /** The {@link TonePitch#isSharp() sharpened} enharmonic form of a {@link TonePitch}. */
  SHARP,

  /** The {@link TonePitch#getNormal() normal} form of a {@link TonePitch}. */
  NORMAL

}
