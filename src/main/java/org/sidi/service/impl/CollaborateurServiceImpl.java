package org.sidi.service.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.sidi.entities.Collaborateur;
import org.sidi.repository.CollaborateurRepository;
import org.sidi.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CollaborateurServiceImpl implements IService<Collaborateur> {

    @Autowired
    private CollaborateurRepository collaborateurRepository;
    @Override
    public Page<Collaborateur> findAll(Pageable pageable, String searchText) {
        return collaborateurRepository.findAllCollaborateurs(pageable, searchText);
    }

    @Override
    public Page<Collaborateur> findAll(Pageable pageable) {
        return collaborateurRepository.findAll(pageable);
    }

    @Override
    public Collaborateur findById(Long id) {
        return collaborateurRepository.getOne(id);
    }

    @Override
    public Collaborateur saveOrUpdate(Collaborateur collaborateur) {
        return collaborateurRepository.save(collaborateur);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            collaborateurRepository.deleteById(id);
            jsonObject.put("message", "Collaborateur deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
