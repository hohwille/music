/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Test of {@link TonePitch}.
 *
 * @author hohwille
 */
public class TonePitchTest extends Assertions {

  /** Test of {@link TonePitch#isNormal()} and {@link TonePitch#getNormal()}. */
  @Test
  public void testNormal() {

    Set<TonePitch> normalPitches = new HashSet<>(Arrays.asList(TonePitch.C, TonePitch.CIS, TonePitch.D,
        TonePitch.ES, TonePitch.E, TonePitch.F, TonePitch.FIS, TonePitch.G, TonePitch.GIS, TonePitch.A,
        TonePitch.B_FLAT, TonePitch.H));
    TonePitch[] values = TonePitch.values();
    assertThat(values).hasSize(12 + 12 + 11);
    for (TonePitch pitch : values) {
      if (normalPitches.contains(pitch)) {
        assertThat(pitch.isNormal()).as(pitch.toString()).isTrue();
        assertThat(pitch.getNormal()).as(pitch.toString()).isSameAs(pitch);
      } else {
        assertThat(pitch.isNormal()).as(pitch.toString()).isFalse();
        assertThat(pitch.getNormal().isNormal()).as(pitch.toString()).isTrue();
        assertThat(pitch.getNormal().getStep()).as(pitch.toString()).isEqualTo(pitch.getStep());
      }
    }

    assertThat(TonePitch.AIS.getNormal()).isSameAs(TonePitch.B_FLAT);
    assertThat(TonePitch.AISIS.getNormal()).isSameAs(TonePitch.H);
    assertThat(TonePitch.AS.getNormal()).isSameAs(TonePitch.GIS);
    assertThat(TonePitch.ASES.getNormal()).isSameAs(TonePitch.G);
    assertThat(TonePitch.CES.getNormal()).isSameAs(TonePitch.H);
    assertThat(TonePitch.CESES.getNormal()).isSameAs(TonePitch.B_FLAT);
    assertThat(TonePitch.CISIS.getNormal()).isSameAs(TonePitch.D);
    assertThat(TonePitch.DES.getNormal()).isSameAs(TonePitch.CIS);
    assertThat(TonePitch.DESES.getNormal()).isSameAs(TonePitch.C);
    assertThat(TonePitch.DIS.getNormal()).isSameAs(TonePitch.ES);
    assertThat(TonePitch.DISIS.getNormal()).isSameAs(TonePitch.E);
    assertThat(TonePitch.EIS.getNormal()).isSameAs(TonePitch.F);
    assertThat(TonePitch.EISIS.getNormal()).isSameAs(TonePitch.FIS);
    assertThat(TonePitch.ESES.getNormal()).isSameAs(TonePitch.D);
    assertThat(TonePitch.FES.getNormal()).isSameAs(TonePitch.E);
    assertThat(TonePitch.FESES.getNormal()).isSameAs(TonePitch.ES);
    assertThat(TonePitch.FISIS.getNormal()).isSameAs(TonePitch.G);
    assertThat(TonePitch.GES.getNormal()).isSameAs(TonePitch.FIS);
    assertThat(TonePitch.GESES.getNormal()).isSameAs(TonePitch.F);
    assertThat(TonePitch.GISIS.getNormal()).isSameAs(TonePitch.A);
    assertThat(TonePitch.HESES.getNormal()).isSameAs(TonePitch.A);
    assertThat(TonePitch.HIS.getNormal()).isSameAs(TonePitch.C);
    assertThat(TonePitch.HISIS.getNormal()).isSameAs(TonePitch.CIS);
  }

  /** Test of {@link TonePitch#fromString(String)}. */
  @Test
  public void testFromString() {

    assertThat(TonePitch.fromString("c")).isSameAs(TonePitch.C);
    assertThat(TonePitch.fromString("C")).isSameAs(TonePitch.C);
    assertThat(TonePitch.fromString("ciS")).isSameAs(TonePitch.CIS);
    assertThat(TonePitch.fromString("c#")).isSameAs(TonePitch.CIS);
    assertThat(TonePitch.fromString("c\u266F")).isSameAs(TonePitch.CIS);
    assertThat(TonePitch.fromString("bb")).isSameAs(TonePitch.B_FLAT);
    assertThat(TonePitch.fromString("b")).isSameAs(TonePitch.B_FLAT);
    assertThat(TonePitch.fromString("b\u266D")).isSameAs(TonePitch.B_FLAT);
    assertThat(TonePitch.fromString("h")).isSameAs(TonePitch.H);
    assertThat(TonePitch.fromString("b\u266E")).isSameAs(TonePitch.H);
    assertThat(TonePitch.fromString("f" + MusicalConstants.DOUBLE_FLAT_SIGN_STRING)).isSameAs(TonePitch.FESES);
    assertThat(TonePitch.fromString("fbb")).isSameAs(TonePitch.FESES);
    assertThat(TonePitch.fromString("fEseS")).isSameAs(TonePitch.FESES);
    assertThat(TonePitch.fromString("h" + MusicalConstants.DOUBLE_SHARP_SIGN_STRING)).isSameAs(TonePitch.HISIS);
    assertThat(TonePitch.fromString("h##")).isSameAs(TonePitch.HISIS);
    assertThat(TonePitch.fromString("hISis")).isSameAs(TonePitch.HISIS);
  }

