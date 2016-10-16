package data_service;

import data_transfer.PersonDTO;

import java.util.List;

public interface PersonDataService {

	void save(PersonDTO personDTO);
	PersonDTO findByName(String name);

	List<PersonDTO> findAll();
}
