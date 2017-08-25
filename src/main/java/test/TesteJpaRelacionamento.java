package test;

import entity.Conta;
import entity.Movimentacao;
import entity.TipoMovimentacao;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import util.JPAUtil;

public class TesteJpaRelacionamento {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        Conta conta = new Conta();
        conta.setAgencia("0102");
        conta.setBanco("Itaú");
        conta.setNumero("1234");
        conta.setTitular("Leonardo");
        
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(LocalDateTime.now());
        movimentacao.setDescricao("Churrascaria");
        movimentacao.setTipo(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("200.0"));
        movimentacao.setConta(conta);

        em.getTransaction().begin();
        
        em.persist(conta);
        em.persist(movimentacao);
        
        
        em.getTransaction().commit();
        em.close();
        JPAUtil.close();
    }

}
