package com.cursospring.forohub.domain.usuario.validations.update;

import com.cursospring.forohub.domain.usuario.dto.ActualizarUsuarioDTO;

public interface ValidarActualizarUsuario {
    void validate(ActualizarUsuarioDTO data);
}