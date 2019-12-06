package metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.entites.Livre;

public class GestionImpl implements IGestion{
	EntityManager em ; 
	public GestionImpl() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ali");
		em=factory.createEntityManager();
	}

	public void addLivre(Livre p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	public List<Livre> getAllLivre() {
		em.getTransaction().begin();
		Query q = em.createQuery("select e from Livre e");
		List<Livre> l = q.getResultList();
		em.getTransaction().commit();
		return l;
	}
	public Livre getLivre(int id) {
		 	em.getTransaction().begin();
			Query q = em.createQuery("select e from Livre e where e.id = :idd");
			q.setParameter("idd", id).getSingleResult();
			//q.setParameter(1, id);
			Livre l = (Livre)q.getSingleResult();
			em.getTransaction().commit();
			return l;
		 
	 }
	public void updateLivre(Livre l) {
		em.getTransaction().begin();
		em.persist(l);
		em.getTransaction().commit();
		
	}
	public void deleteLivre(Livre l) {
		em.getTransaction().begin();
		em.remove(l);
		em.getTransaction().commit();
		
	}
}
