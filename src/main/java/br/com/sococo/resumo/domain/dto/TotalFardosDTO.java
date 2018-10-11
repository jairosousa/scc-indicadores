package br.com.sococo.resumo.domain.dto;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.util.StringUtils;

import java.text.DateFormatSymbols;

public class TotalFardosDTO {
    private String mesLancamento;
    private String diaLancamento;
    private Double numeroFardos;

    public TotalFardosDTO() {
    }

    public TotalFardosDTO(String mesLancamento, Double numeroFardos) {
        this.mesLancamento = mesLancamento;
        this.numeroFardos = numeroFardos;
    }

    public TotalFardosDTO(String mesLancamento, String diaLancamento, Double numeroFardos) {
        this.mesLancamento = mesLancamento;
        this.diaLancamento = diaLancamento;
        this.numeroFardos = numeroFardos;
    }

    public TotalFardosDTO(ResumoDiario resumoDiario) {
        this(resumoDiario.getMesLancamento(), resumoDiario.getDiaLancamento(), resumoDiario.getNumeroDeFardos());
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

    public Double getNumeroFardos() {
        return numeroFardos;
    }

    public void setNumeroFardos(Double numeroFardos) {
        this.numeroFardos = numeroFardos;
    }
}
