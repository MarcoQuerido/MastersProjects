package org.trebol.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class BillingCompanyDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BillingCompanyDTO.class);
        BillingCompanyDTO billingCompanyDTO1 = new BillingCompanyDTO();
        billingCompanyDTO1.setId(1L);
        BillingCompanyDTO billingCompanyDTO2 = new BillingCompanyDTO();
        assertThat(billingCompanyDTO1).isNotEqualTo(billingCompanyDTO2);
        billingCompanyDTO2.setId(billingCompanyDTO1.getId());
        assertThat(billingCompanyDTO1).isEqualTo(billingCompanyDTO2);
        billingCompanyDTO2.setId(2L);
        assertThat(billingCompanyDTO1).isNotEqualTo(billingCompanyDTO2);
        billingCompanyDTO1.setId(null);
        assertThat(billingCompanyDTO1).isNotEqualTo(billingCompanyDTO2);
    }
}
