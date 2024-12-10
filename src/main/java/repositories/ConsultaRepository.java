package repositories;

import models.Consulta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ConsultaRepository {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clinicamedica");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Consulta consulta) {
        entityManager.getTransaction().begin();
        entityManager.persist(consulta);
        entityManager.getTransaction().commit();
    }

    public void update(Consulta consulta) {
        entityManager.getTransaction().begin();
        entityManager.merge(consulta);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        Consulta consulta = findById(id);
        if (consulta != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(consulta);
            entityManager.getTransaction().commit();
        }
    }

    public Consulta findById(int id) {
        return entityManager.find(Consulta.class, id);
    }

    public List<Consulta> findAll() {
        String jpql = "SELECT c FROM Consulta c";
        TypedQuery<Consulta> query = entityManager.createQuery(jpql, Consulta.class);
        return query.getResultList();
    }
}
