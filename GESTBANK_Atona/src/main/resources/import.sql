INSERT INTO utilisateur(UTILISATEUR_TYPE, pseudo,  mdp) VALUES ('Administrateur','admin','admin');
----
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, mle) VALUES ('Conseiller', 'Michel', 'Jeanne', 'JMichel', 'JMichel', 'jmichel@gest-bank.ky', null, null, null, null, null, 1);
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, mle) VALUES ('Conseiller', 'Rober', 'Frank', 'FRober', 'FRober', 'frober@gest-bank.ky', null, null, null, null, null, 2);
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, mle) VALUES ('Conseiller', 'Durant', 'Jacques', 'JDurant', 'JDurant', 'jdurant@gest-bank.ky', null, null, null, null, null, 3);
----
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, identifiant, revenuMens, conseiller_pseudo) VALUES ('Client', 'Davis', 'Mark', 'MDavis', 'MDavis', 'mark.davis@b-mail.ky', null, null, null, null, null, 1, NULL, 'JMichel');
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, identifiant, revenuMens, conseiller_pseudo) VALUES ('Client', 'Davis', 'Helen', 'HDavis', 'HDavis', 'helen.davis@b-mail.ky', null, null, null, null, null, 2, NULL, 'FRober');
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, identifiant, revenuMens, conseiller_pseudo) VALUES ('Client', 'Damon', 'Barn', 'BDamon', 'BDamon', 'barn.damon@b-mail.ky', null, null, null, null, null, 3, NULL, 'FRober');
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, identifiant, revenuMens, conseiller_pseudo) VALUES ('Client', 'Thomas', 'William', 'WThomas', 'WThomas', 'will.thoms@a-mail.ky', null, null, null, null, null, 4, NULL, 'JDurant');
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, identifiant, revenuMens, conseiller_pseudo) VALUES ('Client', 'Wong', 'Mickael', 'MWong', 'MWong', 'mickael.wong2@c-mail.ky', null, null, null, null, null, 5, NULL, 'JMichel');
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, identifiant, revenuMens, conseiller_pseudo) VALUES ('Client', 'Davis', 'Chris', 'CDavis', 'CDavis', 'chris.davis@y-mail.ky', null, null, null, null, null, 6, NULL, 'JMichel');
INSERT INTO utilisateur(UTILISATEUR_TYPE, nom, prenom, pseudo, mdp, email, adresse, codePostal, ville, telephone, dateNaissance, identifiant, revenuMens, conseiller_pseudo) VALUES ('Client', 'Gibbs', 'Anthony', 'AGibbs', 'AGibbs', 'antonio.gibbs@n-mail.ky', null, null, null, null, null, 7, NULL, 'JDurant');

INSERT INTO clientpotentiel (pseudo, adresse, codePostal, dateNaissance, email, nom, prenom, revenuMens, telephone, ville) VALUES ('LMichel', NULL, NULL, '1978-04-19', 'louise.michel@gmail.com', 'Michel', 'Louise', NULL, NULL, NULL);
INSERT INTO clientpotentiel (pseudo, adresse, codePostal, dateNaissance, email, nom, prenom, revenuMens, telephone, ville) VALUES ('RTripoux', NULL, NULL, '1978-08-29', 'robert.tripoux@gmail.com', 'Tripoux', 'Robert', NULL, NULL, NULL);
INSERT INTO clientpotentiel (pseudo, adresse, codePostal, dateNaissance, email, nom, prenom, revenuMens, telephone, ville) VALUES ('MPatullacci', NULL, NULL, '1968-07-10', 'marcel.patullacci@gmail.com', 'Patullacci', 'Marcel', NULL, NULL, NULL);
INSERT INTO clientpotentiel (pseudo, adresse, codePostal, dateNaissance, email, nom, prenom, revenuMens, telephone, ville) VALUES ('RSucco', NULL, NULL, '1982-02-09', 'roberto.suuco@gmail.com', 'Succo', 'Roberto', NULL, NULL, NULL);


INSERT INTO demandeouverture (numDemande, dateAffectation, dateCreation, cp_pseudo, status) VALUES ('1', NULL, '2016-10-11', 'LMichel', false);
INSERT INTO demandeouverture (numDemande, dateAffectation, dateCreation, cp_pseudo, status) VALUES ('2', NULL, '2015-08-21', 'RTripoux', false);
INSERT INTO demandeouverture (numDemande, dateAffectation, dateCreation, cp_pseudo, status) VALUES ('3', NULL, '2016-09-14', 'MPatullacci', false);
INSERT INTO demandeouverture (numDemande, dateAffectation, dateCreation, cp_pseudo, status) VALUES ('4', NULL, '2016-08-02', 'RSucco', false);

INSERT INTO compte (noComtpe, RIB, decouvert, montantAgios, montanRemuneration, seuilRemuneration, solde) VALUES ('5648978', NULL, NULL, NULL, NULL, NULL, '1500');
INSERT INTO compte (noComtpe, RIB, decouvert, montantAgios, montanRemuneration, seuilRemuneration, solde) VALUES ('5467893', NULL, NULL, NULL, NULL, NULL, '32000');
INSERT INTO compte (noComtpe, RIB, decouvert, montantAgios, montanRemuneration, seuilRemuneration, solde) VALUES ('2457896', NULL, NULL, NULL, NULL, NULL, '300');
INSERT INTO compte (noComtpe, RIB, decouvert, montantAgios, montanRemuneration, seuilRemuneration, solde) VALUES ('2354789', NULL, NULL, NULL, NULL, NULL, '18000');

INSERT INTO utilisateur_compte (utilisateur_pseudo, listeComptes_noComtpe) VALUES ('HDavis', '2457896');
INSERT INTO utilisateur_compte (utilisateur_pseudo, listeComptes_noComtpe) VALUES ('HDavis', '2354789');

INSERT INTO transaction (noTransaction, dateTransaction, libelle, montant, typeTransaction) VALUES ('2', '2016-09-10', NULL, '20','debit');
INSERT INTO transaction (noTransaction, dateTransaction, libelle, montant, typeTransaction) VALUES ('3', '2016-08-10', NULL, '220','credit');
INSERT INTO transaction (noTransaction, dateTransaction, libelle, montant, typeTransaction) VALUES ('4', '2016-10-10', NULL, '20','debit');
INSERT INTO transaction (noTransaction, dateTransaction, libelle, montant, typeTransaction) VALUES ('5', '2016-09-10', NULL, '40','debit');
INSERT INTO transaction (noTransaction, dateTransaction, libelle, montant, typeTransaction) VALUES ('6', '2016-08-10', NULL, '1220','credit');
INSERT INTO transaction (noTransaction, dateTransaction, libelle, montant, typeTransaction) VALUES ('7', '2016-10-10', NULL, '550','debit');

