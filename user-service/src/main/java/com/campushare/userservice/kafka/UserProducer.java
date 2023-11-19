package com.campushare.userservice.kafka;

import com.campushare.userservice.dto.UserDTO;
import com.campushare.userservice.utils.Topic;
import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProducer.class);

    @Autowired
    @Qualifier("createUserTopic")
    private NewTopic createUserTopicName;

    @Autowired
    @Qualifier("editUserTopic")
    private NewTopic editUserTopicName;

    @Autowired
    private KafkaTemplate<String, UserDTO> kafkaTemplate;

    public void sendMessage(Topic topic, UserDTO dto) {
        LOGGER.info(String.format("User event => %s", dto.toString()));
        Message<UserDTO> message;
        if (topic == Topic.CREATE) {
            message = MessageBuilder
                    .withPayload(dto)
                    .setHeader(KafkaHeaders.TOPIC, createUserTopicName.name())
                    .build();
        } else {
            message = MessageBuilder
                    .withPayload(dto)
                    .setHeader(KafkaHeaders.TOPIC, editUserTopicName.name())
                    .build();
        }
        kafkaTemplate.send(message);
    }
}
