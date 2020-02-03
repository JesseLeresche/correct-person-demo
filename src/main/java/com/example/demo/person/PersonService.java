package com.example.demo.person;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class PersonService {

    private final PersonRepository personRepository;
    private final PasswordEncoder passwordEncoder;


    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public PersonDto createPerson(PersonDto personDto) {
//        Person person = new Person(personDto);
        Person person = new Person(personDto.getUsername(), personDto.getAge(), passwordEncoder.encode(personDto.getPassword()));
        Person createdPerson = personRepository.save(person);
        return new PersonDto(createdPerson);
    }

    public PersonDto findPerson(String name) {
        //Get person from DB
        PersonDto foundPersonDto = null;
        Optional<Person> optionalPersonByName = personRepository.findByName(name);
        if (optionalPersonByName.isPresent()) {
            Person foundPerson = optionalPersonByName.get();
            log.info("Found person {}", foundPerson);
            foundPersonDto = new PersonDto(foundPerson);
        }
        return foundPersonDto;
    }

    public List<PersonDto> findAll() {
        List<Person> personList = personRepository.findAll();
        List<PersonDto> personDtoList = personList.stream().map(PersonDto::new).collect(Collectors.toList());
        return personDtoList;
    }
}
