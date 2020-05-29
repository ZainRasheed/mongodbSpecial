package com.example.mongodb_Special.properties_pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "employee")
public class Employee {

    @Id
    private  Object id;

    private Integer index;

    private String name;

    private Post post;
}
