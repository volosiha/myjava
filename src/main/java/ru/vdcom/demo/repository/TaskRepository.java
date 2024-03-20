package ru.vdcom.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.vdcom.demo.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Long>{
	  List<Task> findByPersonId(Long personId);
}
