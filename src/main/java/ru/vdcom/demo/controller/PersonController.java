package ru.vdcom.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.vdcom.demo.entity.Person;
import ru.vdcom.demo.entity.Task;
import ru.vdcom.demo.service.PersonService;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	private Long currentPersonId;
	
	public Long getCurrentPersonId() {
		return currentPersonId;
	}
	
	public void setCurrentPersonId(Long id) {
		this.currentPersonId = id;
	}
	

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	//handler to handle list persons request and return model and view
	@GetMapping("/persons")
	public String listPersons(Model model) {
	 model.addAttribute("persons", personService.getAllPersons());
	 return "persons";
	}
	
	//handler to show create person form
	@GetMapping("persons/new")
	public String createPersonform(Model model) {
	  Person person = new Person();
	  model.addAttribute("person", person);
	  return "create_person";
	}
	
	//handler for submitting new person
	@PostMapping("/persons")
	public String savePerson(@ModelAttribute("person") Person person) {
		personService.savePerson(person);
		return "redirect:/persons";
	}
	
	//handler to handle list tasks request and return model and view
    @GetMapping("/persons/todo/{id}")
	public String listTasks(@PathVariable Long id, Model model) {
    	 setCurrentPersonId(id);
		 model.addAttribute("tasks", personService.getAllTasks(personService.getPersonById(getCurrentPersonId())));
		 return "tasks";
    }
    
    //handler to show create task form
  	@GetMapping("tasks/new")
  	public String createTaskform(Model model) {
  	  Task task = new Task();
  	  model.addAttribute("task", task);
  	  return "create_task";
  	}
  	
  	//handler for submitting new task
	@PostMapping("/tasks")
	public String saveTask(@ModelAttribute("task") Task task) {

		String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		
		task.setPerson(personService.getPersonById(getCurrentPersonId()));
		task.setDate(date);
		personService.saveTask(task);
		
		return String.format("redirect:/persons/todo/%d",getCurrentPersonId()) ;
	}
	
	//handler to handle to show edit task form
    @GetMapping("/tasks/edit/{id}")
	public String editTaskForm(@PathVariable Long id, Model model) {
		 model.addAttribute("task", personService.getTaskById(id));
		 return "edit_task";
    }
    
   //handler for submitting updated task
    @PostMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute("task") Task task, Model model) {
    	Task dbTask = personService.getTaskById(id);
    	dbTask.setName(task.getName());
    	dbTask.setDescription(task.getDescription());
    	personService.updateTask(dbTask);
    	
    	return String.format("redirect:/persons/todo/%d",getCurrentPersonId()) ;
    }
}
	


