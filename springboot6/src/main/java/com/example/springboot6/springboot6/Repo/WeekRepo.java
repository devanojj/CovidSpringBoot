package com.example.springboot6.springboot6.Repo;

import com.example.springboot6.springboot6.Models.Week;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeekRepo extends JpaRepository<Week, Long> {
}
