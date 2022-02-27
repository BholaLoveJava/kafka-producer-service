package com.sapient.web.configuration;

import com.sapient.web.model.EmployeeModel;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Bean
    public ProducerFactory<String,EmployeeModel> producerFactory(){
     Map<String,Object> mapConfig = new HashMap<>();
        mapConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        mapConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        mapConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(mapConfig);
    }

    @Bean
    @Primary
    @Qualifier("jsonKafka")
    public KafkaTemplate<String, EmployeeModel> getKafkaTemplateJSON(){
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String,String> producerFactoryString(){
        Map<String,Object> mapConfig = new HashMap<>();
        mapConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        mapConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        mapConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(mapConfig);
    }

    @Bean
    @Qualifier("simplekafka")
    public KafkaTemplate<String, String> getKafkaTemplate(){

        return new KafkaTemplate<>(producerFactoryString());
    }
}
