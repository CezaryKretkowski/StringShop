package com.example.StringShop.entites.dictionary;

import com.example.StringShop.entites.user.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "voivodeship_id",referencedColumnName = "id")
    private Voivodeship voivodeship;
    @OneToOne(mappedBy = "city")
    private Address address;

}
