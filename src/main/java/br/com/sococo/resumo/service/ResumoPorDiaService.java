package br.com.sococo.resumo.service;

import br.com.sococo.resumo.domain.Dashboard;
import br.com.sococo.resumo.domain.FiltroBusca;

import java.util.List;

public interface ResumoPorDiaService {
    public List<Dashboard> listar(FiltroBusca filter);
}
