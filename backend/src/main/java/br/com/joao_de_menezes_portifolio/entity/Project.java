package br.com.joao_de_menezes_portifolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa um projeto exibido no portfólio.
 * Cada projeto pertence a um perfil profissional e pode utilizar várias habilidades.
 */
@Getter
@Entity
@Table(name = "projects")
public class Project {
    // Identificador único gerado automaticamente pelo banco de dados.
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    // Nome do projeto exibido no portfólio.
    @Setter
    private String title;

    @Setter
    @Column(length = 1000)
    private String description;  // Explicação detalhada do projeto. O limite maior permite textos mais completos.
    @Setter
    private String purpose;      // Problema que o projeto resolve ou objetivo para o qual ele foi criado.
    @Setter
    private String repositoryUrl;
    @Setter
    private String imageUrl;

    // Vários projetos podem pertencer ao mesmo perfil profissional.
    // FetchType.LAZY evita carregar o perfil completo ao buscar apenas um projeto.
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_profile_id", nullable = false)
    private DeveloperProfile developerProfile;

    // Um projeto pode utilizar várias habilidades, e cada habilidade pode aparecer
    // em vários projetos. A tabela "project_skills" registra essa associação.
    @Setter
    @ManyToMany
    @JoinTable(
            name = "project_skills",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    public Project() {
    }

}
