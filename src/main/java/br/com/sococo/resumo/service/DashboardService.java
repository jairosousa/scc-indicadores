package br.com.sococo.resumo.service;

import br.com.sococo.resumo.domain.Dashboard;
import br.com.sococo.resumo.domain.FiltroBusca;

import java.util.List;

public interface DashboardService {
    public List<Dashboard> findAno(FiltroBusca filter);

    public List<Dashboard> findMes(FiltroBusca filter);
}
