package br.com.sococo.resumo.domain.dto;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.util.StringUtils;

import java.text.DateFormatSymbols;

public class TortaDTO {
    private String mesLancamento;
    private String diaLancamento;
    private Double torta;


    public TortaDTO() {
    }

    public TortaDTO(String mesLancamento, String diaLancamento, Double torta) {
        this.mesLancamento = mesLancamento;
        this.diaLancamento = diaLancamento;
        this.torta = torta;
    }

    public TortaDTO(String mesLancamento, Double torta) {
        this.mesLancamento = mesLancamento;
        this.torta = torta;
    }

    public TortaDTO(ResumoDiario resumoDiario) {
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

    public Double getTorta() {
        return torta;
    }

    public void setTorta(Double torta) {
        this.torta = torta;
    }
}
