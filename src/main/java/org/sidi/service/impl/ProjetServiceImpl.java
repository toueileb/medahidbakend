package org.sidi.service.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.sidi.entities.Projet;
import org.sidi.repository.ProjetRepository;
import org.sidi.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjetServiceImpl implements IService<Projet> {

    @Autowired
    private ProjetRepository projetRepository;
    @Override
    public Page<Projet> findAll(Pageable pageable, String searchText) {
        return projetRepository.findAllProjets(pageable,searchText);
    }

    @Override
    public Page<Projet> findAll(Pageable pageable) {
        return projetRepository.findAll(pageable);
    }

    @Override
    public Projet findById(Long id) {
        return projetRepository.getOne(id);
    }

    @Override
    public Projet saveOrUpdate(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            projetRepository.deleteById(id);
            jsonObject.put("message", "Book deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
