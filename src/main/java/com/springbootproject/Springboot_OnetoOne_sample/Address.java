package com.springbootproject.Springboot_OnetoOne_sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int aid;
    String acity;
    String astreet;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("address")
    Consumer consumer;
}
