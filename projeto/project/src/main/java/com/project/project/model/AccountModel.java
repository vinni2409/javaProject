package main.java.com.project.project.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// Enum Status
enum Status {
    InProgress,
    Done,
    Pending
}

// Classe Project
class Project {
    private Long code;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Task> tasks;

    // Construtor vazio
    public Project() {
    }

    // Construtor com todos os atributos
    public Project(Long code, String name, String description, LocalDate startDate, LocalDate endDate,
            List<Task> tasks) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = tasks;
    }

    // Getters e Setters
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

// Classe Task
class Task {
    private UUID id;
    private String title;
    private String description;
    private LocalDate deadline;
    private Status status = Status.Pending;
    private Project project;

    // Construtor vazio
    public Task() {
    }

    // Construtor com todos os atributos
    public Task(UUID id, String title, String description, LocalDate deadline, Status status, Project project) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.project = project;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
