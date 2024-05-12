package com.example.first.repository;

import com.example.first.models.GenderName;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface GenderRep extends JpaRepository<GenderName,Integer> {



}
