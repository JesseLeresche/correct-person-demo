package com.example.demo.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String password;

    public Person(String username, Integer age, String password) {
        this.name = username;
        this.age = age;
        this.password = password;
    }

    public Person(PersonDto personDto) {
        this.name = personDto.getUsername();
        this.password = personDto.getPassword();
        this.age = personDto.getAge();
    }
}
