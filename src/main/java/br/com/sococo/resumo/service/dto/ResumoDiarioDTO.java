package br.com.sococo.resumo.service.dto;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the ResumoDiario entity.
 */
public class ResumoDiarioDTO implements Serializable {

    private Long id;

    private LocalDate dataLancamento;

    private Double cocosProcessados;

    private Double cocosDesfibrados;

    private Double cri;

    private Double flococo;

    private Double oleoIndustrialTipoA;

    private Double oleoIndustrialETE;

    private Double torta;

    private Double aguaDeCocoSococo;

    private Double aguaDeCocoVerde;

    private Double caixaPadrao;

    private Double porcentagemCocoGerminado;

    private Double totalDeCacambas;

    private Double numeroDeFardos;

    private String diaLancamento;

    private String mesLancamento;

    private String anoLancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getCocosProcessados() {
        return cocosProcessados;
    }

    public void setCocosProcessados(Double cocosProcessados) {
        this.cocosProcessados = cocosProcessados;
    }

    public Double getCocosDesfibrados() {
        return cocosDesfibrados;
    }

    public void setCocosDesfibrados(Double cocosDesfibrados) {
        this.cocosDesfibrados = cocosDesfibrados;
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

    public Double getTorta() {
        return torta;
    }

    public void setTorta(Double torta) {
        this.torta = torta;
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

    public Double getCaixaPadrao() {
        return caixaPadrao;
    }

    public void setCaixaPadrao(Double caixaPadrao) {
        this.caixaPadrao = caixaPadrao;
    }

    public Double getPorcentagemCocoGerminado() {
        return porcentagemCocoGerminado;
    }

    public void setPorcentagemCocoGerminado(Double porcentagemCocoGerminado) {
        this.porcentagemCocoGerminado = porcentagemCocoGerminado;
    }

    public Double getTotalDeCacambas() {
        return totalDeCacambas;
    }

    public void setTotalDeCacambas(Double totalDeCacambas) {
        this.totalDeCacambas = totalDeCacambas;
    }

    public Double getNumeroDeFardos() {
        return numeroDeFardos;
    }

    public void setNumeroDeFardos(Double numeroDeFardos) {
        this.numeroDeFardos = numeroDeFardos;
    }

    public String getDiaLancamento() {
        return diaLancamento;
    }

    public void setDiaLancamento(String diaLancamento) {
        this.diaLancamento = diaLancamento;
    }

    public String getMesLancamento() {
        return mesLancamento;
    }

    public void setMesLancamento(String mesLancamento) {
        this.mesLancamento = mesLancamento;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ResumoDiarioDTO resumoDiarioDTO = (ResumoDiarioDTO) o;
        if (resumoDiarioDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), resumoDiarioDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ResumoDiarioDTO{" +
            "id=" + getId() +
            ", dataLancamento='" + getDataLancamento() + "'" +
            ", cocosProcessados=" + getCocosProcessados() +
            ", cocosDesfibrados=" + getCocosDesfibrados() +
            ", cri=" + getCri() +
            ", flococo=" + getFlococo() +
            ", oleoIndustrialTipoA=" + getOleoIndustrialTipoA() +
            ", oleoIndustrialETE=" + getOleoIndustrialETE() +
            ", torta=" + getTorta() +
            ", aguaDeCocoSococo=" + getAguaDeCocoSococo() +
            ", aguaDeCocoVerde=" + getAguaDeCocoVerde() +
            ", caixaPadrao=" + getCaixaPadrao() +
            ", porcentagemCocoGerminado=" + getPorcentagemCocoGerminado() +
            ", totalDeCacambas=" + getTotalDeCacambas() +
            ", numeroDeFardos=" + getNumeroDeFardos() +
            ", diaLancamento='" + getDiaLancamento() + "'" +
            ", mesLancamento='" + getMesLancamento() + "'" +
            ", anoLancamento='" + getAnoLancamento() + "'" +
            "}";
    }
}
