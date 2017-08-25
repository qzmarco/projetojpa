package test;

import entity.Conta;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class TesteBuscaConta {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();

        Conta conta = entityManager.find(Conta.class, 1);
        conta.setTitular("João");
        conta.setAgencia("999");

        System.out.println(conta.getTitular());

        entityManager.persist(conta);
        entityManager.getTransaction().commit();
        entityManager.close();

        EntityManager entityManager2 = JPAUtil.getEntityManager();
        entityManager2.getTransaction().begin();
        
        conta.setTitular("Leonardo");
        entityManager2.merge(conta);
        
        entityManager2.getTransaction().commit();
        entityManager2.close();
    }
}
