package br.com.sococo.resumo.repository;

import br.com.sococo.resumo.domain.ResumoDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface DashboardMesRepository extends JpaRepository<ResumoDiario, Long> {
    @Transactional
    @Query("select rd.mesLancamento, sum(rd.cocosProcessados) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findCocoProcessadoAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.cocosDesfibrados) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findCocoDesfribadosoAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.cocosProcessados), sum(rd.cocosDesfibrados) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findCocoAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.cri) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findCriAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.flococo) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findFlococoAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.cri), sum(rd.flococo) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findCRIFlococoAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.oleoIndustrialTipoA) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findOleoTipoAAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.oleoIndustrialETE) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findOleoETEAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.oleoIndustrialTipoA), sum(rd.oleoIndustrialETE) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findOleoAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.torta) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findTortaAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.aguaDeCocoSococo) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findAguaCocoAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.aguaDeCocoVerde) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findAguaVerdeAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.aguaDeCocoSococo), sum(rd.aguaDeCocoVerde) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findAguaCocosAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, avg(rd.porcentagemCocoGerminado) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findPercentGerminadoAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.totalDeCacambas) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findTotalCacambasAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.caixaPadrao) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findCaixaPadraoAno(String ano);

    @Transactional
    @Query("select rd.mesLancamento, sum(rd.numeroDeFardos) FROM ResumoDiario rd WHERE rd.anoLancamento = ?1 GROUP BY rd.mesLancamento")
    List<Object[]> findNumFardosAno(String ano);

}
