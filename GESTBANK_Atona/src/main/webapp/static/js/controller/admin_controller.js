'use strict';

App.controller('AdminController', [
		'$scope',
		'$location',
		function($scope, $location) {
			var self = this;
			self.conseiller = {
				mle : null,
				nom : '',
				prenom : '',
				address : '',
				email : ''
			};
			self.demande = {};
			self.conseillers = [];
			self.demandes = [];

			self.submit = submit;
			self.edit = edit;
			self.remove = remove;
			self.reset = reset;

			self.aServ = $scope.father.services.aServ;
			$scope.conseillers = self.conseillers;
			$scope.demandes = self.demandes;
			fetchAllConseillers();
			fetchAllDemandes();


			function fetchAllConseillers() {
				self.aServ.fetchAllConseillers().then(function(d) {
					self.conseillers = d;
					console.log(self.conseillers);
				}, function(errResponse) {
					console.error('Error while fetching Conseillers');
				});
			}

			function fetchConseillerByMle(matricule) {
				self.aServ.fetchConseillerByMle(matricule).then(function(d) {
					self.conseiller = d;
				}, function(errResponse) {
					console.error('Error while fetching Conseiller');
				});
			}

			function createConseiller(conseiller) {
				self.aServ.createConseiller(conseiller).then(
						fetchAllConseillers, function(errResponse) {
							console.error('Error while creating Conseiller');
						});
			}

			function updateConseiller(conseiller, mle) {
				self.aServ.updateConseiller(Conseiller, mle).then(
						fetchAllConseillers, function(errResponse) {
							console.error('Error while updating Conseiller');
						});
			}

			function deleteConseiller(mle) {
				self.aServ.deleteConseiller(mle).then(fetchAllConseillers,
						function(errResponse) {
							console.error('Error while deleting Conseiller');
						});
			}

			function submit() {
				if (self.conseiller.mle === null) {
					console.log('Saving New Conseiller', self.conseiller);
					createConseiller(self.conseiller);
				} else {
					updateConseiller(self.conseiller, self.conseiller.mle);
					console.log('Conseiller updated with mle ',
							self.conseiller.mle);
				}
				reset();
			}

			function edit(mle) {
				console.log('mle to be edited', mle);
				for (var i = 0; i < self.conseillers.length; i++) {
					if (self.conseillers[i].id === id) {
						self.conseiller = angular.copy(self.conseillers[i]);
						break;
					}
				}
			}

			function remove(mle) {
				console.log('mle to be deleted', mle);
				if (self.conseiller.mle === mle) {// clean form if the user to
													// be deleted is shown
													// there.
					reset();
				}
				deleteConseiller(mle);
			}

			function reset() {
				self.conseiller = {
					mle : null,
					nom : '',
					email : '',
					telephone : ''
				};
				$scope.myForm.$setPristine(); // reset Form
			}


			function fetchAllDemandes() {
				self.aServ.fetchAllDemandes().then(function(d) {
					self.demandes = d;
					console.log(self.demandes);
				}, function(errResponse) {
					console.error('Error while fetching Demandes');
				});
			}

			function fetchDemandesByConseiller(matricule) {
				self.aServ.fetchDemandesByConseiller(matricule).then(
						function(d) {
							self.demande = d;
						}, function(errResponse) {
							console.error('Error while fetching Demande');
						});
			}
		} ]);
