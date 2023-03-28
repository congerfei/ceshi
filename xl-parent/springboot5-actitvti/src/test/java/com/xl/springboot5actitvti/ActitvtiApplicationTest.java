package com.xl.springboot5actitvti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author: xl
 * date :2021/1/5 9:51
 * description:
 * History:
 * <author>      <time>     <version>       <desc>
 * 作者姓名      修改时间    版本号          描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActitvtiApplicationTest {

    @Autowired
    ProcessEngine processEngine;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testDeployment() {
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .name("StartEvent_1")
                .addClasspathResource("processes/test.bpmn")
                .addClasspathResource("processes/test.png")
                .deploy();

        System.out.println(deployment.getId());
        System.out.println(deployment.getName());

    }

}
