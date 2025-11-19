package org.trebol.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.trebol.web.rest.TestUtil;

class PaymentTypeDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentTypeDTO.class);
        PaymentTypeDTO paymentTypeDTO1 = new PaymentTypeDTO();
        paymentTypeDTO1.setId(1L);
        PaymentTypeDTO paymentTypeDTO2 = new PaymentTypeDTO();
        assertThat(paymentTypeDTO1).isNotEqualTo(paymentTypeDTO2);
        paymentTypeDTO2.setId(paymentTypeDTO1.getId());
        assertThat(paymentTypeDTO1).isEqualTo(paymentTypeDTO2);
        paymentTypeDTO2.setId(2L);
        assertThat(paymentTypeDTO1).isNotEqualTo(paymentTypeDTO2);
        paymentTypeDTO1.setId(null);
        assertThat(paymentTypeDTO1).isNotEqualTo(paymentTypeDTO2);
    }
}
