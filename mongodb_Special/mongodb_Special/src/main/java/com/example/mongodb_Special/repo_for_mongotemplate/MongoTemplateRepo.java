package com.example.mongodb_Special.repo_for_mongotemplate;

import com.example.mongodb_Special.properties_pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
public class MongoTemplateRepo implements MongoInterface {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List implFindAll() {
        return mongoTemplate.findAll(Department.class);
    }

    @Override
    public Department implFindById(Integer id) {
        return mongoTemplate.findById(id, Department.class);
    }

    @Override
    public List implFindAllByDeptName(String name) {
        Query query = new Query();
        query.addCriteria(where("deptName").is(name));
        return mongoTemplate.find(query, Department.class);
    }

    @Override
    public Object implSave(Department department) {
        return mongoTemplate.save(department);
    }

    @Override
    public Department implFindAndModify(Department department) {
        Query query = new Query();
        query.addCriteria(where("id").is(department.getId()));
        Update update = new Update();
        update.set("deptName", department.getDeptName());
        update.set("description", department.getDescription());
        return mongoTemplate.findAndModify(query, update, Department.class);
    }

    @Override
    public String implRemove(Integer id) {
        Query query = new Query();
        query.addCriteria(where("id").is(id));
        return mongoTemplate.remove(query, Department.class).toString();
    }
}
