package com.wha.springmvc.dao;

import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.stereotype.Repository;

import com.wha.springmvc.dao.AbstractDAO;
import com.wha.springmvc.dao.UtilisateurDAO;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.DemandeOuverture;
import com.wha.springmvc.model.Utilisateur;

	@Repository("UtilisateurDao")
	public class UtilisateurDAOImpl extends AbstractDAO<Long, Utilisateur> implements UtilisateurDAO {

//---------------ClientDAO------------------------------------
		@Override
		public Client findById(Long identifiant) {
			Client client=(Client) getByKey(identifiant);
			return client;
		}

		public List<Client> findAllClients() {
			List<Client> clients=getEntityManager().createQuery("SELECT u FROM utilisateur u WHERE utilisateur_type='client'").getResultList();
			return clients;
		}

		@Override
		public List<Client> findAllClients(Long mle) {
			List<Client> clients=getEntityManager().createQuery("SELECT u.listeClients FROM utilisateur u WHERE utilisateur_type='client' and matricule='mle'").getResultList();
			return clients;
		}
		
		@Override
		public void saveClient(Client client) {
			persist (client);
		}

		@Override
		public void updateClient(Client client) {
			update(client);			
		}

		@Override
		public boolean isClientExist(Client client) {
			for (Client c : findAllClients()) {
				if (c.equals(client))
					return true;
			}
			return false;
		}

//---------------ConseillerDAO------------------------------------

		@Override
		public Conseiller findByMle(Long matricule) {
			Conseiller conseiller=(Conseiller) getByKey(matricule);
			return conseiller;
		}

		@Override
		public void saveConseiller(Conseiller conseiller) {
			persist (conseiller);
		}

		@Override
		public void updateConseiller(Conseiller conseiller) {
			update(conseiller);
		}

		@Override
		public List<Conseiller> findAllConseillers() {
			List<Conseiller> Conseillers=getEntityManager().createQuery("SELECT u FROM utilisateur u where utilisateur_type='conseiller' ORDER BY c.name ASC").getResultList();
			return Conseillers;
		}
		
		@Override
		public boolean isConseillerExist(Conseiller conseiller) {
			for (Conseiller c : findAllConseillers()) {
				if (c.equals(conseiller))
					return true;
			}
			return false;
		}
		
//---------------UtilisateurDAO------------------------------------

		@Override
		public List<Utilisateur> findAllUtilisateurs() {
			List<Utilisateur> Utilisateurs=getEntityManager().createQuery("SELECT u FROM utilisateur u ORDER BY u.utilisateur_type ASC").getResultList();
			return Utilisateurs;
		}

		public boolean isUtilisateurExist(Utilisateur utilisateur) {
			for (Utilisateur u : findAllUtilisateurs()) {
				if (u.equals(utilisateur))
					return true;
			}
			return false;
		}
		
		@Override
		public boolean isPseudoExist(String pseudo) {
			for (Utilisateur u : findAllUtilisateurs()) {
				if (u.getPseudo().equals(pseudo))
					return true;
			}
			return false;
		}

		@Override
		public Utilisateur getUtilisateurByPseudo(String pseudo) {
			System.out.println("pseudo: "+pseudo);
			try{
				Utilisateur utilisateur=(Utilisateur) getEntityManager().createQuery("SELECT u FROM Utilisateur u WHERE u.pseudo='peudo'").
						setParameter("pseudo",pseudo).getSingleResult();
				return utilisateur;
			}
			catch(NoResultException ex){
				return null;
			}
		}

//---------------Demandes------------------------------------
		
		@Override
		public List<DemandeOuverture> findAllDemandes() {
			List<DemandeOuverture> demandeOuverture=getEntityManager().createQuery("SELECT do FROM demandeouverture do ORDER BY do.dateCreation ASC").getResultList();
			return demandeOuverture;
		}

		@Override
		public List<DemandeOuverture> findDemandeByConseiller(Long matricule) {
			List<DemandeOuverture> DemandeOuvertures=getEntityManager().createQuery("SELECT do FROM demandeouverture do WHERE utilisateur_type='conseiller' and matricule='mle'").getResultList();
			return DemandeOuvertures;
		}

		@Override
		public void saveDemande(DemandeOuverture demandeOuverture) {
			entityManager.persist(demandeOuverture);
		}

		@Override
		public void affectationOuverture(DemandeOuverture demandeOuverture, Conseiller conseiller) {
			saveDemande(demandeOuverture);
			findDemandeByConseiller(conseiller.getMatricule()).add(demandeOuverture);
		}

		@Override
		public boolean isDemandeExist(DemandeOuverture ouverture) {
			for (DemandeOuverture u : findAllDemandes()) {
				if (u.equals(ouverture))
					return true;
			}
			return false;
		}
}