package com.example.StringShop.services.user;

import com.example.StringShop.dtos.user.VoivodeshipDto;
import com.example.StringShop.entites.dictionary.Voivodeship;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VoivodeshipService {
    List<VoivodeshipDto> getVoivodeshipList();
}
