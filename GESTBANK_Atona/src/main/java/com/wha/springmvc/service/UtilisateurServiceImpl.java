package com.wha.springmvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wha.springmvc.dao.UtilisateurDAO;
import com.wha.springmvc.dummy.DummyBDD;
import com.wha.springmvc.model.Client;
import com.wha.springmvc.model.ClientPotentiel;
import com.wha.springmvc.model.Compte;
import com.wha.springmvc.model.Conseiller;
import com.wha.springmvc.model.DemandeOuverture;
import com.wha.springmvc.model.User;
import com.wha.springmvc.model.Utilisateur;

@Service("clientService")
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

	// #region Client
	/*private static List<Client> clients;
	private static void getClients() {
		if (clients == null) {
			DummyBDD.CreateBDD();
			clients = DummyBDD.getClients();
		}
	}
*/
	
	@Autowired
	private UtilisateurDAO dao;

	@Override
	public Client findById(Long identifiant) {
		/*getClients();
		for (Client client : clients) {
			if (client.getIdentifiant() == identifiant) {
				return client;
			}
		}
		return null;*/
		return dao.findById(identifiant);
	}
/*
	@Override
	public Client findByCompte(Long noCompte) {
		getClients();
		for (Client client : clients) {
			for (Compte compte : client.getListeComptes()) {
				if (compte.getNoCompte() == noCompte) {
					return client;
				}
			}
		}
		return null;
	}
*/
	@Override
	public void saveClient(Client client) {
		/*getClients();
		DummyBDD.ajoutClient(client);
		clients = DummyBDD.getClients();*/
		dao.saveClient(client);
	}

	@Override
	public void updateClient(Client client) {
		/*getClients();
		int index = clients.indexOf(client);
		clients.set(index, client);
		DummyBDD.setClients(clients);
*/
		Client entity=dao.findById((Long)client.getIdentifiant());
		if(entity!=null){
			entity.setNom(client.getNom());
			entity.setPrenom(client.getPrenom());
			entity.setPseudo(client.getPseudo());
			entity.setMotdepasse(client.getMotdepasse());
			entity.setEmail(client.getEmail());
			entity.setAdresse(client.getAdresse());
			entity.setCodePostal(client.getCodePostal());
			entity.setVille(client.getVille());
			entity.setTelephone(client.getTelephone());
			entity.setDateNaissance(client.getDateNaissance());
		}
		dao.saveClient(entity);
	}

	@Override
	public List<Client> findAllClients(Long IdentConseiller) {
		/*getClients();
		List<Client> lClients = new ArrayList<Client>();
		for (Client client : clients) {
			if (client.getConseiller().getMatricule() == IdentConseiller) {
				lClients.add(client);
			}
		}
		return lClients;*/
		return dao.findAllClients(IdentConseiller);
	}

	@Override
	public boolean isClientExist(Client client) {
		/*getClients();
		for (Client c : clients) {
			if (c.equals(client)) {
				return true;
			}
		}
		return false;*/
		return dao.isClientExist(client);
	}

	// #endregion

	// #region Conseiller

	/*private static List<Conseiller> conseillers;

	private static void getConseillers() {
		if (conseillers == null) {
			DummyBDD.CreateBDD();
			conseillers = DummyBDD.getConseillers();
		}
	}
*/
	@Override
	public Conseiller findByMle(Long matricule) {
		/*getConseillers();
		for (Conseiller c : conseillers) {
			if(c.getMatricule()==matricule)
				return c;
		}
		return null;*/
		return dao.findByMle(matricule);
	}

	@Override
	public void saveConseiller(Conseiller conseiller) {
		/*getConseillers();
		DummyBDD.ajoutConseiller(conseiller);
		conseillers= DummyBDD.getConseillers();*/
		dao.saveConseiller(conseiller);
	}

	@Override
	public void updateConseiller(Conseiller conseiller) {
		/*getConseillers();
		int index = conseillers.indexOf(conseiller);
		conseillers.set(index, conseiller);
		DummyBDD.setConseillers(conseillers);*/
		Conseiller entity=dao.findByMle((Long)conseiller.getMatricule());
		if(entity!=null){
			entity.setNom(conseiller.getNom());
			entity.setPrenom(conseiller.getPrenom());
			entity.setPseudo(conseiller.getPseudo());
			entity.setMotdepasse(conseiller.getMotdepasse());
			entity.setEmail(conseiller.getEmail());
			entity.setAdresse(conseiller.getAdresse());
			entity.setCodePostal(conseiller.getCodePostal());
			entity.setVille(conseiller.getVille());
			entity.setTelephone(conseiller.getTelephone());
			entity.setDateNaissance(conseiller.getDateNaissance());
		}
		dao.saveConseiller(entity);
	}

	@Override
	public List<Conseiller> findAllConseillers() {
		/*getConseillers();
		return conseillers;*/
		return dao.findAllConseillers();
	}

	@Override
	public boolean isConseillerExist(Conseiller conseiller) {
		/*getConseillers();
		for (Conseiller c : conseillers) {
			if (c==conseiller) return true;
		}
		return false;*/
		return dao.isConseillerExist(conseiller);
	}

	// #endregion

	// #region Utilisateur
