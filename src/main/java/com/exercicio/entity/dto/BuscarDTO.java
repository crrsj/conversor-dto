package com.exercicio.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BuscarDTO {
    private Long id;
    private String nome;
    private String fone;
    private String email;
}
