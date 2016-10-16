package application_service;

import data_service.PersonDataService;
import data_transfer.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("personApplicationService")
public class PersonApplicationServiceImpl implements PersonApplicationService {
	
	@Autowired
	protected PersonDataService personDataService;
	
	
	@Override
	public void save(PersonDTO personDTO){
		personDataService.save(personDTO);
	}
	
	@Override
	public PersonDTO findByName(String name){
		return personDataService.findByName(name);
	}


	@Override
	public List<PersonDTO> findAll(){
		return personDataService.findAll();
	}

}
