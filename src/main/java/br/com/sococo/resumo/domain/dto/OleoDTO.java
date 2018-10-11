package br.com.sococo.resumo.domain.dto;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.util.StringUtils;

import java.text.DateFormatSymbols;

public class OleoDTO {
    private String mesLancamento;
    private String diaLancamento;
    private Double oleoIndustrialTipoA;
    private Double oleoIndustrialETE;

    public OleoDTO() {
    }

    public OleoDTO(String mesLancamento, Double oleoIndustrialTipoA, Double oleoIndustrialETE) {
        this.mesLancamento = mesLancamento;
        this.oleoIndustrialTipoA = oleoIndustrialTipoA;
        this.oleoIndustrialETE = oleoIndustrialETE;
    }

    public OleoDTO(String mesLancamento, String diaLancamento, Double oleoIndustrialTipoA, Double oleoIndustrialETE) {
        this.mesLancamento = mesLancamento;
        this.diaLancamento = diaLancamento;
        this.oleoIndustrialTipoA = oleoIndustrialTipoA;
        this.oleoIndustrialETE = oleoIndustrialETE;
    }

    public OleoDTO(ResumoDiario resumoDiario) {
        this(resumoDiario.getMesLancamento(), resumoDiario.getDiaLancamento(), resumoDiario.getOleoIndustrialTipoA(), resumoDiario.getOleoIndustrialETE());
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

    public Double getOleoIndustrialTipoA() {
        return oleoIndustrialTipoA;
    }

    public void setOleoIndustrialTipoA(Double oleoIndustrialTipoA) {
        this.oleoIndustrialTipoA = oleoIndustrialTipoA;
    }

    public Double getOleoIndustrialETE() {
        return oleoIndustrialETE;
    }

    public void setOleoIndustrialETE(Double oleoIndustrialETE) {
        this.oleoIndustrialETE = oleoIndustrialETE;
    }
}
