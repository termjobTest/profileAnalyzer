package com.termjob.profileanalyzer.listener;

import com.termjob.profileanalyzer.model.Account;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GitHubAnalyzerListener {

    @KafkaListener(topics = "kafka_json", groupId = "groupjson", containerFactory = "kafkaListenerContainerFactory")
    public void receive(Account account){
        System.out.println("Consumed Message-->" +account);
    }
}
