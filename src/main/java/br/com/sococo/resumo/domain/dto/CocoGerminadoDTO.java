package br.com.sococo.resumo.domain.dto;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.util.StringUtils;

import java.text.DateFormatSymbols;

public class CocoGerminadoDTO {
    private String mesLancamento;
    private String diaLancamento;
    private Double cocoGerminado;


    public CocoGerminadoDTO() {
    }

    public CocoGerminadoDTO(String mesLancamento, Double cocoGerminado) {
        this.mesLancamento = mesLancamento;
        this.cocoGerminado = cocoGerminado;
    }

    public CocoGerminadoDTO(String mesLancamento, String diaLancamento, Double cocoGerminado) {
        this.mesLancamento = mesLancamento;
        this.diaLancamento = diaLancamento;
        this.cocoGerminado = cocoGerminado;
    }

    public CocoGerminadoDTO(ResumoDiario resumoDiario) {
        this(resumoDiario.getMesLancamento(), resumoDiario.getDiaLancamento(), resumoDiario.getTorta());
    }

    public String getMesLancamento() {
        if (StringUtils.isEmpty(mesLancamento)) {
            return null;
        }
        String nomeMesCompleto = new DateFormatSymbols().getMonths()[Integer.parseInt(mesLancamento) - 1];
        return nomeMesCompleto.substring(0, 3);
    }

    public void setMesLancamento(String mesLancamento) {
        this.mesLancamento = mesLancamento;
    }

    public String getDiaLancamento() {
        return diaLancamento;
    }

    public void setDiaLancamento(String diaLancamento) {
        this.diaLancamento = diaLancamento;
    }

    public Double getCocoGerminado() {
        return cocoGerminado;
    }

    public void setCocoGerminado(Double cocoGerminado) {
        this.cocoGerminado = cocoGerminado;
    }
}