  /** Test of {@link TonePitch#fromStringAsPrefix(String)}. */
  @Test
  public void testFromStringAsPrefix() {

    assertThat(TonePitch.fromStringAsPrefix("c")).isEqualTo("c");
    assertThat(TonePitch.fromStringAsPrefix("ce")).isEqualTo("c");
    assertThat(TonePitch.fromStringAsPrefix("ceS")).isEqualTo("ces");
    assertThat(TonePitch.fromStringAsPrefix("cbe")).isEqualTo("cb");
    assertThat(TonePitch.fromStringAsPrefix("c#9")).isEqualTo("c#");
    assertThat(TonePitch.fromStringAsPrefix("hesesisas")).isEqualTo("heses");
    assertThat(TonePitch.fromStringAsPrefix("H" + MusicalConstants.DOUBLE_FLAT_SIGN_STRING)).isEqualTo(
        "h" + MusicalConstants.DOUBLE_FLAT_SIGN_STRING);
    assertThat(TonePitch.fromStringAsPrefix("Hbb")).isEqualTo("hbb");
    assertThat(TonePitch.fromStringAsPrefix("Hub")).isEqualTo("h");
  }

  /** Test of {@link TonePitch#getTonePrefix(String)}. */
  @Test
  public void testGetTonePrefix() {

    char[] chars = Character.toChars(0x01D12B);
    System.out.println(Integer.toHexString(chars[0]));
    System.out.println(Integer.toHexString(chars[1]));
    assertThat(TonePitch.getTonePrefix("c")).isEqualTo("c");
    assertThat(TonePitch.getTonePrefix("ce")).isEqualTo("c");
    assertThat(TonePitch.getTonePrefix("ceS")).isEqualTo("ces");
    assertThat(TonePitch.getTonePrefix("cbe")).isEqualTo("cb");
    assertThat(TonePitch.getTonePrefix("c#9")).isEqualTo("c#");
    assertThat(TonePitch.getTonePrefix("hesesisas")).isEqualTo("heses");
    assertThat(TonePitch.getTonePrefix("H\uD834\uDD2B")).isEqualTo("h\uD834\uDD2B");
    assertThat(TonePitch.getTonePrefix("Hbb")).isEqualTo("hbb");
    assertThat(TonePitch.getTonePrefix("Hub")).isEqualTo("h");
  }

  /**
   * Test of {@link TonePitch#getUnicode()}.
   */
  @Test
  public void testUnicode() {

    Map<String, String> unicode2asciiMap = new HashMap<>();
    unicode2asciiMap.put(MusicalConstants.SINGLE_SHARP_SIGN_STRING, "#");
    unicode2asciiMap.put(MusicalConstants.SINGLE_FLAT_SIGN_STRING, "b");
    unicode2asciiMap.put(MusicalConstants.DOUBLE_SHARP_SIGN_STRING, "##");
    unicode2asciiMap.put(MusicalConstants.DOUBLE_FLAT_SIGN_STRING, "bb");
    for (TonePitch pitch : TonePitch.values()) {
      String unicode = pitch.getUnicode();
      String ascii = unicode;
      for (String sign : unicode2asciiMap.keySet()) {
        if (unicode.endsWith(sign)) {
          ascii = unicode.substring(0, unicode.length() - sign.length()) + unicode2asciiMap.get(sign);
        } else if (unicode.endsWith(MusicalConstants.NEUTRAL_SIGN_STRING)) {
          assertThat(pitch).isSameAs(TonePitch.H);
          ascii = "H";
        }
      }
      assertThat(ascii).as(pitch.toString()).isEqualTo(pitch.getAscii());
    }
  }

