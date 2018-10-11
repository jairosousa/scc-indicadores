package br.com.sococo.resumo.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A ResumoDiario.
 */
@Entity
@Table(name = "resumo_diario")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ResumoDiario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    @Column(name = "cocos_processados")
    private Double cocosProcessados;

    @Column(name = "cocos_desfibrados")
    private Double cocosDesfibrados;

    @Column(name = "cri")
    private Double cri;

    @Column(name = "flococo")
    private Double flococo;

    @Column(name = "oleo_industrial_tipo_a")
    private Double oleoIndustrialTipoA;

    @Column(name = "oleo_industrial_ete")
    private Double oleoIndustrialETE;

    @Column(name = "torta")
    private Double torta;

    @Column(name = "agua_de_coco_sococo")
    private Double aguaDeCocoSococo;

    @Column(name = "agua_de_coco_verde")
    private Double aguaDeCocoVerde;

    @Column(name = "caixa_padrao")
    private Double caixaPadrao;

    @Column(name = "porcentagem_coco_germinado")
    private Double porcentagemCocoGerminado;

    @Column(name = "total_de_cacambas")
    private Double totalDeCacambas;

    @Column(name = "numero_de_fardos")
    private Double numeroDeFardos;

    @Column(name = "dia_lancamento")
    private String diaLancamento;

    @Column(name = "mes_lancamento")
    private String mesLancamento;

    @Column(name = "ano_lancamento")
    private String anoLancamento;

    public ResumoDiario() {
    }

    public ResumoDiario(LocalDate dataLancamento, Double cocosProcessados, Double cocosDesfibrados, Double cri, Double flococo, Double oleoIndustrialTipoA, Double oleoIndustrialETE, Double torta, Double aguaDeCocoSococo, Double aguaDeCocoVerde, Double caixaPadrao, Double porcentagemCocoGerminado, Double totalDeCacambas, Double numeroDeFardos) {
        this.dataLancamento = dataLancamento;
        this.cocosProcessados = cocosProcessados;
        this.cocosDesfibrados = cocosDesfibrados;
        this.cri = cri;
        this.flococo = flococo;
        this.oleoIndustrialTipoA = oleoIndustrialTipoA;
        this.oleoIndustrialETE = oleoIndustrialETE;
        this.torta = torta;
        this.aguaDeCocoSococo = aguaDeCocoSococo;
        this.aguaDeCocoVerde = aguaDeCocoVerde;
        this.totalDeCacambas = totalDeCacambas;
        this.caixaPadrao = caixaPadrao;
        this.numeroDeFardos = numeroDeFardos;
        this.porcentagemCocoGerminado = porcentagemCocoGerminado;
    }

    public ResumoDiario(Double cocosProcessados, Double cocosDesfibrados, Double cri, Double flococo, Double oleoIndustrialTipoA, Double oleoIndustrialETE, Double torta, Double aguaDeCocoSococo, Double aguaDeCocoVerde,  Double caixaPadrao, Double porcentagemCocoGerminado, Double totalDeCacambas, Double numeroDeFardos) {
        this.cocosProcessados = cocosProcessados;
        this.cocosDesfibrados = cocosDesfibrados;
        this.cri = cri;
        this.flococo = flococo;
        this.oleoIndustrialTipoA = oleoIndustrialTipoA;
        this.oleoIndustrialETE = oleoIndustrialETE;
        this.torta = torta;
        this.aguaDeCocoSococo = aguaDeCocoSococo;
        this.aguaDeCocoVerde = aguaDeCocoVerde;
        this.totalDeCacambas = totalDeCacambas;
        this.caixaPadrao = caixaPadrao;
        this.numeroDeFardos = numeroDeFardos;
        this.porcentagemCocoGerminado = porcentagemCocoGerminado;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public ResumoDiario dataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getCocosProcessados() {
        return cocosProcessados;
    }

    public ResumoDiario cocosProcessados(Double cocosProcessados) {
        this.cocosProcessados = cocosProcessados;
        return this;
    }

    public void setCocosProcessados(Double cocosProcessados) {
        this.cocosProcessados = cocosProcessados;
    }

    public Double getCocosDesfibrados() {
        return cocosDesfibrados;
    }

    public ResumoDiario cocosDesfibrados(Double cocosDesfibrados) {
        this.cocosDesfibrados = cocosDesfibrados;
        return this;
    }

    public void setCocosDesfibrados(Double cocosDesfibrados) {
        this.cocosDesfibrados = cocosDesfibrados;
    }

    public Double getCri() {
        return cri;
    }

    public ResumoDiario cri(Double cri) {
        this.cri = cri;
        return this;
    }

    public void setCri(Double cri) {
        this.cri = cri;
    }

    public Double getFlococo() {
        return flococo;
    }

    public ResumoDiario flococo(Double flococo) {
        this.flococo = flococo;
        return this;
    }

    public void setFlococo(Double flococo) {
        this.flococo = flococo;
    }

    public Double getOleoIndustrialTipoA() {
        return oleoIndustrialTipoA;
    }

    public ResumoDiario oleoIndustrialTipoA(Double oleoIndustrialTipoA) {
        this.oleoIndustrialTipoA = oleoIndustrialTipoA;
        return this;
    }

    public void setOleoIndustrialTipoA(Double oleoIndustrialTipoA) {
        this.oleoIndustrialTipoA = oleoIndustrialTipoA;
    }

    public Double getOleoIndustrialETE() {
        return oleoIndustrialETE;
    }

    public ResumoDiario oleoIndustrialETE(Double oleoIndustrialETE) {
        this.oleoIndustrialETE = oleoIndustrialETE;
        return this;
    }

    public void setOleoIndustrialETE(Double oleoIndustrialETE) {
        this.oleoIndustrialETE = oleoIndustrialETE;
    }

    public Double getTorta() {
        return torta;
    }

    public ResumoDiario torta(Double torta) {
        this.torta = torta;
        return this;
    }

    public void setTorta(Double torta) {
        this.torta = torta;
    }

    public Double getAguaDeCocoSococo() {
        return aguaDeCocoSococo;
    }

    public ResumoDiario aguaDeCocoSococo(Double aguaDeCocoSococo) {
        this.aguaDeCocoSococo = aguaDeCocoSococo;
        return this;
    }

    public void setAguaDeCocoSococo(Double aguaDeCocoSococo) {
        this.aguaDeCocoSococo = aguaDeCocoSococo;
    }

    public Double getAguaDeCocoVerde() {
        return aguaDeCocoVerde;
    }

    public ResumoDiario aguaDeCocoVerde(Double aguaDeCocoVerde) {
        this.aguaDeCocoVerde = aguaDeCocoVerde;
        return this;
    }

    public void setAguaDeCocoVerde(Double aguaDeCocoVerde) {
        this.aguaDeCocoVerde = aguaDeCocoVerde;
    }

    public Double getCaixaPadrao() {
        return caixaPadrao;
    }

    public ResumoDiario caixaPadrao(Double caixaPadrao) {
        this.caixaPadrao = caixaPadrao;
        return this;
    }

    public void setCaixaPadrao(Double caixaPadrao) {
        this.caixaPadrao = caixaPadrao;
    }

    public Double getPorcentagemCocoGerminado() {
        return porcentagemCocoGerminado;
    }

    public ResumoDiario porcentagemCocoGerminado(Double porcentagemCocoGerminado) {
        this.porcentagemCocoGerminado = porcentagemCocoGerminado;
        return this;
    }

    public void setPorcentagemCocoGerminado(Double porcentagemCocoGerminado) {
        this.porcentagemCocoGerminado = porcentagemCocoGerminado;
    }

    public Double getTotalDeCacambas() {
        return totalDeCacambas;
    }

    public ResumoDiario totalDeCacambas(Double totalDeCacambas) {
        this.totalDeCacambas = totalDeCacambas;
        return this;
    }

    public void setTotalDeCacambas(Double totalDeCacambas) {
        this.totalDeCacambas = totalDeCacambas;
    }

    public Double getNumeroDeFardos() {
        return numeroDeFardos;
    }

    public ResumoDiario numeroDeFardos(Double numeroDeFardos) {
        this.numeroDeFardos = numeroDeFardos;
        return this;
    }

    public void setNumeroDeFardos(Double numeroDeFardos) {
        this.numeroDeFardos = numeroDeFardos;
    }

    public String getDiaLancamento() {
        return diaLancamento;
    }

    public ResumoDiario diaLancamento(String diaLancamento) {
        this.diaLancamento = diaLancamento;
        return this;
    }

    public void setDiaLancamento(String diaLancamento) {
        this.diaLancamento = diaLancamento;
    }

    public String getMesLancamento() {
        return mesLancamento;
    }

    public ResumoDiario mesLancamento(String mesLancamento) {
        this.mesLancamento = mesLancamento;
        return this;
    }

    public void setMesLancamento(String mesLancamento) {
        this.mesLancamento = mesLancamento;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public ResumoDiario anoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
        return this;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResumoDiario resumoDiario = (ResumoDiario) o;
        if (resumoDiario.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), resumoDiario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ResumoDiario{" +
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
