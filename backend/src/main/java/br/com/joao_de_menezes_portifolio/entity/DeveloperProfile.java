package br.com.joao_de_menezes_portifolio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class DeveloperProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String fullName; // João de Menezes Ferreira Júnior
    @Setter
    private int age;
    @Setter
    private String headline;
    @Setter
    private String email;
    @Setter
    private String githubUrl;
    @Setter
    private String linkedinUrl;

    @OneToMany(mappedBy = "developerProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();

    public DeveloperProfile() {
    }
}
