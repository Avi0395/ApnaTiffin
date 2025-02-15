package com.apnatiffin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apnatiffin.model.MessDetails;

@Repository
public interface MessDetailsRepository extends JpaRepository<MessDetails, Long> {

}
