package repository;

import domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PersonRepository extends MongoRepository<Person,String>{
	
	Person findByName(String name);
	Person findByAge(Integer age);
	List<Person> findAll();

}
