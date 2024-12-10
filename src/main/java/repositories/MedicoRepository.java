package repositories;

import models.Medico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class MedicoRepository {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clinicamedica");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Medico medico) {
        entityManager.getTransaction().begin();
        entityManager.persist(medico);
        entityManager.getTransaction().commit();
    }

    public void update(Medico medico) {
        entityManager.getTransaction().begin();
        entityManager.merge(medico);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        Medico medico = findById(id);
        if (medico != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(medico);
            entityManager.getTransaction().commit();
        }
    }

    public Medico findById(int id) {
        return entityManager.find(Medico.class, id);
    }

    public List<Medico> findAll() {
        String jpql = "select m from Medico m";
        TypedQuery<Medico> query = entityManager.createQuery(jpql, Medico.class);
        return query.getResultList();
    }
}