  /**
   * Test of {@link TonePitch#transposeChromatic(int, EnharmonicStyle)}.
   */
  @Test
  public void testTransposeNormalized() {

    for (TonePitch pitch : TonePitch.values()) {
      String s = pitch.toString();
      TonePitch normal = pitch.getNormal();
      assertThat(pitch.transposeChromatic(0, EnharmonicStyle.NORMAL)).as(s).isSameAs(normal);
      assertThat(pitch.transposeChromatic(12, EnharmonicStyle.NORMAL)).as(s).isSameAs(normal);
      assertThat(pitch.transposeChromatic(24, EnharmonicStyle.NORMAL)).as(s).isSameAs(normal);
      assertThat(pitch.transposeChromatic(-12, EnharmonicStyle.NORMAL)).as(s).isSameAs(normal);
      assertThat(pitch.transposeChromatic(-24, EnharmonicStyle.NORMAL)).as(s).isSameAs(normal);
    }
    // normalized
    assertThat(TonePitch.C.transposeChromatic(1, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.CIS);
    assertThat(TonePitch.C.transposeChromatic(2, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.D);
    assertThat(TonePitch.C.transposeChromatic(-1, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.H);
  }

  /** Test of {@link TonePitch#transposeChromatic(int, MusicalKey)}. */
  @Test
  public void testTransposeChromaticWithKey() {

    // C up one semitone...
    assertThat(TonePitch.C.transposeChromatic(1, MusicalKey.C_MAJOR)).isSameAs(TonePitch.CIS);
    assertThat(TonePitch.C.transposeChromatic(1, MusicalKey.G_MAJOR)).isSameAs(TonePitch.CIS);
    assertThat(TonePitch.C.transposeChromatic(1, MusicalKey.F_MAJOR)).isSameAs(TonePitch.DES);
    assertThat(TonePitch.C.transposeChromatic(1, MusicalKey.AS_MAJOR)).isSameAs(TonePitch.DES);

    // H up one semitone...
    assertThat(TonePitch.H.transposeChromatic(1, MusicalKey.C_MAJOR)).isSameAs(TonePitch.C);
    assertThat(TonePitch.H.transposeChromatic(1, MusicalKey.DIS_MINOR)).isSameAs(TonePitch.C);
    assertThat(TonePitch.H.transposeChromatic(1, MusicalKey.AIS_MINOR)).isSameAs(TonePitch.HIS);

    // H down one semitone...
    assertThat(TonePitch.H.transposeChromatic(-1, MusicalKey.C_MAJOR)).isSameAs(TonePitch.B_FLAT);
    assertThat(TonePitch.H.transposeChromatic(-1, MusicalKey.D_MINOR)).isSameAs(TonePitch.B_FLAT);
    assertThat(TonePitch.H.transposeChromatic(-1, MusicalKey.AIS_MINOR)).isSameAs(TonePitch.AIS);
    assertThat(TonePitch.H.transposeChromatic(-1, MusicalKey.H_MAJOR)).isSameAs(TonePitch.AIS);

    // F down one semitone...
    assertThat(TonePitch.F.transposeChromatic(-1, MusicalKey.C_MAJOR)).isSameAs(TonePitch.E);
    assertThat(TonePitch.F.transposeChromatic(-1, MusicalKey.CES_MAJOR)).isSameAs(TonePitch.FES);
  }

  /** Test of {@link TonePitch#transposeChromatic(int, EnharmonicStyle)}. */
  @Test
  public void testTransposeChromaticWithStyle() {

    assertThat(TonePitch.C.transposeChromatic(0, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.C);
    assertThat(TonePitch.C.transposeChromatic(12, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.C);
    assertThat(TonePitch.C.transposeChromatic(-12, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.C);
    assertThat(TonePitch.C.transposeChromatic(240, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.C);
    assertThat(TonePitch.C.transposeChromatic(-240, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.C);
    assertThat(TonePitch.C.transposeChromatic(1, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.CIS);
    assertThat(TonePitch.C.transposeChromatic(2, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.D);
    assertThat(TonePitch.C.transposeChromatic(3, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.ES);
    assertThat(TonePitch.C.transposeChromatic(4, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.E);
    assertThat(TonePitch.C.transposeChromatic(5, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.F);
    assertThat(TonePitch.C.transposeChromatic(6, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.FIS);
    assertThat(TonePitch.C.transposeChromatic(7, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.G);
    assertThat(TonePitch.C.transposeChromatic(8, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.GIS);
    assertThat(TonePitch.C.transposeChromatic(9, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.A);
    assertThat(TonePitch.C.transposeChromatic(10, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.B_FLAT);
    assertThat(TonePitch.C.transposeChromatic(11, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.H);

    assertThat(TonePitch.C.transposeChromatic(-1, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.H);
    assertThat(TonePitch.C.transposeChromatic(-2, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.B_FLAT);
    assertThat(TonePitch.C.transposeChromatic(-3, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.A);
    assertThat(TonePitch.C.transposeChromatic(-4, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.GIS);
    assertThat(TonePitch.C.transposeChromatic(-5, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.G);
    assertThat(TonePitch.C.transposeChromatic(-6, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.FIS);
    assertThat(TonePitch.C.transposeChromatic(-7, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.F);
    assertThat(TonePitch.C.transposeChromatic(-8, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.E);
    assertThat(TonePitch.C.transposeChromatic(-9, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.ES);
    assertThat(TonePitch.C.transposeChromatic(-10, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.D);
    assertThat(TonePitch.C.transposeChromatic(-11, EnharmonicStyle.NORMAL)).isSameAs(TonePitch.CIS);
  }
}
