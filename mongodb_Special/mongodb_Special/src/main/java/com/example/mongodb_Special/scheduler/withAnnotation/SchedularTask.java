package com.example.mongodb_Special.scheduler.withAnnotation;

import com.example.mongodb_Special.properties_pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.example.mongodb_Special.properties_pojo.Post.*;
import static java.time.ZonedDateTime.now;
import static java.util.Objects.isNull;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class SchedularTask  {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Scheduled(cron = "0 0/1 * * * ?")
    public void print(){
        System.out.println(now());
        runMongoUpdateQuery();
    }

    /*
    * This method is for a test regarding the TICKET
    * */
    private void runMongoUpdateQuery() {
        Query query = new Query();
        query.addCriteria(where("index").is(2).and("post").is(LOW.toString()));
        Update update = new Update();
        update.set("post", HIGH);
        Employee exists = mongoTemplate.findAndModify(query, update, Employee.class);
        if (isNull(exists)){
            System.out.println("Not updated");
        } else {
            System.out.println("Updated");
        }
    }

    //    Query query1 = TextQuery.queryText(TextCriteria.forDefaultLanguage().matchingAny("search term").sortByScore().with(new PageRequest(pageNum, docCount, new Sort(new Order(Sort.Direction.DESC, "score"))));

}
