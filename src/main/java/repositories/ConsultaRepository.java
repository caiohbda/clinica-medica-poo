package repositories;

import models.Consulta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ConsultaRepository {

    private final EntityManager em;

    public ConsultaRepository(EntityManager em) {
        this.em = em;
    }

    public void salvar(Consulta consulta) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(consulta);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public List<Consulta> listarConsultas() {
        String jpql = "SELECT c FROM Consulta c";
        TypedQuery<Consulta> query = em.createQuery(jpql, Consulta.class);
        return query.getResultList();
    }

    public void remover(int id) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Consulta consulta = em.find(Consulta.class, id);
            if (consulta != null) {
                em.remove(consulta);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void atualizar(Consulta consulta) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.merge(consulta);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
