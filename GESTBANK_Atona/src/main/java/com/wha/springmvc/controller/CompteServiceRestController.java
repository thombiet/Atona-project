package com.wha.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wha.springmvc.model.Client;
import com.wha.springmvc.service.CompteService;

@RestController
public class CompteServiceRestController {

	@Autowired
	CompteService compteService;
	
	//-------------------Retrieve All Compte Of A Client--------------------------------------------------------
    
   
}
