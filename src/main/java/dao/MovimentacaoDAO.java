package dao;

import entity.Conta;
import entity.TipoMovimentacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MovimentacaoDAO {

    private EntityManager em;

    public MovimentacaoDAO(EntityManager em) {
        this.em = em;
    }

    public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {
        String jpql = "select avg(m.valor) as media from Movimentacao m where m.conta = :pConta "
                + "and m.tipo = :pTipo "
                + "group by m.data";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        return query.getResultList();
    }
}
