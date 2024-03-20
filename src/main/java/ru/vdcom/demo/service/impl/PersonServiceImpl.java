package ru.vdcom.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.vdcom.demo.entity.Person;
import ru.vdcom.demo.entity.Task;
import ru.vdcom.demo.repository.PersonRepository;
import ru.vdcom.demo.repository.TaskRepository;
import ru.vdcom.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	private PersonRepository personRepository;
	private TaskRepository taskRepository;
	
	public PersonServiceImpl(PersonRepository personRepository, TaskRepository taskRepository) {
		super();
		this.personRepository = personRepository;
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	@Override
	public Person getPersonById(Long id) {
		return personRepository.findById(id).get();
	}

	@Override
	public List<Task> getAllTasks(Person person) {
		return taskRepository.findByPersonId(person.getId());
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public Task updateTask(Task task) {
		return taskRepository.saveAndFlush(task);
	}


}
