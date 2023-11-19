package com.campushare.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Value("${spring.kafka.properties.topic.create-user-topic-name}")
    private String createUserTopicName;

    @Value("${spring.kafka.properties.topic.edit-user-topic-name}")
    private String editUserTopicName;

    @Bean
    NewTopic createUserTopic() {
        return TopicBuilder
                .name(createUserTopicName)
                .build();
    }

    @Bean
    NewTopic editUserTopic() {
        return TopicBuilder
                .name(editUserTopicName)
                .build();
    }
}
