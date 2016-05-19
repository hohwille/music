/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Test of {@link MusicalKey}.
 *
 * @author hohwille
 */
public class MusicalKeyTest extends Assertions {

  /** Test of {@link MusicalKey#C_MAJOR}. */
  @Test
  public void testCMajor() {

    assertThat(MusicalKey.C_MAJOR.getName()).isEqualTo("C");
    assertThat(MusicalKey.C_MAJOR.getTonalSystem()).isSameAs(TonalSystem.MAJOR);
    assertThat(MusicalKey.C_MAJOR.getTonika()).isSameAs(TonePitch.C);
    assertThat(MusicalKey.C_MAJOR.getEnharmonicStyle()).isSameAs(EnharmonicStyle.NORMAL);
    assertThat(MusicalKey.C_MAJOR.getDiatonicScale()).containsExactly(TonePitch.C, TonePitch.D, TonePitch.E,
        TonePitch.F, TonePitch.G, TonePitch.A, TonePitch.H);
    assertThat(MusicalKey.C_MAJOR.getChromaticScale()).containsExactly(TonePitch.C, TonePitch.CIS, TonePitch.D,
        TonePitch.ES, TonePitch.E, TonePitch.F, TonePitch.FIS, TonePitch.G, TonePitch.GIS, TonePitch.A,
        TonePitch.B_FLAT, TonePitch.H);
    assertThat(MusicalKey.C_MAJOR.getChromaticSignTones()).isEmpty();
  }

  /** Test of {@link MusicalKey#CIS_MAJOR}. */
  @Test
  public void testCisMajor() {

    assertThat(MusicalKey.CIS_MAJOR.getName()).isEqualTo("Cis");
    assertThat(MusicalKey.CIS_MAJOR.getTonalSystem()).isSameAs(TonalSystem.MAJOR);
    assertThat(MusicalKey.CIS_MAJOR.getTonika()).isSameAs(TonePitch.CIS);
    assertThat(MusicalKey.CIS_MAJOR.getEnharmonicStyle()).isSameAs(EnharmonicStyle.SHARP);
    assertThat(MusicalKey.CIS_MAJOR.getDiatonicScale()).containsExactly(TonePitch.CIS, TonePitch.DIS,
        TonePitch.EIS, TonePitch.FIS, TonePitch.GIS, TonePitch.AIS, TonePitch.HIS);
    assertThat(MusicalKey.CIS_MAJOR.getChromaticScale()).containsExactly(TonePitch.CIS, TonePitch.D,
        TonePitch.DIS, TonePitch.E, TonePitch.EIS, TonePitch.FIS, TonePitch.G, TonePitch.GIS, TonePitch.A,
        TonePitch.AIS, TonePitch.H, TonePitch.HIS);
    assertThat(MusicalKey.CIS_MAJOR.getChromaticSignTones()).containsExactly(TonePitch.FIS, TonePitch.CIS,
        TonePitch.GIS, TonePitch.DIS, TonePitch.AIS, TonePitch.EIS, TonePitch.HIS);
  }

  /** Test of {@link MusicalKey#AS_MINOR}. */
  @Test
  public void testAsMinor() {

    assertThat(MusicalKey.AS_MINOR.getName()).isEqualTo("as");
    assertThat(MusicalKey.AS_MINOR.getTonalSystem()).isSameAs(TonalSystem.MINOR);
    assertThat(MusicalKey.AS_MINOR.getTonika()).isSameAs(TonePitch.AS);
    assertThat(MusicalKey.AS_MINOR.getEnharmonicStyle()).isSameAs(EnharmonicStyle.FLAT);
    assertThat(MusicalKey.AS_MINOR.getDiatonicScale()).containsExactly(TonePitch.AS, TonePitch.B_FLAT,
        TonePitch.CES, TonePitch.DES, TonePitch.ES, TonePitch.FES, TonePitch.GES);
    assertThat(MusicalKey.AS_MINOR.getChromaticScale()).containsExactly(TonePitch.AS, TonePitch.A,
        TonePitch.B_FLAT, TonePitch.CES, TonePitch.C, TonePitch.DES, TonePitch.D, TonePitch.ES, TonePitch.FES,
        TonePitch.F, TonePitch.GES, TonePitch.G);
    assertThat(MusicalKey.AS_MINOR.getChromaticSignTones()).containsExactly(TonePitch.B_FLAT, TonePitch.ES,
        TonePitch.AS, TonePitch.DES, TonePitch.GES, TonePitch.CES, TonePitch.FES);
  }

  /** Test of {@link MusicalKey#values() all} {@link MusicalKey}s with some generic asserts. */
  @Test
  public void testAll() {

    for (MusicalKey key : MusicalKey.values()) {
      String name = key.getName();
      assertThat(key.toString()).isEqualTo(name + "-" + key.getTonalSystem());
      assertThat(MusicalKey.fromName(name)).isSameAs(key);
    }
  }

  /** Test of {@link MusicalKey#getTone(Interval)}. */
  @Test
  public void testGetTone() {

    assertThat(MusicalKey.C_MAJOR.getTone(Solmization.DO)).isSameAs(TonePitch.C);
    assertThat(MusicalKey.C_MAJOR.getTone(Solmization.RE)).isSameAs(TonePitch.D);
    assertThat(MusicalKey.C_MAJOR.getTone(Solmization.MI)).isSameAs(TonePitch.E);
    assertThat(MusicalKey.C_MAJOR.getTone(Solmization.FA)).isSameAs(TonePitch.F);
    assertThat(MusicalKey.C_MAJOR.getTone(Solmization.SO)).isSameAs(TonePitch.G);
    assertThat(MusicalKey.C_MAJOR.getTone(Solmization.LA)).isSameAs(TonePitch.A);
    assertThat(MusicalKey.C_MAJOR.getTone(Solmization.TI)).isSameAs(TonePitch.H);

    assertThat(MusicalKey.AIS_MINOR.getTone(Solmization.LA)).isSameAs(TonePitch.AIS);
    assertThat(MusicalKey.AIS_MINOR.getTone(Solmization.TI)).isSameAs(TonePitch.HIS);
    assertThat(MusicalKey.AIS_MINOR.getTone(Solmization.DO)).isSameAs(TonePitch.CIS);
    assertThat(MusicalKey.AIS_MINOR.getTone(Solmization.RE)).isSameAs(TonePitch.DIS);
    assertThat(MusicalKey.AIS_MINOR.getTone(Solmization.MI)).isSameAs(TonePitch.EIS);
    assertThat(MusicalKey.AIS_MINOR.getTone(Solmization.FA)).isSameAs(TonePitch.FIS);
    assertThat(MusicalKey.AIS_MINOR.getTone(Solmization.SO)).isSameAs(TonePitch.GIS);
  }

}
