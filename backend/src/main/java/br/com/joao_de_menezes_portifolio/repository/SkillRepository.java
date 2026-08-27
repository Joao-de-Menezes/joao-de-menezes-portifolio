package br.com.joao_de_menezes_portifolio.repository;

import br.com.joao_de_menezes_portifolio.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
