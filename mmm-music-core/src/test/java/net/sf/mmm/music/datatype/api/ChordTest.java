/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import net.sf.mmm.music.AbstractTest;

import org.junit.Test;

/**
 * Test of {@link Chord}.
 *
 * @author hohwille
 */
public class ChordTest extends AbstractTest {

  /** Test of {@link Chord#Chord(String)} (parsing). */
  @Test
  public void testParse() {

    checkEqualsAndHashCode(new Chord("C"), new Chord(TonePitch.C, TonalSystem.MAJOR), true);
    checkEqualsAndHashCode(new Chord("C"), new Chord("Cm"), false);
    checkEqualsAndHashCode(new Chord("C"), new Chord("C/B"), false);
    checkEqualsAndHashCode(new Chord("C"), new Chord("C7"), false);
    checkEqualsAndHashCode(new Chord("C"), new Chord("Cis"), false);
    assertThat(new Chord("C").getTonalSystem()).isSameAs(TonalSystem.MAJOR);
    assertThat(new Chord("Cm")).isEqualTo(new Chord(TonePitch.C, TonalSystem.MINOR)).isEqualTo(new Chord("CMi"))
        .isEqualTo(new Chord("CmI")).isEqualTo(new Chord("c"));
    assertThat(new Chord("C#maj7/E")).isEqualTo(
        new Chord(TonePitch.CIS, TonalSystem.MAJOR, TonePitch.E, ChordExtension.MAJ_7));
    Chord AsSus4Add9OverFeses = new Chord("a\u266Dsus4add9/f\uD834\uDD2B");
    assertThat(AsSus4Add9OverFeses).isEqualTo(
        new Chord(TonePitch.AS, null, TonePitch.FESES, ChordExtension.SUS_4, ChordExtension.ADD_9));
    assertThat(AsSus4Add9OverFeses.getFundamentalTone()).isSameAs(TonePitch.AS);
    assertThat(AsSus4Add9OverFeses.getTonalSystem()).isNull();
    assertThat(AsSus4Add9OverFeses.getBaseTone()).isSameAs(TonePitch.FESES);
    assertThat(AsSus4Add9OverFeses.getExtensionsString()).isEqualTo("sus4add9");
    assertThat(AsSus4Add9OverFeses.getExtensions()).containsExactly(ChordExtension.SUS_4, ChordExtension.ADD_9);
    checkNegative(() -> new Chord("W"), IllegalArgumentException.class, true, "W", false);
    checkNegative(() -> new Chord("F/"), IllegalArgumentException.class, true, "F/", false);
  }

  /** Test of {@link Chord#Chord(TonePitch, TonalSystem, TonePitch)}. */
  @Test
  public void testNew() {

    assertThat(new Chord(TonePitch.FIS, TonalSystem.MAJOR, TonePitch.E)).isEqualTo(new Chord("F\u266F/E"));
    assertThat(new Chord(TonePitch.FIS, TonalSystem.MINOR, ChordExtension._7)).isEqualTo(new Chord("f\u266Fm7"));
  }

  /** Test of {@link Chord#transposeChromatic(int)}. */
  @Test
  public void testTransposeChromatic() {

    assertThat(new Chord("C").transposeChromatic(1).getName()).isEqualTo("C\u266F");
    assertThat(new Chord("ebadd9/A").transposeChromatic(-1).getName()).isEqualTo("dmadd9/G\u266F");
    assertThat(new Chord("E\u266Dm-add9/A").transposeChromatic(-1).getName()).isEqualTo("dm-add9/G\u266F");
    assertThat(new Chord("Cis4add9 no5/A").transposeChromatic(-1).toString()).isEqualTo("C4add9 no5/G\u266F");
    assertThat(new Chord("Cis4_add9_no5/A").transposeChromatic(-1, MusicalKey.DES_MAJOR).toString()).isEqualTo(
        "C4_add9_no5/A\u266D");
  }

  /** Test of {@link Chord#transpose(Interval, MusicalKey)}. */
  @Test
  public void testTranspose() {

    // chromatic
    assertThat(
        new Chord("C\u266F7/Bb").transpose(ChromaticInterval.PERFECT_FOURTH,
            MusicalKey.CIS_MAJOR.transposeChromatic(ChromaticInterval.PERFECT_FOURTH.getChromaticSteps())))
        .isEqualTo(new Chord("F\u266F7/D\u266F"));

    assertThat(new Chord("ebadd9/A").transposeChromatic(-1).getName()).isEqualTo("dmadd9/G\u266F");
    assertThat(new Chord("E\u266Dm-add9/A").transposeChromatic(-1).getName()).isEqualTo("dm-add9/G\u266F");
    assertThat(new Chord("Cis4add9no5/A").transposeChromatic(-1).getName()).isEqualTo("C4add9no5/G\u266F");

    // diatonic
    assertThat(new Chord("C\u266F7/Bb").transpose(DiatonicInterval.THIRD, MusicalKey.CIS_MAJOR)).isEqualTo(
        new Chord("E\u266F7/D"));
  }

}
