package com.mindex.challenge.service.impl;


import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompensationServiceTest {

    private String compensationUrl;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
        compensationUrl = "http://localhost:" + port + "/employee/{id}/compensation";

    }

    @Test
    public void testCreate(){
        Employee testEmployee = new Employee();
        Compensation testCompensation = new Compensation();
        Date currentDate = new Date(2022,2,1);
        testCompensation.setEmployee(testEmployee);
        testCompensation.setSalary(50.00);
        testCompensation.setEffectiveDate(currentDate);

        Compensation createdCompensation = restTemplate.postForEntity(compensationUrl, testCompensation, Compensation.class).getBody();
        assertCompensationEquivalance(createdCompensation, testCompensation);
    }

    private void assertCompensationEquivalance(Compensation createdCompensation, Compensation testCompensation) {
        assertEquals(createdCompensation.getEmployee(), testCompensation.getEmployee());
        assertEquals(createdCompensation.getSalary(), testCompensation.getSalary());
        assertEquals(createdCompensation.getEffectiveDate(), testCompensation.getEffectiveDate());
    }
}
