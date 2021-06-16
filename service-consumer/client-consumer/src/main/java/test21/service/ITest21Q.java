package test21.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ITest21Q {
    @Output("service.test21.usercheck")
    MessageChannel channelUserCheck();
}
