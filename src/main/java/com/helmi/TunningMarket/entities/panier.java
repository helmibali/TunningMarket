package com.helmi.TunningMarket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
 
}
