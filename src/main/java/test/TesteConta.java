package test;

import entity.Conta;
import jakarta.persistence.EntityManager;
import util.JPAUtil;

public class TesteConta {

    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setId(1);
        conta.setTitular("Danilo");
        conta.setAgencia("123");
        conta.setBanco("Citibank");
        conta.setNumero("456");

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        conta = em.find(Conta.class, 1);
        em.remove(conta);

        conta.setBanco("Bradesco");

        em.getTransaction().commit();

        em.close();
        JPAUtil.close();
    }
}
