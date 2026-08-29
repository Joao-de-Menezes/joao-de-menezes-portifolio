package br.com.joao_de_menezes_portifolio.dto;

import br.com.joao_de_menezes_portifolio.entity.DeveloperProfile;

import java.util.List;

public record DeveloperProfileResponseDTO(
        Long id,
        String fullName,
        int age,
        String headline,
        String email,
        String githubUrl,
        String linkedinUrl,
        List<ProjectResponseDTO> projects
) {
    public static DeveloperProfileResponseDTO fromEntity(DeveloperProfile developerProfile) {
        return new DeveloperProfileResponseDTO(
                developerProfile.getId(),
                developerProfile.getFullName(),
                developerProfile.getAge(),
                developerProfile.getHeadline(),
                developerProfile.getEmail(),
                developerProfile.getGithubUrl(),
                developerProfile.getLinkedinUrl(),
                developerProfile.getProjects().stream()
                        .map(ProjectResponseDTO::fromEntity)
                        .toList()
        );
    }
}
