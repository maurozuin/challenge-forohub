package com.cursospring.forohub.domain.topico.dto;

import com.cursospring.forohub.domain.topico.Estado;

public record ActualizarTopicoDTO (
        String titulo,
        String mensaje,
        Estado estado,
        Long cursoId
){
}
