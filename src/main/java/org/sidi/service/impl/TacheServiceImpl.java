package org.sidi.service.impl;

import org.json.JSONException;
import org.json.JSONObject;
import org.sidi.entities.Tache;
import org.sidi.repository.TacheRepository;
import org.sidi.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TacheServiceImpl implements IService<Tache> {

    @Autowired
    private TacheRepository tacheRepository;
    @Override
    public Page<Tache> findAll(Pageable pageable, String searchText) {
        return tacheRepository.findAllTaches(pageable,searchText);
    }

    @Override
    public Page<Tache> findAll(Pageable pageable) {
        return tacheRepository.findAll(pageable);
    }

    @Override
    public Tache findById(Long id) {
        return tacheRepository.getOne(id);
    }

    @Override
    public Tache saveOrUpdate(Tache tache) {
        return tacheRepository.save(tache);
    }

    @Override
    public String deleteById(Long id) {
        JSONObject jsonObject = new JSONObject();
        try {
            tacheRepository.deleteById(id);
            jsonObject.put("message", "Tache deleted successfully");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }
}
