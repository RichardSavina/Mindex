package com.mindex.challenge.controller;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportingController {

    @Autowired
    private ReportingStructureService reportingStructureService;

    @GetMapping("employee/{id}/reports")
    public ReportingStructure get(@PathVariable String employeeId){
        return reportingStructureService.getNumberOfReports(employeeId);
    }
}
