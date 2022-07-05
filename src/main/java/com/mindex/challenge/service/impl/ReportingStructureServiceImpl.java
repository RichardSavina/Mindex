package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.dao.ReportingStructureRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportingStructureServiceImpl  implements ReportingStructureService {
    @Autowired
    private ReportingStructureRepository reportingStructureRepository;
    private EmployeeRepository employeeRepository;
    private int count = 0;

    @Override
    public ReportingStructure getNumberOfReports(String employeeId) {
        ReportingStructure reportingStructure = new ReportingStructure();
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        reportingStructure.setEmployee(employee);
        reportingStructure.setNumberOfReports(numberOfReports(employee));
        reportingStructureRepository.insert(reportingStructure);
        return reportingStructure;
        }

    private int numberOfReports( Employee employee){
        if (employee.getDirectReports().size() > 0) {
            for (Employee e: employee.getDirectReports()) {
                count++;
                getNumberOfReports(e.getEmployeeId());
            }
        }
        return count;
    }
}
