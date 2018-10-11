package br.com.sococo.resumo.web.rest;

import br.com.sococo.resumo.domain.Dashboard;
import br.com.sococo.resumo.domain.FiltroBusca;
import br.com.sococo.resumo.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class DashboardResource {

    private final DashboardService dashboardService;

    public DashboardResource(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping(value = "/dashboard/ano")
    public ResponseEntity<List<Dashboard>> findAno(FiltroBusca filter) {
        List<Dashboard> lists = dashboardService.findAno(filter);
        return ResponseEntity
            .ok()
            .body(lists);
    }

    @GetMapping(value = "/dashboard/mes")
    public ResponseEntity<List<Dashboard>> findMes(FiltroBusca filter) {
        List<Dashboard> lists = dashboardService.findMes(filter);
        return ResponseEntity
            .ok()
            .body(lists);
    }
}
