package br.com.joao_de_menezes_portifolio.service;

import br.com.joao_de_menezes_portifolio.dto.ProjectRequestDTO;
import br.com.joao_de_menezes_portifolio.dto.ProjectResponseDTO;
import br.com.joao_de_menezes_portifolio.entity.DeveloperProfile;
import br.com.joao_de_menezes_portifolio.entity.Project;
import br.com.joao_de_menezes_portifolio.entity.Skill;
import br.com.joao_de_menezes_portifolio.repository.DeveloperProfileRepository;
import br.com.joao_de_menezes_portifolio.repository.ProjectRepository;
import br.com.joao_de_menezes_portifolio.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;
    private final DeveloperProfileRepository developerProfileRepository;

    @Transactional
    public ProjectResponseDTO createProject(ProjectRequestDTO dto) {
        // Buscando o perfil
        DeveloperProfile profile = developerProfileRepository.findById(dto.developerProfileId())
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado."));

        // Busca as skills
        List<Skill> skills = skillRepository.findAllById(dto.skillIds());

        // Monta a Entidade
        Project project = new Project();
        project.setTitle(dto.title());
        project.setDescription(dto.description());
        project.setPurpose(dto.purpose());
        project.setRepositoryUrl(dto.repositoryUrl());
        project.setImageUrl(dto.imageUrl());

        // Configurando os relacionamentos
        project.setDeveloperProfile(profile);
        project.setSkills(new HashSet<>(skills));

        // Salva e retorna o DTO
        project = projectRepository.save(project);
        return ProjectResponseDTO.fromEntity(project);


    }
}
