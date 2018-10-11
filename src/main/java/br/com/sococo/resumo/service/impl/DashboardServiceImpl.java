package br.com.sococo.resumo.service.impl;

import br.com.sococo.resumo.domain.Dashboard;
import br.com.sococo.resumo.domain.FiltroBusca;
import br.com.sococo.resumo.service.DashboardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService {

    @Override
    public List<Dashboard> findAno(FiltroBusca filter) {
        return null;
    }

    @Override
    public List<Dashboard> findMes(FiltroBusca filter) {
        return null;
    }
}
