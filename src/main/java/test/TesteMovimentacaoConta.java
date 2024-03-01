package test;

import entity.Conta;
import entity.Movimentacao;
import jakarta.persistence.EntityManager;
import util.JPAUtil;

public class TesteMovimentacaoConta {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        
        Movimentacao movimentacao = em.find(Movimentacao.class, 16);
        Conta conta = movimentacao.getConta();
        
        System.out.println(conta.getTitular());
        
        System.out.println(conta.getMovimentacoes().size());

        em.close();
        JPAUtil.close();
    }
}
