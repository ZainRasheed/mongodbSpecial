package com.example.mongodb_Special.controller;

import com.example.mongodb_Special.properties_pojo.Department;
import com.example.mongodb_Special.repo_for_mongotemplate.MongoTemplateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/templateController")
public class RestTemplateController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoTemplateRepo mongoTemplateRepo;

    @GetMapping("/get")
    public List getMap(){
        return mongoTemplateRepo.implFindAll();
        /*return mongoTemplate.findAll(Department.class);*/

    }

    @GetMapping("/get/{id}")
    public Department getId(@PathVariable("id") Integer id){
        return mongoTemplateRepo.implFindById(id);
    /*return mongoTemplate.findById(id, Department.class);*/

    }

    @GetMapping("/get/byName/{name}")
    public List<Department> getDeptName(@PathVariable("name") String name){
        return mongoTemplateRepo.implFindAllByDeptName(name);
        /*return mongoTemplate.find(Query, Department.class);*/

    }

    @PostMapping("/post")
    public Object postData(@RequestBody Department department){
        return mongoTemplateRepo.implSave(department);
        /*return mongoTemplate.save(department);*/

    }

    @PutMapping("/put")
    public Department put(@RequestBody Department department){
        mongoTemplateRepo.implFindAndModify(department);
        return mongoTemplate.findById(department.getId(), Department.class);
        /*return mongoTemplate.findAndModify(query, update, Department.class);*/

    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        return mongoTemplateRepo.implRemove(id);
//        return mongoTemplate.remove(query, Department.class);
    }
}
