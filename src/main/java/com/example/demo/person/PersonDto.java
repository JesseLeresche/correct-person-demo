package com.example.demo.person;

public class PersonDto {

    private String username;
    private Integer age;
    private String password;

    public PersonDto() {
    }

    public PersonDto(String username, Integer age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public PersonDto(Person person) {
        this.username = person.getName();
        this.age = person.getAge();
        this.password = person.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
