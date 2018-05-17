package com.seankang.persistence.repo;



import org.springframework.data.repository.CrudRepository;

import com.seankang.persistence.model.Bid;

import java.util.List;


public interface BidRepository extends CrudRepository<Bid, Long> {
    List<Bid> findById(Integer id);
}
