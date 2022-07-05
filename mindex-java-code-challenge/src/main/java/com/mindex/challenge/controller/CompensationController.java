package com.mindex.challenge.controller;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompensationController {

    @Autowired
    private CompensationService compensationService;

    @PostMapping("employee/{id}/compensation")
    public Compensation create(@PathVariable String employeeId, @RequestBody Compensation compensation){
        return compensationService.create(employeeId, compensation);
    }
    @GetMapping("employee/{id}/compensation")
    public Compensation viewById(@PathVariable String employeeId) {
        return compensationService.viewByEmployee(employeeId);
    }
}
