package test;

import entity.Conta;
import entity.TipoMovimentacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import util.JPAUtil;

import java.util.List;

public class TesteFuncoesJpql {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Conta conta = new Conta();
        conta.setId(2);

        TypedQuery<Double> typedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);
        typedQuery.setParameter("pConta", conta);
        typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
        
        List<Double> medias = typedQuery.getResultList();
        
        System.out.println("A media 0 é: " + medias.get(0));
        System.out.println("A media 1 é: " + medias.get(1));

        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }
}
