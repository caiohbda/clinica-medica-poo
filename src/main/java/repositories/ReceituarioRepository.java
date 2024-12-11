package repositories;

import models.Receituario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class ReceituarioRepository {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("clinicamedica");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();


    public void save(Receituario receituario) {
        entityManager.getTransaction().begin();
        entityManager.persist(receituario);
        entityManager.getTransaction().commit();
    }

    public void update(Receituario receituario) {
        entityManager.getTransaction().begin();
        entityManager.merge(receituario);
        entityManager.getTransaction().commit();
    }

    public void delete(int id) {
        Receituario receituario = findById(id);
        if (receituario != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(receituario);
            entityManager.getTransaction().commit();
        }
    }

    public Receituario findById(int id) {
        return entityManager.find(Receituario.class, id);
    }

    public List<Receituario> findAll() {
        String jpql = "select r from Receituario r";
        TypedQuery<Receituario> query = entityManager.createQuery(jpql, Receituario.class);
        return query.getResultList();
    }
}
