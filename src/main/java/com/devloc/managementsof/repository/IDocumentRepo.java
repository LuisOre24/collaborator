package com.devloc.managementsof.repository;


import com.devloc.managementsof.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentRepo extends JpaRepository<Document, Integer> {
}
