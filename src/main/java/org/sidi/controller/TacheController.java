package org.sidi.controller;

import org.sidi.entities.Tache;
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
@RequestMapping("/taches")
@CrossOrigin("*")
public class TacheController implements Resource<Tache>{

    @Autowired
    private IService<Tache> iService;
    @Override
    public ResponseEntity<Page<Tache>> findAll(Pageable pageable, String searchText) {
        return new ResponseEntity<>(iService.findAll(pageable, searchText), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Page<Tache>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir) {
        return new ResponseEntity<>(iService.findAll(
                PageRequest.of(
                        pageNumber, pageSize,
                        sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending()
                )
        ), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Tache> findById(Long id) {
        return new ResponseEntity<>(iService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Tache> save(Tache tache) {
        return new ResponseEntity<>(iService.saveOrUpdate(tache), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Tache> update(Tache tache) {
        return new ResponseEntity<>(iService.saveOrUpdate(tache), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return new ResponseEntity<>(iService.deleteById(id), HttpStatus.OK);
    }
}
