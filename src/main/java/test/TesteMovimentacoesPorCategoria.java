package test;

import entity.Categoria;
import entity.Movimentacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import util.JPAUtil;

import java.util.List;

public class TesteMovimentacoesPorCategoria {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Categoria categoria = new Categoria();
        categoria.setId(9);

        String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
        Query query = em.createQuery(jpql);
        query.setParameter("pCategoria", categoria);

        List<Movimentacao> resultados = query.getResultList();

        resultados.forEach((m) -> {
            System.out.println("Descrição " + m.getDescricao());
            System.out.println("Conta.id " + m.getConta().getId());
        });

        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }
}
