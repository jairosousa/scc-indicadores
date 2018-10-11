package br.com.sococo.resumo.domain.dto;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.util.StringUtils;

import java.text.DateFormatSymbols;

public class CocoDTO {
    private String mesLancamento;
    private String diaLancamento;
    private Double cocoDesfibrados;
    private Double cocoProcessados;

    public CocoDTO() {
    }

    public CocoDTO(String mesLancamento, String diaLancamento, Double cocoDesfibrados, Double cocoProcessados) {
        this.mesLancamento = mesLancamento;
        this.diaLancamento = diaLancamento;
        this.cocoDesfibrados = cocoDesfibrados;
        this.cocoProcessados = cocoProcessados;
    }

    public CocoDTO(String mesLancamento, Double cocoDesfibrados, Double cocoProcessados) {
        this.mesLancamento = mesLancamento;
        this.cocoDesfibrados = cocoDesfibrados;
        this.cocoProcessados = cocoProcessados;
    }

    public String getMesLancamento() {
        if (StringUtils.isEmpty(mesLancamento)) {
            return null;
        }
        //converto o numero para o nome do mês
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

    public Double getCocoDesfibrados() {
        return cocoDesfibrados;
    }

    public void setCocoDesfibrados(Double cocoDesfibrados) {
        this.cocoDesfibrados = cocoDesfibrados;
    }

    public Double getCocoProcessados() {
        return cocoProcessados;
    }

    public void setCocoProcessados(Double cocoProcessados) {
        this.cocoProcessados = cocoProcessados;
    }
}
