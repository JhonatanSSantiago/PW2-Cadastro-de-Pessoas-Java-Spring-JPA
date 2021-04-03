package com.jhssantiago.pessoa.dao;

import com.jhssantiago.pessoa.model.PessoaFisica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jhons
 */
@Repository
public class PessoaFisicaRepository {
    
    @PersistenceContext
    private EntityManager em;

    public void save(PessoaFisica pessoaFisica) {
        em.persist(pessoaFisica);
    }

    public PessoaFisica pessoaFisica(int id) {
        return em.find(PessoaFisica.class, id);
    }

    public List<PessoaFisica> pessoaFisica() {
        Query query = em.createQuery("from PessoaFisica");
        return query.getResultList();
    }

    public void remove(int id) {
        PessoaFisica pf = em.find(PessoaFisica.class, id);
        em.remove(pf);
    }

    public void update(PessoaFisica pessoaFisica) {
        em.merge(pessoaFisica);
    }
}
