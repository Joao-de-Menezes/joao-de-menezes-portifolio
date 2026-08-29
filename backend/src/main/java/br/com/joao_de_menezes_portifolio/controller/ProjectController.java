package br.com.joao_de_menezes_portifolio.controller;

import br.com.joao_de_menezes_portifolio.dto.ProjectRequestDTO;
import br.com.joao_de_menezes_portifolio.dto.ProjectResponseDTO;
import br.com.joao_de_menezes_portifolio.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> create(@RequestBody ProjectRequestDTO dto) {
        ProjectResponseDTO response = projectService.createProject(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}