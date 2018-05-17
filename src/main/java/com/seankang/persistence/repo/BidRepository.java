package com.seankang.persistence.repo;



import org.springframework.data.repository.CrudRepository;

import com.seankang.persistence.model.Bid;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface BidRepository extends CrudRepository<Bid, Long> {
    List<Bid> findById(Integer id);
    Page<Bid> findByProjectId(Long projectId, Pageable pageable);
}
