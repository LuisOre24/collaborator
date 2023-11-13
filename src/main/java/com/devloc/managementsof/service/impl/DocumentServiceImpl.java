package com.devloc.managementsof.service.impl;


import com.devloc.managementsof.entity.Document;
import com.devloc.managementsof.repository.IDocumentRepo;
import com.devloc.managementsof.service.IDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    private IDocumentRepo repo;
    @Override
    public Document create(Document entity) {
        return repo.save(entity);
    }

    @Override
    public Document update(Document entity) {
        return repo.save(entity);
    }

    @Override
    public List<Document> getAll() {
        return repo.findAll();
    }

    @Override
    public Document getOneById(Integer id) {
        Optional<Document> optional = repo.findById(id);
        return optional.isPresent() ? optional.get() : new Document();
    }

    @Override
    public void deleteById(Integer id) {

    }
}
