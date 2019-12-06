package metier;

import java.util.List;

import metier.entites.Livre;

public interface IGestion {
	public Livre getLivre(int id); 
	public List<Livre> getAllLivre();
	public void addLivre(Livre l);
	public void updateLivre(Livre l); 
	public void deleteLivre(Livre l);

}
