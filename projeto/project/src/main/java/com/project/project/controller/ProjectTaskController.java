package main.java.com.project.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProjectTaskController {

    private final ProjectService projectService;
    private final TaskService taskService;

    public ProjectTaskController(ProjectService projectService, TaskService taskService) {
        this.projectService = projectService;
        this.taskService = taskService;
    }

    @PostMapping("/projects/register")
    public ResponseEntity<?> registerProject(@RequestBody ProjectRegisterDTO project) {
        return projectService.register(project);
    }

    @PutMapping("/projects/edit")
    public ResponseEntity<?> editProject(@RequestBody ProjectRegisterDTO project) {
        return projectService.edit(project);
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDTO>> findAllProjects() {
        return projectService.findAll();
    }

    @GetMapping("/projects/{code}")
    public ResponseEntity<?> findProjectById(@PathVariable Long code) {
        return projectService.findById(code);
    }

    @DeleteMapping("/projects/{code}")
    public ResponseEntity<?> removeProject(@PathVariable Long code) {
        return projectService.remove(code);
    }

    @GetMapping("/projects/search")
    public ResponseEntity<List<ProjectDTO>> searchProjectsByStartDateAfter(@RequestParam LocalDate date) {
        return projectService.searchProjectsByStartDateAfter(date);
    }

    @PostMapping("/tasks/register")
    public ResponseEntity<?> registerTask(@RequestBody TaskRegisterDTO task) {
        return taskService.registerTask(task);
    }

    @PutMapping("/tasks/edit")
    public ResponseEntity<?> editTask(@RequestBody TaskRegisterDTO task) {
        return taskService.editTask(task);
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> findAllTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<?> findTaskById(@PathVariable UUID id) {
        return taskService.findTaskById(id);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<?> removeTask(@PathVariable UUID id) {
        return taskService.removeTask(id);
    }

    @GetMapping("/tasks/search/by-deadline")
    public ResponseEntity<List<TaskDTO>> searchTaskByDeadline(@RequestParam LocalDate dueDate) {
        return taskService.searchByDeadline(dueDate);
    }

    @GetMapping("/tasks/search/by-deadline-before")
    public ResponseEntity<List<TaskDTO>> searchTaskByDeadlineBeforeDate(@RequestParam LocalDate date) {
        return taskService.searchByDeadlineBefore(date);
    }
}
