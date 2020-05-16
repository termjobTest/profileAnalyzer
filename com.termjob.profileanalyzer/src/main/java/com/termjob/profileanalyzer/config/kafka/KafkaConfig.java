package com.termjob.profileanalyzer.config.kafka;

import com.termjob.profileanalyzer.model.Account;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, Account> accountConsumerFactory(){
        Map<String,Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        map.put(ConsumerConfig.GROUP_ID_CONFIG, "groupjson");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), new JsonDeserializer<>(Account.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,Account> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String,Account> kafkaListenerContainerFactory= new ConcurrentKafkaListenerContainerFactory<>();
        kafkaListenerContainerFactory.setConsumerFactory(accountConsumerFactory());
        return kafkaListenerContainerFactory;
    }
}
