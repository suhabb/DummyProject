package application_service;

import data_transfer.PersonDTO;

import java.util.List;

public interface PersonApplicationService {

	void save(PersonDTO personDTO);

	PersonDTO findByName(String name);

	List<PersonDTO> findAll();
}
