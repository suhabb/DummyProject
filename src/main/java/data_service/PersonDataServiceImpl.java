package data_service;

import data_transfer.PersonDTO;
import domain.Person;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import repository.PersonRepository;

import java.util.List;

@Repository
public class PersonDataServiceImpl implements PersonDataService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private MapperFacade mapper;
	
	@Override
	public void save(PersonDTO personDTO){
		Person person = mapper.map(personDTO,Person.class);
		personRepository.save(person);
	}
	
	@Override
	public PersonDTO findByName(String name){
		Person person = personRepository.findByName(name);
		PersonDTO personDTO = mapper.map(person,PersonDTO.class);
		return personDTO;
	}

	@Override
	public List<PersonDTO> findAll(){
		List<Person> personList = personRepository.findAll();
		List<PersonDTO> personDTOList = mapper.mapAsList(personList, PersonDTO.class);
		return personDTOList;
	}

}
