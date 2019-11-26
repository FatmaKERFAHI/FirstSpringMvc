package org.eclipse.FirstSpringMvc.dao;

import java.util.List;

import org.eclipse.FirstSpringMvc.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
	List<Personne> findByNomAndPrenom(String nom, String prenom);

	@Query("select p from Personne p where p.nom = ?1")
	Personne findByNom(String nom);
}
