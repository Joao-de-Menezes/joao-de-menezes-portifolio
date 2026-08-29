package br.com.joao_de_menezes_portifolio.controller;

import br.com.joao_de_menezes_portifolio.dto.DeveloperProfileRequestDTO;
import br.com.joao_de_menezes_portifolio.dto.DeveloperProfileResponseDTO;
import br.com.joao_de_menezes_portifolio.service.DeveloperProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DeveloperProfileController {

    private final DeveloperProfileService profileService;

    @PostMapping
    public ResponseEntity<DeveloperProfileResponseDTO> create(@RequestBody DeveloperProfileRequestDTO dto) {
        DeveloperProfileResponseDTO response = profileService.createProfile(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeveloperProfileResponseDTO> getById(@PathVariable Long id) {
        DeveloperProfileResponseDTO response = profileService.getProfile(id);//busca pelo ID
        return ResponseEntity.ok(response);
    }
}