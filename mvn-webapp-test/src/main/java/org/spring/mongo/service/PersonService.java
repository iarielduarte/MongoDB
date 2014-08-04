package org.spring.mongo.service;

import org.spring.mongo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by Ariel Duarte on 03/08/2014.
 */

@Repository
public class PersonService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "person";

    /**
     * insert new person document of the mongoDB
     * @param person
     */
    public void addPerson(Person person){
        if(!mongoTemplate.collectionExists(Person.class)){
            mongoTemplate.createCollection(Person.class);
        }
        person.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(person, COLLECTION_NAME);
    }

    /**
     * search all person documents of the mongoDB
     */
    public List<Person> listPerson(){
       return mongoTemplate.findAll(Person.class, COLLECTION_NAME);
    }

    /**
     * delete all person documents of the mongoDB
     */
    public void deletePerson(Person person){
        mongoTemplate.remove(person, COLLECTION_NAME);
    }

    /**
     * update all person documents of the mongoDB
     */
    public void updatePerson(Person person){
        mongoTemplate.insert(person, COLLECTION_NAME);
    }
}
