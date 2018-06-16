/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.ceavi.progii.control.jpacontroller;

import br.udesc.ceavi.progii.control.jpacontroller.exceptions.NonexistentEntityException;
import br.udesc.ceavi.progii.control.jpacontroller.exceptions.PreexistingEntityException;
import br.udesc.ceavi.progii.models.Filial;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Eduardo Woloszyn
 */
public class FilialJpaController implements Serializable {

    public FilialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Filial filial) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(filial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFilial(filial.getCnpj()) != null) {
                throw new PreexistingEntityException("Filial " + filial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Filial filial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            filial = em.merge(filial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = filial.getCnpj();
                if (findFilial(id) == null) {
                    throw new NonexistentEntityException("The filial with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Filial filial;
            try {
                filial = em.getReference(Filial.class, id);
                filial.getCnpj();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The filial with id " + id + " no longer exists.", enfe);
            }
            em.remove(filial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Filial> findFilialEntities() {
        return findFilialEntities(true, -1, -1);
    }

    public List<Filial> findFilialEntities(int maxResults, int firstResult) {
        return findFilialEntities(false, maxResults, firstResult);
    }

    private List<Filial> findFilialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Filial.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Filial findFilial(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Filial.class, id);
        } finally {
            em.close();
        }
    }

    public int getFilialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Filial> rt = cq.from(Filial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
