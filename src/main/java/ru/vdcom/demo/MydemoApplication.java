package ru.vdcom.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.vdcom.demo.entity.Person;
import ru.vdcom.demo.repository.PersonRepository;

@SpringBootApplication
public class MydemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MydemoApplication.class, args);
	}

	//ссылка на объект класса с таблицей пользователей
	@Autowired
	private PersonRepository personRepository;
	
	//заполним таблицу с пользователями перед запуском
	@Override
	public void run(String... args) throws Exception {
		
		Person person1 = new Person("volosiha@bk.ru");
		personRepository.save(person1);
	}
	
	
}
