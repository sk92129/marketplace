package com.seankang.web;


import com.seankang.persistence.model.Project;
import com.seankang.persistence.repo.ProjectRepository;
import com.seankang.web.exception.ProjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;





@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository repo;

    @GetMapping
    public Iterable<Project> findAll() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public Project findOne(@PathVariable long id) {
        return repo.findById(id)
                .orElseThrow(ProjectNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody Project proj) {
        Project proj1 = repo.save(proj);
        return proj1;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repo.findById(id)
                .orElseThrow(ProjectNotFoundException::new);
        repo.deleteById(id);
    }

    @PutMapping("/{id}")
    public Project update(@RequestBody Project project, @PathVariable long id) {
        if (project.getId() != id) {
            throw new ProjectNotFoundException();
        }
        repo.findById(id)
                .orElseThrow(ProjectNotFoundException::new);
        return repo.save(project);
    }
}