package br.com.sococo.resumo.domain.dto;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.util.StringUtils;

import java.text.DateFormatSymbols;

public class AguaCocoDTO {
    private String mesLancamento;
    private String diaLancamento;
    private Double aguaDeCocoSococo;
    private Double aguaDeCocoVerde;

    public AguaCocoDTO() {
    }

    public AguaCocoDTO(String mesLancamento, Double aguaDeCocoSococo, Double aguaDeCocoVerde) {
        this.mesLancamento = mesLancamento;
        this.aguaDeCocoSococo = aguaDeCocoSococo;
        this.aguaDeCocoVerde = aguaDeCocoVerde;
    }

    public AguaCocoDTO(String mesLancamento, String diaLancamento, Double aguaDeCocoSococo, Double aguaDeCocoVerde) {
        this.mesLancamento = mesLancamento;
        this.diaLancamento = diaLancamento;
        this.aguaDeCocoSococo = aguaDeCocoSococo;
        this.aguaDeCocoVerde = aguaDeCocoVerde;
    }

    public AguaCocoDTO(ResumoDiario resumoDiario) {
        this(resumoDiario.getMesLancamento(), resumoDiario.getDiaLancamento(), resumoDiario.getAguaDeCocoSococo(), resumoDiario.getAguaDeCocoVerde());
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

    public Double getAguaDeCocoSococo() {
        return aguaDeCocoSococo;
    }

    public void setAguaDeCocoSococo(Double aguaDeCocoSococo) {
        this.aguaDeCocoSococo = aguaDeCocoSococo;
    }

    public Double getAguaDeCocoVerde() {
        return aguaDeCocoVerde;
    }

    public void setAguaDeCocoVerde(Double aguaDeCocoVerde) {
        this.aguaDeCocoVerde = aguaDeCocoVerde;
    }
}

