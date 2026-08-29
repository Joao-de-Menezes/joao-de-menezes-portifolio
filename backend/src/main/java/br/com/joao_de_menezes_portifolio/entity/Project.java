package br.com.joao_de_menezes_portifolio.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Representa um projeto exibido no portfólio.
 * Cada projeto pertence a um perfil profissional e pode utilizar várias habilidades.
 */
@Entity
@Table(name = "projects")
public class Project {
    // Identificador único gerado automaticamente pelo banco de dados.
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    // Nome do projeto exibido no portfólio.
    private String title;

    @Column(length = 1000)
    private String description;  // Explicação detalhada do projeto. O limite maior permite textos mais completos.
    private String purpose;      // Problema que o projeto resolve ou objetivo para o qual ele foi criado.
    private String repositoryUrl;
    private String imageUrl;

    // Vários projetos podem pertencer ao mesmo perfil profissional.
    // FetchType.LAZY evita carregar o perfil completo ao buscar apenas um projeto.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_profile_id", nullable = false)
    private DeveloperProfile developerProfile;

    // Um projeto pode utilizar várias habilidades, e cada habilidade pode aparecer
    // em vários projetos. A tabela "project_skills" registra essa associação.
    @ManyToMany
    @JoinTable(
            name = "project_skills",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    public Project() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public DeveloperProfile getDeveloperProfile() {
        return developerProfile;
    }

    public void setDeveloperProfile(DeveloperProfile developerProfile) {
        this.developerProfile = developerProfile;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }
}
