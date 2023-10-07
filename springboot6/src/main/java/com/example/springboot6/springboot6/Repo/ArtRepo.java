package com.example.springboot6.springboot6.Repo;

import com.example.springboot6.springboot6.Models.Art;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtRepo extends JpaRepository<Art, Long> {

}
