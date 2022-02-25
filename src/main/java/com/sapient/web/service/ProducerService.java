package com.sapient.web.service;

import com.sapient.web.constants.ApplicationConstants;
import com.sapient.web.model.EmployeeModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    @Qualifier("simplekafka")
    private KafkaTemplate<String,String> kafkaTemplate;

    @Autowired
    @Qualifier("jsonKafka")
    private KafkaTemplate<String, EmployeeModel> jsonKafkaTemplate;

    public String publishMessageService(final String message){
        logger.info("IN ProducerService :: publishMessageService ()");
        kafkaTemplate.send(ApplicationConstants.KAFKA_TOPIC,message);
        logger.info("OUT ProducerService :: publishMessageService ()");
        return ApplicationConstants.SUCCESS_TEXT;
    }

    public String publishJSONMessageService(final EmployeeModel employeeData){
        logger.info("IN ProducerService :: publishJSONMessageService ()");
        jsonKafkaTemplate.send(ApplicationConstants.KAFKA_TOPIC,employeeData);
        logger.info("OUT ProducerService :: publishJSONMessageService ()");
        return ApplicationConstants.SUCCESS_TEXT;
    }
}
