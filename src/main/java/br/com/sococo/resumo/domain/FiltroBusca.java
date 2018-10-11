package br.com.sococo.resumo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class FiltroBusca {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;

    private String mesLancamento;

    private String anoLancamento;

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
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
    public String toString() {
        return "FiltroBusca{" +
            "dataLancamento=" + dataLancamento +
            ", mesLancamento='" + mesLancamento + '\'' +
            ", anoLancamento='" + anoLancamento + '\'' +
            '}';
    }
}
