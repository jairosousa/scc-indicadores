package br.com.sococo.resumo.repository;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


/**
 * Spring Data  repository for the ResumoDiario entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ResumoDiarioRepository extends JpaRepository<ResumoDiario, Long> {

    @Transactional
    @Query("select new ResumoDiario(rd.dataLancamento, sum(rd.cocosProcessados),sum(rd.cocosDesfibrados), sum(rd.cri), sum(rd.flococo), sum(rd.oleoIndustrialTipoA), sum(rd.oleoIndustrialETE), sum(rd.torta),sum(rd.aguaDeCocoSococo), sum(rd.aguaDeCocoVerde),  sum(rd.caixaPadrao), avg (rd.porcentagemCocoGerminado), sum(rd.totalDeCacambas), sum(rd.numeroDeFardos)) from ResumoDiario rd where rd.dataLancamento = ?1 group by rd.dataLancamento order by rd.dataLancamento")
    List<ResumoDiario> findByDataLancamento(LocalDate data);

    @Transactional
    @Query("select new ResumoDiario(sum(rd.cocosProcessados),sum(rd.cocosDesfibrados), sum(rd.cri), sum(rd.flococo), sum(rd.oleoIndustrialTipoA), sum(rd.oleoIndustrialETE), sum(rd.torta),sum(rd.aguaDeCocoSococo), sum(rd.aguaDeCocoVerde),  sum(rd.caixaPadrao), avg (rd.porcentagemCocoGerminado), sum(rd.totalDeCacambas), sum(rd.numeroDeFardos)) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.mesLancamento order by rd.mesLancamento")
    List<ResumoDiario> findByMesLancamento(String mesLancamento, String anoLancamento);

    // Resumo diário por SEMANA - Recebe como parametro uma data e recupera todos os dias daquela semana.
    @Transactional
    @Query(value = "select SUM(rd.cocos_processados), SUM(rd.cocos_desfibrados), SUM(rd.cri), SUM(rd.flococo), SUM(rd.oleo_industrial_tipo_a), SUM(rd.oleo_industrial_ete), SUM(rd.torta), SUM(rd.agua_coco_sococo), SUM(rd.agua_coco_verde), SUM(rd.caixa_padrao),  AVG(rd.porcentagem_coco_germinado),  SUM(rd.total_cacambas),  SUM(rd.numero_fardos) from resumo_diario rd where weekofyear(:dataSemana) = weekofyear(rd.data_lancamento)", nativeQuery = true)
    List<Object[]> findByDiasDaSemana(@Param("dataSemana") LocalDate dataSemana);


    // Pegar o maior dia de lançamento, ou seja, o ultimo dia que teve lançamento
    @Transactional
    @Query(value = "SELECT * FROM resumo_diario rd WHERE rd.data_lancamento = (SELECT MAX(data_lancamento) FROM resumo_diario);", nativeQuery = true)
    List<ResumoDiario> findResumoDoDia();

}
