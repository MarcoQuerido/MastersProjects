package org.trebol.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class SellStatusTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SellStatus.class);
        SellStatus sellStatus1 = new SellStatus();
        sellStatus1.setId(1L);
        SellStatus sellStatus2 = new SellStatus();
        sellStatus2.setId(sellStatus1.getId());
        assertThat(sellStatus1).isEqualTo(sellStatus2);
        sellStatus2.setId(2L);
        assertThat(sellStatus1).isNotEqualTo(sellStatus2);
        sellStatus1.setId(null);
        assertThat(sellStatus1).isNotEqualTo(sellStatus2);
    }
}
