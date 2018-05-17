package com.seankang.web;


import com.seankang.persistence.model.Bid;
import com.seankang.persistence.model.Project;
import com.seankang.persistence.repo.BidRepository;

import com.seankang.persistence.repo.ProjectRepository;
import com.seankang.web.exception.BidNotFoundException;
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


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import javax.validation.Valid;

@RestController
public class BidController {

    @Autowired
    private BidRepository repo;

    @Autowired
    private ProjectRepository repoProject;

    @GetMapping("/api/bids/{projectId}/bids")
    public Page<Bid> findAll(  @PathVariable (value = "projectId") Long projectId,
                               Pageable pageable) {
        return repo.findByProjectId(projectId, pageable);
    }




    @PostMapping("/api/bids/{projectId}/bids")
    public Bid create(@PathVariable (value = "projectId") Long projectId,
                      @Valid @RequestBody Bid bid) {
        return repoProject.findById(projectId).map(project -> {
            bid.setProject(project);

            Bid bid1=  repo.save(bid);
            project.addBid(bid1);
            return bid1;
        }).orElseThrow(() -> new ProjectNotFoundException("ProjectId " + projectId + " not found"));
    }


}
