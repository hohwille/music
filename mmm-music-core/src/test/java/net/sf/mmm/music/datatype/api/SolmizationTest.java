/* Copyright (c) The m-m-m Team, Licensed under the Apache License, Version 2.0
 * http://www.apache.org/licenses/LICENSE-2.0 */
package net.sf.mmm.music.datatype.api;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Test of {@link Solmization}.
 *
 * @author hohwille
 */
public class SolmizationTest extends Assertions {

  /** Test of {@link Solmization#getMajorDiatonicSteps()}. */
  @Test
  public void testGetMajorDiatonicSteps() {

    assertThat(Solmization.DO.getMajorDiatonicSteps()).isEqualTo(0);
    assertThat(Solmization.RE.getMajorDiatonicSteps()).isEqualTo(1);
    assertThat(Solmization.MI.getMajorDiatonicSteps()).isEqualTo(2);
    assertThat(Solmization.FA.getMajorDiatonicSteps()).isEqualTo(3);
    assertThat(Solmization.SO.getMajorDiatonicSteps()).isEqualTo(4);
    assertThat(Solmization.LA.getMajorDiatonicSteps()).isEqualTo(5);
    assertThat(Solmization.TI.getMajorDiatonicSteps()).isEqualTo(6);
  }

  /** Test of {@link Solmization#getMajorDiatonicSteps()}. */
  @Test
  public void testGetMajorChromaticSteps() {

    assertThat(Solmization.DO.getMajorChromaticSteps()).isEqualTo(0);
    assertThat(Solmization.RE.getMajorChromaticSteps()).isEqualTo(2);
    assertThat(Solmization.MI.getMajorChromaticSteps()).isEqualTo(4);
    assertThat(Solmization.FA.getMajorChromaticSteps()).isEqualTo(5);
    assertThat(Solmization.SO.getMajorChromaticSteps()).isEqualTo(7);
    assertThat(Solmization.LA.getMajorChromaticSteps()).isEqualTo(9);
    assertThat(Solmization.TI.getMajorChromaticSteps()).isEqualTo(11);
  }

  /** Test of {@link Solmization#getMinorDiatonicSteps()}. */
  @Test
  public void testGetMinorDiatonicSteps() {

    assertThat(Solmization.LA.getMinorDiatonicSteps()).isEqualTo(0);
    assertThat(Solmization.TI.getMinorDiatonicSteps()).isEqualTo(1);
    assertThat(Solmization.DO.getMinorDiatonicSteps()).isEqualTo(2);
    assertThat(Solmization.RE.getMinorDiatonicSteps()).isEqualTo(3);
    assertThat(Solmization.MI.getMinorDiatonicSteps()).isEqualTo(4);
    assertThat(Solmization.FA.getMinorDiatonicSteps()).isEqualTo(5);
    assertThat(Solmization.SO.getMinorDiatonicSteps()).isEqualTo(6);
  }

  /** Test of {@link Solmization#getMinorChromaticSteps()}. */
  @Test
  public void testGetMinorChromaticSteps() {

    assertThat(Solmization.LA.getMinorChromaticSteps()).isEqualTo(0);
    assertThat(Solmization.TI.getMinorChromaticSteps()).isEqualTo(2);
    assertThat(Solmization.DO.getMinorChromaticSteps()).isEqualTo(3);
    assertThat(Solmization.RE.getMinorChromaticSteps()).isEqualTo(5);
    assertThat(Solmization.MI.getMinorChromaticSteps()).isEqualTo(7);
    assertThat(Solmization.FA.getMinorChromaticSteps()).isEqualTo(8);
    assertThat(Solmization.SO.getMinorChromaticSteps()).isEqualTo(10);
  }

}
