package test21.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test21.data.model.IncomingObject;
import test21.repositories.IncomingObjectRepository;

@Service
@Slf4j
public class ListenerService {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    IncomingObjectRepository repository;

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(value = "service.test21.usercheck", durable = "true"),
                    exchange = @Exchange(value = "service.test21.usercheck", durable = "true", type = "topic"),
                    key = "service.test21.usercheck"
            )
    )
    public void test21Listener(String request) {
        log.debug("Consumer listener retrieved object from queue " + request);

        try {
            IncomingObject object = mapper.readValue(request, IncomingObject.class);
            repository.save(object);
            log.info("Object " + object + "successfully saved to DB");

        } catch (JsonProcessingException e) {
           log.error("Something went wrong " + e.getMessage());
        }
    }

}
