package br.com.sococo.resumo.domain.dto;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.util.StringUtils;

import java.text.DateFormatSymbols;

public class CRIFlococoDTO {
    private String mesLancamento;
    private String diaLancamento;
    private Double cri;
    private Double flococo;

    public CRIFlococoDTO() {
    }

    public CRIFlococoDTO(String mesLancamento, String diaLancamento, Double cli, Double flococo) {
        this.mesLancamento = mesLancamento;
        this.diaLancamento = diaLancamento;
        this.cri = cli;
        this.flococo = flococo;
    }

    public CRIFlococoDTO(String mesLancamento, Double cli, Double flococo) {
        this.mesLancamento = mesLancamento;
        this.cri = cli;
        this.flococo = flococo;
    }

    public CRIFlococoDTO(ResumoDiario resumoDiario){
        this(resumoDiario.getMesLancamento(), resumoDiario.getDiaLancamento(),resumoDiario.getCri(), resumoDiario.getFlococo());
    }

    public String getMesLancamento() {
        if (StringUtils.isEmpty(mesLancamento)) {
            return null;
        }
        String nomeMesCompleto = new DateFormatSymbols().getMonths()[Integer.parseInt(mesLancamento)-1];
        return nomeMesCompleto.substring(0,3);
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

    public Double getCri() {
        return cri;
    }

    public void setCri(Double cri) {
        this.cri = cri;
    }

    public Double getFlococo() {
        return flococo;
    }

    public void setFlococo(Double flococo) {
        this.flococo = flococo;
    }
}


