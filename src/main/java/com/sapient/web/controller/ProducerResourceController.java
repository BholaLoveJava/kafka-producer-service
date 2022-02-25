package com.sapient.web.controller;

import com.sapient.web.model.EmployeeModel;
import com.sapient.web.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/producer")
public class ProducerResourceController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable String message) {
        return producerService.publishMessageService(message);
    }

    @PostMapping("/publish/json")
    public String publishJSONMessage(@RequestBody EmployeeModel employeeData){
        return producerService.publishJSONMessageService(employeeData);
    }
}
