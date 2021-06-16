package test21.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import test21.service.EnableTest21Stream;
import test21.service.Test21StreamService;
import test21.data.UserCheckRabbitObject;
import test21.data.model.SimpleRequest;

@Slf4j
@Service
@EnableTest21Stream
@AllArgsConstructor
public class DoService {
    private final Test21StreamService stream;

    public void sendMessage(SimpleRequest request) {
        UserCheckRabbitObject.UserCheckRabbitObjectBuilder builder = UserCheckRabbitObject.builder();
        builder.name(request.getName());
        builder.checked(request.isChecked());
        UserCheckRabbitObject userCheckRabbitObject = builder.build();
        stream.processUserCheck(userCheckRabbitObject);
        log.info("Object " + userCheckRabbitObject + " successfully sent to RabbitMQ queue");
    }
}
