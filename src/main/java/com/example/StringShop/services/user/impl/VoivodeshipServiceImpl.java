package com.example.StringShop.services.user.impl;


import com.example.StringShop.dtos.user.CityDto;
import com.example.StringShop.dtos.user.VoivodeshipDto;
import com.example.StringShop.repositories.VoivodeshipRepository;
import com.example.StringShop.services.user.VoivodeshipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VoivodeshipServiceImpl implements VoivodeshipService {

    private final VoivodeshipRepository voivodeshipRepository;
    @Override
    public List<VoivodeshipDto> getVoivodeshipList() {
        var list=  voivodeshipRepository.findAll();
        return  list.stream().map(element -> {
            var cities = element.getCities().stream().map(city->{return new CityDto(city.getId(), city.getName());}).collect(Collectors.toList());
            return new VoivodeshipDto(element.getId(),element.getName(),cities);
        }).collect(Collectors.toList());
    }
}