/*
	private static List<Utilisateur> utilisateurs;

	private static void getUtilisateurs() {
		if (utilisateurs == null) {
			DummyBDD.CreateBDD();
			utilisateurs = DummyBDD.getUtilisateurs();
		}
	}*/

	@Override
	public boolean isPseudoExist(String pseudo) {
		/*getUtilisateurs();
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getPseudo().equals(pseudo)) {
				return true;
			}
		}
		return false;*/
		return dao.isPseudoExist(pseudo);
	}

	@Override
	public Utilisateur getUtilisateurByPseudo(String pseudo) {
		/*getUtilisateurs();
		for (Utilisateur utilisateur : utilisateurs) {
			if (utilisateur.getPseudo().equals(pseudo)) {
				return utilisateur;
			}
		}
		return null;*/
		return dao.getUtilisateurByPseudo(pseudo);
	}
	// #endregion

	//#region Demandes
	
	/*private static List<DemandeOuverture> demandes;

	private static void getDemandes() {
		if (demandes == null) {
			DummyBDD.CreateBDD();
			demandes = DummyBDD.getDemandes();
		}
	}*/
	
	@Override
	public List<DemandeOuverture> findAllDemandes() {
		/*getDemandes();
		return demandes;*/
		return dao.findAllDemandes();
	}

	@Override
	public List<DemandeOuverture> findDemandeByConseiller(Long matricule) {
		/*getDemandes();
		List<DemandeOuverture> liste = new ArrayList<DemandeOuverture>();
		for (DemandeOuverture demande : demandes){
			if (demande.getConseiller()!=null && demande.getConseiller().getMatricule()==matricule){
				liste.add(demande);
			}
		}
		return liste;*/
		return dao.findDemandeByConseiller(matricule);
	}

	@Override
	public void saveDemande(DemandeOuverture demandeOuverture) {
		/*getDemandes();
		DummyBDD.ajoutDemande(demandeOuverture);*/
		dao.saveDemande(demandeOuverture);
	}

	@Override
	public void affectionOuverture(DemandeOuverture demandeOuverture, Long matricule) {
		/*getDemandes();
		int index = demandes.indexOf(demandeOuverture);
		demandes.get(index).setConseiller(conseiller);
		demandes.get(index).setDateAffectation(new Date());*/
		dao.affectationOuverture(demandeOuverture, matricule);
	}

	@Override
	public boolean isDemandeExist(DemandeOuverture ouverture) {
		/*getDemandes();
		for (DemandeOuverture demande : demandes){
			if (demande.equals(ouverture)) 
				return true;
		}
		return false;*/
		return dao.isDemandeExist(ouverture);
	}
	
	public DemandeOuverture getDemandeByNum(int numDemande){
		return dao.getDemandeByNum(numDemande);
	}
	//#endregion
	@Override
	public void validationDemande(DemandeOuverture demande) {
		//creation client
		ClientPotentiel cp = demande.getCp();
		Client client = new Client();
		client.setNom(cp.getNom());
		client.setPrenom(cp.getPrenom());
		client.setPseudo(cp.getPseudo());
		client.setMotdepasse(cp.getPseudo());
		client.setEmail(cp.getEmail());
		client.setAdresse(cp.getAdresse());
		client.setCodePostal(cp.getCodePostal());
		client.setVille(cp.getVille());
		client.setTelephone(cp.getTelephone());
		client.setDateNaissance(cp.getDateNaissance());
		Long max = dao.getMaxIdentifiant()+1L;
		client.setIdentifiant(max);
		//creation compte
		Compte cpt = new Compte();
		max = dao.getMaxNoCompte()+1L;
		cpt.setNoCompte(max);
		//ajout compte dans le client
		client.ajoutCompte(cpt);
		//ajout du client dans le conseiller
		Conseiller conseiller = dao.findByMle(demande.getConseiller().getMatricule());
		conseiller.getListeClients().add(client);
		dao.updateConseiller(conseiller);
		//modification de la demande pour la mettre à valider
		demande.setValide(true);
		dao.updateDemande(demande);
		
	}
}
