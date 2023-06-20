package com.example.StringShop.dtos.user;

import java.util.List;

public record VoivodeshipDto(long id, String name, List<CityDto> cities) {
}
