package br.com.erudio.restcurso.services;

import br.com.erudio.restcurso.data.vo.v1.PersonVO;
import br.com.erudio.restcurso.data.vo.v2.PersonVOV2;
import br.com.erudio.restcurso.exceptions.ResourceNotFoundException;
import br.com.erudio.restcurso.mapper.DozerMapper;
import br.com.erudio.restcurso.mapper.custom.PersonMapper;
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

    @Autowired
    PersonMapper personMapper;

    private Logger logger = Logger.getLogger(PersonServices.class.getName());


    public PersonVO create(PersonVO person){
        logger.info("Creating one person!");
        Person entity = DozerMapper.parseObject(person, Person.class);
        PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person){
        logger.info("Creating one person with V2!");
        Person entity = personMapper.convertVoTOEntity(person);
        PersonVOV2 vo = personMapper.convertEntityToVo(personRepository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person){

        logger.info("Updating one person!");
       Person entity =  personRepository.findById(person.getId()).orElseThrow(() ->
               new ResourceNotFoundException("No records found for this ID"));

       entity.setFirstName(person.getFirstName());
       entity.setLastName(person.getLastName());
       entity.setAddress(person.getAddress());
       entity.setGender(person.getGender());
        PersonVO vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }


    public PersonVO findById(Long id){
        logger.info("Finding one person!");

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerMapper.parseObject(person, PersonVO.class);
    }

    public List<PersonVO> findAll(){
        return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }


    public void delete (Long id){
        logger.info("Deleting one person!");
        personRepository.deleteById(id);
    }
}
