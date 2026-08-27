package br.com.joao_de_menezes_portifolio.repository;

import br.com.joao_de_menezes_portifolio.entity.DeveloperProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperProfileRepository extends JpaRepository<DeveloperProfile, Long> {
}
