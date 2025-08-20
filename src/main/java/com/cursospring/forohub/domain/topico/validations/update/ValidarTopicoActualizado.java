package com.cursospring.forohub.domain.topico.validations.update;

import com.cursospring.forohub.domain.topico.dto.ActualizarTopicoDTO;

public interface ValidarTopicoActualizado {
    void validate(ActualizarTopicoDTO data);
}