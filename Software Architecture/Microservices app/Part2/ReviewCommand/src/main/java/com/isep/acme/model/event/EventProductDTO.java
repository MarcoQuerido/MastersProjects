package com.isep.acme.model.event;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EventProductDTO {

    private Long id;
    private String sku;

}
