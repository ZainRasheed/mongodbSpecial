package com.example.mongodb_Special.repo_for_mongotemplate;

import com.example.mongodb_Special.properties_pojo.Department;

import java.util.List;

public interface MongoInterface {

    List implFindAll();

    Department implFindById(Integer id);

    List implFindAllByDeptName(String name);

    Object implSave(Department department);

    Department implFindAndModify(Department department);

    String implRemove(Integer id);
}
