package ec.edu.ups.EXAMENFINAL.dao;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.EXAMENFINAL.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;


@Stateless
public class RecargaDao implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void insert(Recarga recarga) {
        try {
            em.persist(recarga);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Recarga recarga) {
        try {
            em.merge(recarga);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        try {
            Recarga recarga = em.find(Recarga.class, id);
            if (recarga != null) {
                em.remove(recarga);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Recarga read(int id) {
        try {
            return em.find(Recarga.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Recarga> getAll() {
        try {
            String jpql = "SELECT r FROM Recarga r";
            TypedQuery<Recarga> query = em.createQuery(jpql, Recarga.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
