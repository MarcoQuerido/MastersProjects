package org.trebol.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class BillingTypeTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BillingType.class);
        BillingType billingType1 = new BillingType();
        billingType1.setId(1L);
        BillingType billingType2 = new BillingType();
        billingType2.setId(billingType1.getId());
        assertThat(billingType1).isEqualTo(billingType2);
        billingType2.setId(2L);
        assertThat(billingType1).isNotEqualTo(billingType2);
        billingType1.setId(null);
        assertThat(billingType1).isNotEqualTo(billingType2);
    }
}
