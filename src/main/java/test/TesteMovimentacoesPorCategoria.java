package test;

import entity.Categoria;
import entity.Movimentacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

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

        resultados.stream().forEach((m) -> {
            System.out.println("Descrição " + m.getDescricao());
            System.out.println("Conta.id " + m.getConta().getId());
        });

        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }
}
