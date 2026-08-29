package br.com.joao_de_menezes_portifolio.dto;

import java.util.Set;

public record ProjectRequestDTO(
        String title,
        String description,
        String purpose,
        String repositoryUrl,
        String imageUrl,
        Long developerProfileId,
        Set<Long> skillIds
) {
}
