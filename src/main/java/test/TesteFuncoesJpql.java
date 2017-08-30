package test;

import entity.Conta;
import entity.TipoMovimentacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.JPAUtil;

public class TesteFuncoesJpql {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        String jpql = "select avg(m.valor) as media from Movimentacao m where m.conta = :pConta "
                + "and m.tipo = :pTipo "
                + "group by m.data";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Double> medias = query.getResultList();
        
        System.out.println("A media 0 é: " + medias.get(0));
        System.out.println("A media 1 é: " + medias.get(1));

        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }
}
