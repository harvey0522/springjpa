package com.example.springjpa.jpa;

import com.example.springjpa.entry.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentJpa extends JpaRepository<Student, Integer> {
}
