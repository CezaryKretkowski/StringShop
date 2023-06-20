package com.example.StringShop.controllers.user;

import com.example.StringShop.dtos.user.VoivodeshipDto;
import com.example.StringShop.services.user.VoivodeshipService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dictionary")
@AllArgsConstructor
public class VoivodeshipController {

    private final VoivodeshipService voivodeshipService;
    @GetMapping("/voivodeship")
    public List<VoivodeshipDto> getAllVoivodeship(){
        return voivodeshipService.getVoivodeshipList();
    }
}
