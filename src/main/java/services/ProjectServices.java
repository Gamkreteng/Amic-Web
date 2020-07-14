package services;

import model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ProjectRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectServices {

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/project")
    public List<Project> getAllProject() {

        return projectRepository.findAll();
    }

    @PostMapping("/project")
    public Project createUserAccount(@Valid @RequestBody Project project) {
        return projectRepository.save(project);
    }
}
