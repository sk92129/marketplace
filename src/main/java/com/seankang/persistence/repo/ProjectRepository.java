package com.seankang.persistence.repo;


import com.seankang.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Long> {
    List<Project> findByDescription(String description);
}