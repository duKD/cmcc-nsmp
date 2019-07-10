package com.ultrapower.controller;

import com.mongodb.WriteResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:/applicationContext-mongodb.xml")
public class MongodbTest {
    @Autowired
    MongoTemplate mongoTemplate;
    @Test
    public void test01(){
        Demo demo = new Demo();
        demo.setField1("value1");
        demo.setField2("value2");
        mongoTemplate.insert(demo);
    }
    @Test
    public void test02(){
        Query query = new Query(Criteria.where("field1").is("value1"));
        WriteResult remove = mongoTemplate.remove(query, Demo.class);
        System.out.println(remove);
    }
    @Test
    public void test03(){
        Query query = new Query(Criteria.where("field1").is("value1"));
        Update update = new Update();
        update.set("field1","111");
        mongoTemplate.updateMulti(query,update,Demo.class);
    }
    @Test
    public void test04(){
        List<Demo> all = mongoTemplate.findAll(Demo.class);
        System.out.println(all);
    }
    @Test
    public void test05(){
        Employee employee = new Employee();
        employee.seteId("aaa");
        employee.seteName("ak47");
        Demo demo = new Demo();
        demo.setField1("lll");
        demo.setField2("lll");
        employee.setDemo(demo);
        mongoTemplate.insert(demo);
        mongoTemplate.insert(employee);
    }
}
