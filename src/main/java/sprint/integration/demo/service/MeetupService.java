package sprint.integration.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(Book contact)  {
        try {
            //convert book to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String bookString = objectMapper.writeValueAsString(contact);
            System.out.println("Sending a JMS message:" + bookString);
            jmsTemplate.convertAndSend("testQueue", bookString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
