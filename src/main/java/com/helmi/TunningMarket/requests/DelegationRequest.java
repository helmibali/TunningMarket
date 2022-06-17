package com.helmi.TunningMarket.requests;

import lombok.Data;

@Data
public class DelegationRequest {
    private Long id;
    private String libelle;
    private Long gouvernorat_id;
}
