package br.com.sococo.resumo.repository;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface DashboardDiaRepository extends JpaRepository<ResumoDiario, Long> {

    @Transactional
    @Query("select rd.diaLancamento, sum(rd.cocosProcessados), sum(rd.cocosDesfibrados) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.diaLancamento order by rd.diaLancamento")
    List<Object[]> findCocos(String mes, String ano);

    @Transactional
    @Query("select rd.diaLancamento, sum(rd.cri), sum(rd.flococo) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.diaLancamento order by rd.diaLancamento")
    List<Object[]> findCriFlococoDia(String mes, String ano);

    @Transactional
    @Query("select rd.diaLancamento, sum(rd.oleoIndustrialTipoA), sum(rd.oleoIndustrialETE) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.diaLancamento order by rd.diaLancamento")
    List<Object[]> findOleosDia(String mes, String ano);

    @Transactional
    @Query("select rd.diaLancamento, sum(rd.torta) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.diaLancamento order by rd.diaLancamento")
    List<Object[]> findTortaDia(String mes, String ano);

    @Transactional
    @Query("select rd.diaLancamento, sum(rd.aguaDeCocoSococo), sum(rd.aguaDeCocoVerde) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.diaLancamento order by rd.diaLancamento")
    List<Object[]> findAguasDia(String mes, String ano);

    @Transactional
    @Query("select rd.diaLancamento, avg(rd.porcentagemCocoGerminado) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.diaLancamento order by rd.diaLancamento")
    List<Object[]> findPercentGerminadoDia(String mes, String ano);

    @Transactional
    @Query("select rd.diaLancamento, sum(rd.totalDeCacambas) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.diaLancamento order by rd.diaLancamento")
    List<Object[]> findTotalCacambasDia(String mes, String ano);

    @Transactional
    @Query("select rd.diaLancamento, sum(rd.caixaPadrao) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.diaLancamento order by rd.diaLancamento")
    List<Object[]> findCaixaPadraoDia(String mes, String ano);

    @Transactional
    @Query("select rd.diaLancamento, sum(rd.numeroDeFardos) from ResumoDiario rd where rd.mesLancamento = ?1 AND rd.anoLancamento = ?2 group by rd.diaLancamento order by rd.diaLancamento")
    List<Object[]> findNumFardosDia(String mes, String ano);

}
