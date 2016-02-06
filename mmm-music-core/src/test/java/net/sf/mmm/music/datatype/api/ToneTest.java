/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Test of {@link Tone}.
 *
 * @author hohwille
 */
public class ToneTest extends Assertions {

  /**
   * Test of {@link Tone#transposeChromatic(int, EnharmonicStyle)}.
   */
  @Test
  public void testTransposeChromaticStyle() {

    // transpose up
    // same octave
    checkTransposeChromaticNormalStyle(TonePitch.B_FLAT, 1, TonePitch.H, 0);
    checkTransposeChromaticNormalStyle(TonePitch.C, 11, TonePitch.H, 0);
    // next octave
    checkTransposeChromaticNormalStyle(TonePitch.H, 1, TonePitch.C, 1);
    checkTransposeChromaticNormalStyle(TonePitch.C, 12, TonePitch.C, 1);
    checkTransposeChromaticNormalStyle(TonePitch.C, 13, TonePitch.CIS, 1);
    checkTransposeChromaticNormalStyle(TonePitch.CIS, 22, TonePitch.H, 1);
    // multiple octaves
    checkTransposeChromaticNormalStyle(TonePitch.CIS, 23, TonePitch.C, 2);
    checkTransposeChromaticNormalStyle(TonePitch.H, 13, TonePitch.C, 2);
    checkTransposeChromaticNormalStyle(TonePitch.C, 24, TonePitch.C, 2);

    // transpose down
    // same octave
    checkTransposeChromaticNormalStyle(TonePitch.H, -1, TonePitch.B_FLAT, 0);
    checkTransposeChromaticNormalStyle(TonePitch.H, -11, TonePitch.C, 0);
    // previous octave
    checkTransposeChromaticNormalStyle(TonePitch.B_FLAT, -11, TonePitch.H, -1);
    checkTransposeChromaticNormalStyle(TonePitch.C, -1, TonePitch.H, -1);
    checkTransposeChromaticNormalStyle(TonePitch.C, -12, TonePitch.C, -1);
    // multiple octaves

  }

  private void checkTransposeChromaticNormalStyle(TonePitch pitch, int step, TonePitch newPitch, int octaveStep) {

    checkTransposeChromaticNormalStyle(0, pitch, step, newPitch, octaveStep);
  }

  private void checkTransposeChromaticNormalStyle(int octave, TonePitch pitch, int step, TonePitch newPitch,
      int octaveStep) {

    // given
    Tone tone = new Tone(pitch, octave);
    // when
    Tone transposed = tone.transposeChromatic(step, EnharmonicStyle.NORMAL);
    // then
    assertThat(transposed.getPitch()).isSameAs(newPitch);
    assertThat(transposed.getOctave()).isEqualTo(octave + octaveStep);
  }

}
