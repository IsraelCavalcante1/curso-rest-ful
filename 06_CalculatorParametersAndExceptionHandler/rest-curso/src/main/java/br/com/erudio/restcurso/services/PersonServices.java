package br.com.erudio.restcurso.services;

import br.com.erudio.restcurso.exceptions.ResourceNotFoundException;
import br.com.erudio.restcurso.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import br.com.erudio.restcurso.model.*;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public Person create(Person person){
        logger.info("Creating one person!");
        return personRepository.save(person);
    }

    public Person update(Person person){

        logger.info("Updating one person!");
       Person entity =  personRepository.findById(person.getId()).orElseThrow(() ->
               new ResourceNotFoundException("No records found for this ID"));

       entity.setFirstName(person.getFirstName());
       entity.setLastName(person.getLastName());
       entity.setAddress(person.getAddress());
       entity.setGender(person.getGender());
        return personRepository.save(entity);
    }


    public Person findById(Long id){
        logger.info("Finding one person!");
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }


    public void delete (Long id){
        logger.info("Deleting one person!");
        personRepository.deleteById(id);
    }
}
