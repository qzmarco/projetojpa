package test;

import entity.Conta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import util.JPAUtil;

import java.util.List;

public class TesteTodasAsMovimentacoesDasContas {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
        Query query = em.createQuery(jpql);
        
        List<Conta> todasAsContas = query.getResultList();
        
        todasAsContas.forEach((conta) -> {
            System.out.println("Titular " + conta.getTitular());
            System.out.println("Movimentações " );
            System.out.println(conta.getMovimentacoes());
        });
        em.close();
        JPAUtil.close();
    }
}
