package com.example.torneo.micro_one;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/send")
public class SenderController {
    @Value("${spring.cloud.aws.sqs.endpoint}")
    private String SQSEndpoint;
    @Autowired
    private SqsTemplate queueMessagingSender;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/{message}")
    public void send(@PathVariable("message") String message){
        Message<String> payload = MessageBuilder
                .withPayload(message)
                .setHeader("sender","Aplicacion spring boot")
                .build();
        queueMessagingSender.send(SQSEndpoint, payload);
    }

    @PostMapping("/send-exchange-rate")
    public void sendExchangeRateToSQS(@RequestBody ExchangeRate exchangeRate) throws JsonProcessingException {
        // Convert ExchangeRate object to JSON string
        String exchangeRateJson = objectMapper.writeValueAsString(exchangeRate);

        // Build the message with JSON payload
        Message<String> message = MessageBuilder
                .withPayload(exchangeRateJson)
                .setHeader("sender", "Aplicacion Spring Boot")
                .build();

        // Send the message to the SQS queue
        queueMessagingSender.send(SQSEndpoint, message);
    }
}
