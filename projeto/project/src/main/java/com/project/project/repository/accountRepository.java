package main.java.com.project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> searchProjectsByStartDateAfter(LocalDate date);
}

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> searchTaskByDeadline(LocalDate dueDate);

    List<Task> searchTaskByDeadlineBefore(LocalDate date);
}
