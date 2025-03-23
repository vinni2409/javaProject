package main.java.com.project.project.Service;

import java.time.LocalDate;
import java.util.UUID;

class project {
    private Long code;
    private String name;
    private LocalDate startDate;

    public Project(Long code, String name, LocalDate startDate){
        this.code = code;
        this.name = name;
        this.startDate = startDate;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    interface ProjectRepository {
        Project save(Project project);

        List<Project> findAll();

        Optional<Project> findById(Long code);

        void delete(Long code);

        List<Project> findByStartDateAfter(LocalDate date);
    }

    class ProjectService {
        private final ProjectRepository projectRepository;

        public ProjectService(ProjectRepository projectRepository) {
            this.projectRepository = projectRepository;
        }

        public Project registerOrUpdate(Project project) {
            return projectRepository.save(project);
        }

        public List<Project> findAll() {
            return projectRepository.findAll();
        }

        public Optional<Project> findById(Long code) {
            return projectRepository.findById(code);
        }

        public void remove(Long code) {
            projectRepository.delete(code);
        }

        public List<Project> searchProjectsByStartDateAfter(LocalDate date) {
            return projectRepository.findByStartDateAfter(date);
        }
    }

    class Task {
        private UUID id;
        private String description;
        private LocalDate deadline;

        public Task(UUID id, String description, LocalDate deadline) {
            this.id = id;
            this.description = description;
            this.deadline = deadline;
        }

        public UUID getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public LocalDate getDeadline() {
            return deadline;
        }
        
        interface TaskRepository {
            Task save(Task task);

            List<Task> findAll();

            Optional<Task> findById(UUID id);

            void delete(UUID id);

            List<Task> findByDeadline(LocalDate dueDate);

            List<Task> findByDeadlineBefore(LocalDate date);
        }

        class TaskService {
            private final TaskRepository taskRepository;

            public TaskService(TaskRepository taskRepository) {
                this.taskRepository = taskRepository;
            }

            public Task registerOrUpdate(Task task) {
                return taskRepository.save(task);
            }

            public List<Task> findAll() {
                return taskRepository.findAll();
            }

            public Optional<Task> findById(UUID id) {
                return taskRepository.findById(id);
            }

            public void remove(UUID id) {
                taskRepository.delete(id);
            }

            public List<Task> searchTaskByDeadline(LocalDate dueDate) {
                return taskRepository.findByDeadline(dueDate);
            }

            public List<Task> searchTaskByDeadlineBefore(LocalDate date) {
                return taskRepository.findByDeadlineBefore(date);
            }
        }
    }
}
