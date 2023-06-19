package com.example.StringShop.entites.user;

import com.example.StringShop.entites.dictionary.City;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
    private String street;
    private String postCode;
    private int houseNumber;
    private int flatNumber;
    @OneToOne(mappedBy = "address")
    private User user;


}
