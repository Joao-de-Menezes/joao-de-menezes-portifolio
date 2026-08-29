package br.com.joao_de_menezes_portifolio.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class DeveloperProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName; // João de Menezes Ferreira Júnior
    private int age;
    private String headline;
    private String email;
    private String githubUrl;
    private String linkedinUrl;

    @OneToMany(mappedBy = "developerProfile", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Project> projects = new ArrayList<>();
}
