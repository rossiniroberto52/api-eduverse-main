package com.edu_verse.api_edu_verse.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "tb_classes") // Nome da tabela no banco
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    // AQUI MORA A RELAÇÃO
    // Muitas turmas (SchoolClass) pertencem a UM Professor (Teacher)
    @ManyToOne(fetch = FetchType.LAZY) // Lazy carrega o professor só quando necessário (performance)
    @JoinColumn(name = "teacher_id", nullable = false) // Cria a coluna teacher_id na tabela tb_classes
    @ToString.Exclude // OBRIGATÓRIO com Lombok para evitar loop infinito de toString
    private Teacher teacher;
}