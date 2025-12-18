package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.GarageEntity;
import com.example.demo.repository.GarageRepository;

@Service
public class GarageImpl implements GarageService {
    @Autowired
    GarageRepository gr;
    @Override
    public GarageEntity create(GarageEntity ge){
        return gr.save(ge);
    }
    @Override
    public List<GarageEntity> getall(){
        return gr.findAll();
    }
    @Override
    public Optional<GarageEntity> getbyid(Long id){
        return gr.findById(id);
    }
    @Override
    public void delete(Long id){
        gr.deleteById(id);
    }

}

    
 
