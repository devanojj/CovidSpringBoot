package com.example.springboot6.springboot6.Repo;

import com.example.springboot6.springboot6.Models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo  extends JpaRepository<Country, Long> {
}
