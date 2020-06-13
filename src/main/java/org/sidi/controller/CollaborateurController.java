package org.sidi.controller;

import org.sidi.entities.Collaborateur;
import org.sidi.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collaborateurs")
@CrossOrigin("*")
public class CollaborateurController implements Resource<Collaborateur>{
    @Autowired
    private IService<Collaborateur> iService;

    @Override
    public ResponseEntity<Page<Collaborateur>> findAll(Pageable pageable, String searchText) {
        return new ResponseEntity<>(iService.findAll(pageable, searchText), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<Collaborateur>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return new ResponseEntity<>(iService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collaborateur> findById(Long id) {
        return new ResponseEntity<>(iService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Collaborateur> save(Collaborateur collaborateur) {
        return new ResponseEntity<>(iService.saveOrUpdate(collaborateur), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Collaborateur> update(Collaborateur collaborateur) {
        return new ResponseEntity<>(iService.saveOrUpdate(collaborateur), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return new ResponseEntity<>(iService.deleteById(id), HttpStatus.OK);
    }
}
