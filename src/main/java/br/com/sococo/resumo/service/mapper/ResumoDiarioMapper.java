package br.com.sococo.resumo.service.mapper;

import br.com.sococo.resumo.domain.*;
import br.com.sococo.resumo.service.dto.ResumoDiarioDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ResumoDiario and its DTO ResumoDiarioDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ResumoDiarioMapper extends EntityMapper<ResumoDiarioDTO, ResumoDiario> {



    default ResumoDiario fromId(Long id) {
        if (id == null) {
            return null;
        }
        ResumoDiario resumoDiario = new ResumoDiario();
        resumoDiario.setId(id);
        return resumoDiario;
    }
}
