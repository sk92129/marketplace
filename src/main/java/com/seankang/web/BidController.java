package com.seankang.web;


import com.seankang.persistence.model.Bid;
import com.seankang.persistence.repo.BidRepository;
import com.seankang.web.exception.BidNotFoundException;
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


@RestController
@RequestMapping("/api/bids")
public class BidController {

    @Autowired
    private BidRepository repo;

    @GetMapping
    public Iterable<Bid> findAll() {
        return repo.findAll();
    }


    @GetMapping("/{id}")
    public Bid findOne(@PathVariable long id) {
        return repo.findById(id)
                .orElseThrow(BidNotFoundException::new);
    }
}
