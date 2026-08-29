package br.com.joao_de_menezes_portifolio.dto;

import br.com.joao_de_menezes_portifolio.entity.Skill;

public record SkillResponseDTO(Long id, String name, String category, String level) {
    public static SkillResponseDTO fromEntity(Skill skill) {
        return new SkillResponseDTO(skill.getId(), skill.getName(), skill.getCategory(), skill.getLevel());
    }
}
