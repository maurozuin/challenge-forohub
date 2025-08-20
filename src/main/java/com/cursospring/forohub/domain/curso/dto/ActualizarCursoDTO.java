package com.cursospring.forohub.domain.curso.dto;

import com.cursospring.forohub.domain.curso.Categoria;

public record ActualizarCursoDTO(
        String name,
        Categoria categoria,
        Boolean activo) {
}
