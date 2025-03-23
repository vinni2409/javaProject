package main.java.com.project.project.dto;
    
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

class ProjectDTO {
    private Long code;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Task> tasks;

    public ProjectDTO() {
    }

    public ProjectDTO(Long code, String name, String description, LocalDate startDate, LocalDate endDate,
            List<Task> tasks) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = tasks;
    }

    public static ProjectDTO toDTO(Project project) {
        return new ProjectDTO(
                project.getCode(), project.getName(), project.getDescription(),
                project.getStartDate(), project.getEndDate(), project.getTasks());
    }
}

class TaskDTO {
    private UUID id;
    private String title;
    private String description;
    private LocalDate deadline;
    private Status status;
    private String projectName;

    public TaskDTO() {
    }

    public TaskDTO(UUID id, String title, String description, LocalDate deadline, Status status, String projectName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.projectName = projectName;
    }

    public static TaskDTO toDTO(Task task) {
        return new TaskDTO(
                task.getId(), task.getTitle(), task.getDescription(), task.getDeadline(), task.getStatus(),
                task.getProject().getName());
    }
}

class ProjectRegisterDTO {
    private Long code;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    public ProjectRegisterDTO() {
    }

    public ProjectRegisterDTO(Long code, String name, String description, LocalDate startDate, LocalDate endDate) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Project toModel() {
        return new Project(code, name, description, startDate, endDate, null);
    }
}

class TaskRegisterDTO {
    private UUID id;
    private String title;
    private String description;
    private LocalDate deadline;
    private Status status;
    private Long projectCode;

    public TaskRegisterDTO() {
    }

    public TaskRegisterDTO(UUID id, String title, String description, LocalDate deadline, Status status,
            Long projectCode) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.projectCode = projectCode;
    }

    public Task toModel(Project project) {
        return new Task(id, title, description, deadline, status, project);
    }
}

class Project {
    private Long code;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Task> tasks;

    public Project(Long code, String name, String description, LocalDate startDate, LocalDate endDate,
            List<Task> tasks) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.tasks = tasks;
    }
}

class Task {
    private UUID id;
    private String title;
    private String description;
    private LocalDate deadline;
    private Status status;
    private Project project;

    public Task(UUID id, String title, String description, LocalDate deadline, Status status, Project project) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
        this.project = project;
    }
}

enum Status {
    PENDING, IN_PROGRESS, COMPLETED;
}

