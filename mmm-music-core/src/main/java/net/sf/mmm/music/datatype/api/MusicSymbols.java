/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

/**
 * @author hohwille
 *
 */
public interface MusicSymbols {

  /** The single flat sign: {@value} . */
  char SINGLE_FLAT_SIGN_CHAR = '\u266D';

  /** The single flat sign: {@value} . */
  String SINGLE_FLAT_SIGN_STRING = Character.toString(SINGLE_FLAT_SIGN_CHAR);

  /** The double flat sign: {@value} . */
  String DOUBLE_FLAT_SIGN_STRING = "\uD834\uDD2B";

  /** The neutral sign: {@value} . */
  char NEUTRAL_SIGN_CHAR = '\u266E';

  /** The neutral sign: {@value} . */
  String NEUTRAL_SIGN_STRING = Character.toString(NEUTRAL_SIGN_CHAR);

  /** The single sharp sign: {@value} . */
  char SINGLE_SHARP_SIGN_CHAR = '\u266F';

  /** The single sharp sign: {@value} . */
  String SINGLE_SHARP_SIGN_STRING = Character.toString(SINGLE_SHARP_SIGN_CHAR);

  /** The double sharp sign: {@value} . */
  String DOUBLE_SHARP_SIGN_STRING = "\uD834\uDD2A";

}
