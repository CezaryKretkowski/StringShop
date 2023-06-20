package com.example.StringShop.repositories;

import com.example.StringShop.entites.dictionary.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
