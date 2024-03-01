package test;

import entity.Conta;
import entity.Movimentacao;
import entity.TipoMovimentacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import util.JPAUtil;

import java.util.List;

public class TesteJpql {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        
        Conta conta = new Conta();
        conta.setId(2);
        
        String jpql = "select m from Movimentacao m where m.conta = :pConta and m.tipo = :pTipo order by m.valor desc";
        Query query = em.createQuery(jpql);
        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
        
        List<Movimentacao> resultados = query.getResultList();
        
        resultados.stream().forEach((m) -> {
            System.out.println("Descrição " + m.getDescricao());
            System.out.println("Conta.id " + m.getConta().getId());
        });

        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }
}
