package main;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.wha.springmvc.configuration.HelloWorldConfiguration;
import com.wha.springmvc.configuration.JpaConfiguration;
import com.wha.springmvc.model.DemandeOuverture;
import com.wha.springmvc.service.UtilisateurService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={HelloWorldConfiguration.class, JpaConfiguration.class})

public class UtilisateurServiceTest {
	
	@Autowired
	UtilisateurService uservice;
	
	@Test
	public void findAllDemandesTest(){
		List<DemandeOuverture> demandes = uservice.findAllDemandes();
		assertEquals(4, demandes.size());
		
	}

}
