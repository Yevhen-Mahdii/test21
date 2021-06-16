package test21.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;
import test21.data.UserCheckRabbitObject;

@Slf4j
@Service
@AllArgsConstructor
public class Test21StreamService {
    private final ITest21Q queue;

    public void processUserCheck(UserCheckRabbitObject userCheckRabbitObject) {
        try {
            log.debug("Client-consumer retrieved object for processing:" + userCheckRabbitObject);
            queue.channelUserCheck().send(MessageBuilder.withPayload((new ObjectMapper()).writeValueAsString(userCheckRabbitObject)).build());
        } catch (JsonProcessingException e) {
            log.error("Something went wrong " + e.getMessage());
        }
    }
}
