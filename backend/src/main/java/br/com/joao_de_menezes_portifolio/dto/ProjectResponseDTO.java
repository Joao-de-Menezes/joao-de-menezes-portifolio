package br.com.joao_de_menezes_portifolio.dto;

import java.util.Set;

public record ProjectResponseDTO(
        Long id,
        String title,
        String description,
        String purpose,
        String repositoryUrl,
        String imageUrl,
        Set<SkillResponseDTO> skills
) {
    public static ProjectResponseDTO fromEntity(br.com.joao_de_menezes_portifolio.entity.Project project) {
        Set<SkillResponseDTO> skillResponseDTOs = project.getSkills().stream()
                .map(SkillResponseDTO::fromEntity)
                .collect(java.util.stream.Collectors.toSet());

        return new ProjectResponseDTO(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getPurpose(),
                project.getRepositoryUrl(),
                project.getImageUrl(),
                skillResponseDTOs
        );
    }
}
