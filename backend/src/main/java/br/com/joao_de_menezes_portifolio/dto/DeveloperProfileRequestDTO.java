package br.com.joao_de_menezes_portifolio.dto;

public record DeveloperProfileRequestDTO(
        String fullName,
        int age,
        String headline,
        String email,
        String githubUrl,
        String linkedinUrl
) {
}
