package repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import models.Paciente;

import java.util.List;

public class PacienteRepository {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clinicamedica");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Paciente paciente) {
        entityManager.getTransaction().begin();
        if (paciente.getId() == 0) {
            entityManager.persist(paciente);
        } else {
            entityManager.merge(paciente);
        }
        entityManager.getTransaction().commit();
    }

    public void remove(Paciente paciente) {
        entityManager.getTransaction().begin();
        entityManager.remove(paciente);
        entityManager.getTransaction().commit();
    }

    public Paciente findById(int id) {
        return entityManager.find(Paciente.class, id);
    }

    public List<Paciente> findAll() {
        String jpql = "select p from Paciente p";
        TypedQuery<Paciente> typedQuery = entityManager.createQuery(jpql, Paciente.class);
        return typedQuery.getResultList();
    }
}
