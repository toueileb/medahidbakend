package org.sidi.service.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.sidi.entities.Competence;
import org.sidi.repository.CompetenceRepository;
import org.sidi.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompetenceServiceImpl implements IService<Competence> {
    @Autowired
    private CompetenceRepository competenceRepository;
    @Override
    public Page<Competence> findAll(Pageable pageable, String searchText) {
        return competenceRepository.findAllCompetences(pageable,searchText);
    }

    @Override
    public Page<Competence> findAll(Pageable pageable) {
        return competenceRepository.findAll(pageable);
    }

    @Override
    public Competence findById(Long id) {
        return competenceRepository.getOne(id);
    }

    @Override
    public Competence saveOrUpdate(Competence competence) {
        return competenceRepository.save(competence);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            competenceRepository.deleteById(id);
            jsonObject.put("message", "Competence deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
