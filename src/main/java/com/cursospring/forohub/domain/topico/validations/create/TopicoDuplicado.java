package com.cursospring.forohub.domain.topico.validations.create;

import com.cursospring.forohub.domain.topico.dto.CrearTopicoDTO;
import com.cursospring.forohub.domain.topico.repository.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements ValidarTopicoCreado{
    @Autowired
    private TopicoRepository topicoRepository;


    @Override
    public void validate(CrearTopicoDTO data) {
        var topicoDuplicado = topicoRepository.existsByTituloAndMensaje(data.titulo(), data.mensaje());
        if(topicoDuplicado){
            throw new ValidationException("Tema duplicado" + topicoRepository.findByTitulo(data.titulo()).getId());

        }
    }
}
