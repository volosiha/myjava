package ru.vdcom.demo.service;

import java.util.List;

import ru.vdcom.demo.entity.Task;

import ru.vdcom.demo.entity.Person;

public interface PersonService {
   List<Person> getAllPersons();
   
   Person savePerson(Person person);
   
   Person getPersonById(Long id);
   
   List<Task> getAllTasks(Person person);

   Task  saveTask(Task task);
   
   Task getTaskById(Long id);
   
   Task updateTask(Task task);
   
}
