package test;

import entity.Cliente;
import entity.Conta;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class TesteContaCliente {

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Leonardo");
        cliente.setEndereco("RUA TESTE, 123");
        cliente.setProfissao("Professor");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Douglas");
        cliente2.setEndereco("RUA TESTE, 123");
        cliente2.setProfissao("Professor");

        Conta conta = new Conta();
        conta.setId(2);

        cliente.setConta(conta);
        cliente2.setConta(conta);

        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        em.persist(cliente);
//        em.persist(cliente2);

        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }
}
