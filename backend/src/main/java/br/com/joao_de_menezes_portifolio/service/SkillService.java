package br.com.joao_de_menezes_portifolio.service;

import br.com.joao_de_menezes_portifolio.dto.SkillRequestDTO;
import br.com.joao_de_menezes_portifolio.dto.SkillResponseDTO;
import br.com.joao_de_menezes_portifolio.entity.Skill;
import br.com.joao_de_menezes_portifolio.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;
    @Transactional
    public SkillResponseDTO createSkill(SkillRequestDTO dto) {
        Skill skill = new Skill();
        skill.setName(dto.name());
        skill.setCategory(dto.category());
        skill.setLevel(dto.level());

        skill = skillRepository.save(skill);
        return SkillResponseDTO.fromEntity(skill);
    }
}
