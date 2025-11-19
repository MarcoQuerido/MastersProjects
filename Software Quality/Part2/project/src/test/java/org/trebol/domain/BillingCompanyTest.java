package org.trebol.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class BillingCompanyTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BillingCompany.class);
        BillingCompany billingCompany1 = new BillingCompany();
        billingCompany1.setId(1L);
        BillingCompany billingCompany2 = new BillingCompany();
        billingCompany2.setId(billingCompany1.getId());
        assertThat(billingCompany1).isEqualTo(billingCompany2);
        billingCompany2.setId(2L);
        assertThat(billingCompany1).isNotEqualTo(billingCompany2);
        billingCompany1.setId(null);
        assertThat(billingCompany1).isNotEqualTo(billingCompany2);
    }
}
