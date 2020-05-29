package com.example.mongodb_Special.properties_pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "department")
public class Department {

    @Id
    private Integer id;

    @Indexed(unique = true, direction = IndexDirection.ASCENDING, name = "indexed_id")
    private Integer index;

    @Indexed(unique = false, name = "indexed_deptName", direction = IndexDirection.ASCENDING)
    private String deptName;

    private String description;

}
