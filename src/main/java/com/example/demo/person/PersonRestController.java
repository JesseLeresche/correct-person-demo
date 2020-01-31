package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/people")
public class PersonRestController {

    private final PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/people")
    public ResponseEntity<List<PersonDto>> getAllPeople() {
        List<PersonDto> personDtoList = personService.findAll();
        return ResponseEntity.ok(personDtoList);
    }

    @PostMapping("/people/person")
    public ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto) {
        return ResponseEntity.ok(personService.createPerson(personDto));
    }

    @GetMapping("/people/person/{name}")
    public ResponseEntity getPerson(@PathVariable("name") String name) {
        ResponseEntity responseEntity;
        PersonDto person = personService.findPerson(name);
        if (person != null) {
            responseEntity = ResponseEntity.ok(person);
        } else {
            responseEntity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
