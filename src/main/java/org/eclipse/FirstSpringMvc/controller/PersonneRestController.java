package org.eclipse.FirstSpringMvc.controller;

import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;

import org.eclipse.FirstSpringMvc.dao.AdresseRepository;
import org.eclipse.FirstSpringMvc.dao.PersonneRepository;
import org.eclipse.FirstSpringMvc.model.Adresse;
import org.eclipse.FirstSpringMvc.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin
@RestController
public class PersonneRestController {
	@Autowired
	private PersonneRepository personneRepository;
	@Autowired
	private AdresseRepository adresseRepository;
	
	@GetMapping("/personnes")
	public List<Personne> getPersonnes() {
		return personneRepository.findAll();
	}

	@GetMapping("/personnes/{id}")
	public Personne getPersonne(@PathVariable("id") long id) {
		return personneRepository.findById(id).orElse(null);
	}

	@PostMapping("/personnes")
	public Personne addPersonne(@RequestBody Personne personne) {
	System.out.println(personne);
	List <Adresse> adresses = personne.getAdresses();
	for (Adresse adresse : adresses) {
	Adresse adr = null;
	if (adresse.getId() != null) {
		adr = adresseRepository.findById(adresse.getId()).orElse(
	null);
	adresses.set(adresses.indexOf(adresse), adr);
	} else {
		adr = adresseRepository.save(adresse);
		}
	}
	return personneRepository.saveAndFlush(personne);
	}
/*	@RequestMapping(method = RequestMethod.PUT)
	public Optional<Personne> updatePersonne(@RequestBody Personne personne) {

		  
		Optional<Personne> p = personneRepository.findById(personne.getNum());

		personne.savePersonne(personne);
		return p;
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteByNum(@RequestBody Personne personne) {
	 
		personneRepository.delete(personne);
		  return ResponseEntity.noContent().build();
	}*/

	@PostMapping("/putpersonnes")
	public Personne putPersonne(@RequestBody Personne personne) {
		return personneRepository.saveAndFlush(personne);
	}
   public boolean deletePersonne(@PathVariable("id") long id) {
		Personne personne = personneRepository.findById(id).orElse(null);
		if (personne != null) {
			personneRepository.delete(personne);
			return true;
		}
		return false;
	}



}


