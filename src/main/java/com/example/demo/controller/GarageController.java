package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.GarageEntity;
import com.example.demo.service.GarageService;

@RestController
public class GarageController {
@Autowired
GarageService gs;
@PostMapping("/post")
public GarageEntity add(@RequestBody GarageEntity gen){
    return gs.create(gen);
}
@GetMapping("/getall")
public List<GarageEntity> getalll(){
    return gs.getall();
}
@GetMapping("/getby{id}")
public Optional<GarageEntity> getbyids(@PathVariable Long id){
    return gs.getbyid(id);
}
@DeleteMapping("/delete")
public String deleteid(@PathVariable Long id){
    Optional<GarageEntity> onestudent=gs.getbyid(id);
    if(onestudent.isPresent()){
        gs.delete(id);
        return "Successfully deleted";
    }
    return "Id not found";
}
}
