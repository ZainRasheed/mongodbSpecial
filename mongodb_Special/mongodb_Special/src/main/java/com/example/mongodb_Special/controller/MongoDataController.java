package com.example.mongodb_Special.controller;

import com.example.mongodb_Special.properties_pojo.Department;
import com.example.mongodb_Special.repo_for_springmogodata.MongoDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/dataController")
public class MongoDataController {

    @Autowired
    private MongoDataRepo mongoDataRepo;

    @GetMapping("/get")
    public List getMap(){
        return mongoDataRepo.findAll();
    }

    @GetMapping("/get/{id}")
    public Optional<Department> getId(@PathVariable("id") Integer id){
        return mongoDataRepo.findById(id);
    }

    @GetMapping("/get/byName/{name}")
    public List<Department> getDeptName(@PathVariable("name") String name){
        return mongoDataRepo.findAllByDeptName(name);
    }

    @PostMapping("/post")
    public Object postData(@RequestBody Department department){
        return mongoDataRepo.save(department);
    }

    @PutMapping("/put")
    public Department put(@RequestBody Department department){
        Optional<Department> dept = getId(department.getId());
        if(dept.isPresent()){ // Check is that id is present. It will automatically replace the data
            return mongoDataRepo.save(department);
        }else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        Optional<Department> dept = getId(id);
        if(dept.isPresent()){ // Check is that id is present. It will automatically replace the data
            mongoDataRepo.delete(dept.get());
            return "Deleted ID: "+id;
        }else {
            return "DOES NOT EXIST";
        }
    }
}
