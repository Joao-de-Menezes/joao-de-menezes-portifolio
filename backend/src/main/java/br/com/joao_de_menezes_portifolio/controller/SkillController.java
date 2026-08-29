package br.com.joao_de_menezes_portifolio.controller;

import br.com.joao_de_menezes_portifolio.dto.SkillRequestDTO;
import br.com.joao_de_menezes_portifolio.dto.SkillResponseDTO;
import br.com.joao_de_menezes_portifolio.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SkillController {

    private final SkillService skillService;

    @PostMapping
    public ResponseEntity<SkillResponseDTO> create(@RequestBody SkillRequestDTO dto) {
        SkillResponseDTO response = skillService.createSkill(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}