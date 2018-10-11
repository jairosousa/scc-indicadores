package br.com.sococo.resumo.service.impl;

import br.com.sococo.resumo.domain.Dashboard;
import br.com.sococo.resumo.domain.FiltroBusca;
import br.com.sococo.resumo.domain.dto.*;
import br.com.sococo.resumo.repository.DashboardDiaRepository;
import br.com.sococo.resumo.service.ResumoPorDiaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ResumoPorDiaImpl implements ResumoPorDiaService {

    private final DashboardDiaRepository repository;

    public ResumoPorDiaImpl(DashboardDiaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dashboard> listar(FiltroBusca filter) {
        List<Dashboard> dashboards = new ArrayList<>();

        filter.setAnoLancamento(String.valueOf(filter.getDataLancamento().getYear()));
        filter.setMesLancamento(String.valueOf(filter.getDataLancamento().getMonthValue()));

        System.out.println(filter);

        List<CocoDTO> cocos = listaCocos(filter);
        List<CRIFlococoDTO> criFlococos = listaCriFlococos(filter);
        List<OleoDTO> oleos = listaOleos(filter);
        List<TortaDTO> tortas = listaTorta(filter);
        List<AguaCocoDTO> aguaCocos = listaAguaCocos(filter);
        List<CocoGerminadoDTO> cocoGerminados = listaCocoGerminado(filter);
        List<TotalCacambaDTO> totalCacambas = listaTotalCacamba(filter);
        List<CaixaPadraoDTO> caixaPadraos = listaCaixaPadrao(filter);
        List<TotalFardosDTO> totalFardos = listaTotalFardos(filter);
        Dashboard dashboard = new Dashboard(
            cocos,
            criFlococos,
            oleos,
            tortas,
            aguaCocos,
            cocoGerminados,
            totalCacambas,
            caixaPadraos,
            totalFardos
        );

        dashboards.add(dashboard);
        return dashboards;
    }

    private List<TotalFardosDTO> listaTotalFardos(FiltroBusca filter) {
        List<TotalFardosDTO> objs = new ArrayList<>();
        List<Object[]> objects = repository.findTotalCacambasDia(filter.getMesLancamento(), filter.getAnoLancamento());
        for (Object[] dado : objects) {
            objs.add(new TotalFardosDTO(null, dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return objs;
    }

    private List<CaixaPadraoDTO> listaCaixaPadrao(FiltroBusca filter) {
        List<CaixaPadraoDTO> objs = new ArrayList<>();
        List<Object[]> objects = repository.findTotalCacambasDia(filter.getMesLancamento(), filter.getAnoLancamento());
        for (Object[] dado : objects) {
            objs.add(new CaixaPadraoDTO(null, dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return objs;
    }

    private List<TotalCacambaDTO> listaTotalCacamba(FiltroBusca filter) {
        List<TotalCacambaDTO> objs = new ArrayList<>();
        List<Object[]> objects = repository.findTotalCacambasDia(filter.getMesLancamento(), filter.getAnoLancamento());
        for (Object[] dado : objects) {
            objs.add(new TotalCacambaDTO(null, dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return objs;
    }

    private List<CocoGerminadoDTO> listaCocoGerminado(FiltroBusca filter) {
        List<CocoGerminadoDTO> objs = new ArrayList<>();
        List<Object[]> objects = repository.findPercentGerminadoDia(filter.getMesLancamento(), filter.getAnoLancamento());
        for (Object[] dado : objects) {
            objs.add(new CocoGerminadoDTO(null, dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return objs;
    }

    private List<AguaCocoDTO> listaAguaCocos(FiltroBusca filter) {
        List<AguaCocoDTO> objs = new ArrayList<>();
        List<Object[]> objects = repository.findAguasDia(filter.getMesLancamento(), filter.getAnoLancamento());
        for (Object[] dado : objects) {
            objs.add(new AguaCocoDTO(null, dado[0].toString(), Double.parseDouble(dado[1].toString()), Double.parseDouble(dado[2].toString())));
        }
        return objs;
    }

    private List<TortaDTO> listaTorta(FiltroBusca filter) {
        List<TortaDTO> objs = new ArrayList<>();
        List<Object[]> objects = repository.findTortaDia(filter.getMesLancamento(), filter.getAnoLancamento());
        for (Object[] dado : objects) {
            objs.add(new TortaDTO(null, dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return objs;
    }

    private List<OleoDTO> listaOleos(FiltroBusca filter) {
        List<OleoDTO> objs = new ArrayList<>();
        List<Object[]> objects = repository.findOleosDia(filter.getMesLancamento(), filter.getAnoLancamento());
        for (Object[] dado : objects) {
            objs.add(new OleoDTO(null, dado[0].toString(), Double.parseDouble(dado[1].toString()), Double.parseDouble(dado[2].toString())));
        }
        return objs;
    }

    private List<CRIFlococoDTO> listaCriFlococos(FiltroBusca filter) {
        List<CRIFlococoDTO> objs = new ArrayList<>();
        List<Object[]> objects = repository.findCriFlococoDia(filter.getMesLancamento(), filter.getAnoLancamento());
        for (Object[] dado : objects) {
            objs.add(new CRIFlococoDTO(null, dado[0].toString(), Double.parseDouble(dado[1].toString()), Double.parseDouble(dado[2].toString())));
        }
        return objs;
    }


    private List<CocoDTO> listaCocos(FiltroBusca filter) {
        List<CocoDTO> objs = new ArrayList<>();
        List<Object[]> objects = repository.findCocos(filter.getMesLancamento(), filter.getAnoLancamento());
        for (Object[] dado : objects) {
            objs.add(new CocoDTO(null, dado[0].toString(), Double.parseDouble(dado[1].toString()), Double.parseDouble(dado[2].toString())));
        }
        return objs;
    }
}
