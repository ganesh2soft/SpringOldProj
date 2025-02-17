package com.ayna.rabbitmqdemo01.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.ayna.rabbitmqdemo01.config.MessagingConfig;
import com.ayna.rabbitmqdemo01.dto.BookStatus;

@Component
public class DriverConsumer {
	
	

	    @RabbitListener(queues = MessagingConfig.QUEUE)
	    public void consumeMessageFromQueue(BookStatus bookStatus) {
	        System.out.println("Message recieved from queue : " + bookStatus);
	    }
	}

