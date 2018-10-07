package br.com.sococo.resumo.service.mapper;

import br.com.sococo.resumo.domain.*;
import br.com.sococo.resumo.service.dto.DestinatarioDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Destinatario and its DTO DestinatarioDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DestinatarioMapper extends EntityMapper<DestinatarioDTO, Destinatario> {



    default Destinatario fromId(Long id) {
        if (id == null) {
            return null;
        }
        Destinatario destinatario = new Destinatario();
        destinatario.setId(id);
        return destinatario;
    }
}
