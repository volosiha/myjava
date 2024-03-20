package ru.vdcom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vdcom.demo.entity.Person;

public interface PersonRepository extends JpaRepository<Person,Long>  {

};
