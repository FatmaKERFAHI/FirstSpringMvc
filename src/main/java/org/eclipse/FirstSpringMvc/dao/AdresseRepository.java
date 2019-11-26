package org.eclipse.FirstSpringMvc.dao;

import org.eclipse.FirstSpringMvc.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {

}
