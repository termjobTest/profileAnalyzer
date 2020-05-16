package com.termjob.profileanalyzer.listener;

import com.termjob.profileanalyzer.model.GitHubModel;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class GitHubAnalyzerListener {

    @KafkaListener(topics = "profileanalyzer", groupId = "github", containerFactory = "kafkaListenerContainerFactory")
    public void receive(GitHubModel gitHubModel){
        System.out.println("Consumed Message-->" +gitHubModel);
    }
}
