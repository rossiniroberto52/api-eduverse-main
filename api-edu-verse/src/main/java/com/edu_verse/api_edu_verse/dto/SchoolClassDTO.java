package com.edu_verse.api_edu_verse.dto;

import lombok.Data;

@Data
public class SchoolClassDTO {
    // Apenas os dados que o Front precisa ver ou enviar
    private String name;
    private String description;

    // O pulo do gato: Recebemos apenas o ID do professor, não o objeto inteiro
    private Long teacherId;
}