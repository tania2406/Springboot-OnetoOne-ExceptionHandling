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
public class Consumer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("consumer")
    Address address;

}
