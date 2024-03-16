package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Admin;
import java.util.List;



@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    
	Admin findByUsername(String username);
}
