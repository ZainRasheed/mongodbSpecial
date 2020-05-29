package com.example.mongodb_Special.repo_for_springmogodata;

import com.example.mongodb_Special.properties_pojo.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoDataRepo extends MongoRepository<Department, Integer> {

    List<Department> findAllByDeptName(String deptName);
}
