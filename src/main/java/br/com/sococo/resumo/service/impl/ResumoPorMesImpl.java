package br.com.sococo.resumo.service.impl;

import br.com.sococo.resumo.domain.Dashboard;
import br.com.sococo.resumo.domain.FiltroBusca;
import br.com.sococo.resumo.domain.dto.*;
import br.com.sococo.resumo.repository.DashboardMesRepository;
import br.com.sococo.resumo.service.ResumoPorMesService;

import java.util.ArrayList;
import java.util.List;

public class ResumoPorMesImpl implements ResumoPorMesService {

    private final DashboardMesRepository repository;

    public ResumoPorMesImpl(DashboardMesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dashboard> listar(FiltroBusca filter) {
        List<Dashboard> dashboards = new ArrayList<>();

        filter.setAnoLancamento(String.valueOf(filter.getDataLancamento().getYear()));

        List<CocoDTO> cocos = listaCocos(filter);
        List<CRIFlococoDTO> criFlococos = listaCRIFlococos(filter);
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
        List<TotalFardosDTO> obj = new ArrayList<>();
        List<Object[]> objects = repository.findNumFardosAno(filter.getAnoLancamento());

        for (Object[] dado : objects) {
            obj.add(new TotalFardosDTO(dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return obj;
    }

    private List<CaixaPadraoDTO> listaCaixaPadrao(FiltroBusca filter) {
        List<CaixaPadraoDTO> obj = new ArrayList<>();
        List<Object[]> objects = repository.findCaixaPadraoAno(filter.getAnoLancamento());

        for (Object[] dado : objects) {
            obj.add(new CaixaPadraoDTO(dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return obj;
    }

    private List<TotalCacambaDTO> listaTotalCacamba(FiltroBusca filter) {
        List<TotalCacambaDTO> obj = new ArrayList<>();
        List<Object[]> objects = repository.findTotalCacambasAno(filter.getAnoLancamento());

        for (Object[] dado : objects) {
            obj.add(new TotalCacambaDTO(dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return obj;
    }

    private List<CocoGerminadoDTO> listaCocoGerminado(FiltroBusca filter) {
        List<CocoGerminadoDTO> obj = new ArrayList<>();
        List<Object[]> objects = repository.findPercentGerminadoAno(filter.getAnoLancamento());

        for (Object[] dado : objects) {
            obj.add(new CocoGerminadoDTO(dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return obj;
    }

    private List<AguaCocoDTO> listaAguaCocos(FiltroBusca filter) {
        List<AguaCocoDTO> obj = new ArrayList<>();
        List<Object[]> objects = repository.findAguaCocosAno(filter.getAnoLancamento());

        for (Object[] dado : objects) {
            obj.add(new AguaCocoDTO(dado[0].toString(), Double.parseDouble(dado[1].toString()), Double.parseDouble(dado[2].toString())));
        }
        return obj;
    }

    private List<TortaDTO> listaTorta(FiltroBusca filter) {
        List<TortaDTO> obj = new ArrayList<>();
        List<Object[]> objects = repository.findTortaAno(filter.getAnoLancamento());

        for (Object[] dado : objects) {
            obj.add(new TortaDTO(dado[0].toString(), Double.parseDouble(dado[1].toString())));
        }
        return obj;
    }

    private List<OleoDTO> listaOleos(FiltroBusca filter) {
        List<OleoDTO> obj = new ArrayList<>();
        List<Object[]> objects = repository.findOleoAno(filter.getAnoLancamento());

        for (Object[] dado : objects) {
            obj.add(new OleoDTO(dado[0].toString(), Double.parseDouble(dado[1].toString()), Double.parseDouble(dado[2].toString())));
        }
        return obj;
    }

    private List<CRIFlococoDTO> listaCRIFlococos(FiltroBusca filter) {
        List<CRIFlococoDTO> obj = new ArrayList<>();
        List<Object[]> objects = repository.findCRIFlococoAno(filter.getAnoLancamento());

        for (Object[] dado : objects) {
            obj.add(new CRIFlococoDTO(dado[0].toString(), Double.parseDouble(dado[1].toString()), Double.parseDouble(dado[2].toString())));
        }
        return obj;

    }

    private List<CocoDTO> listaCocos(FiltroBusca filter) {
        List<CocoDTO> obj = new ArrayList<>();
        List<Object[]> objects = repository.findCocoAno(filter.getAnoLancamento());

        for (Object[] dado : objects) {
            obj.add(new CocoDTO(dado[0].toString(), Double.parseDouble(dado[1].toString()), Double.parseDouble(dado[2].toString())));
        }
        return obj;
    }

}
