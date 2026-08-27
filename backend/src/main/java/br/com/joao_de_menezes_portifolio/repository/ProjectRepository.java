package br.com.joao_de_menezes_portifolio.repository;

import br.com.joao_de_menezes_portifolio.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
