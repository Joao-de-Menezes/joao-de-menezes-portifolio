package br.com.joao_de_menezes_portifolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;       // Java, Spring Boot, React
    private String category;   // Backend, Frontend, Database
    private String level;      // Beginner, Intermediate, Advanced

    public Skill() {
    }

}