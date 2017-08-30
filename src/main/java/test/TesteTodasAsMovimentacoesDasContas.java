package test;

import entity.Conta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
        Query query = em.createQuery(jpql);
        
        List<Conta> todasAsContas = query.getResultList();
        
        todasAsContas.stream().forEach((conta) -> {
            System.out.println("Titular " + conta.getTitular());
            System.out.println("Movimentações " );
            System.out.println(conta.getMovimentacoes());
        });
        em.close();
        JPAUtil.close();
    }
}
