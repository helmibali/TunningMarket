package com.helmi.TunningMarket.requests;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Lob;
@Data
public class BarandRequest {
    private Long id;
    private String name;
    private String image;
}
