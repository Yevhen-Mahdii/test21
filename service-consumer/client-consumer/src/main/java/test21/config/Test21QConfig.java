package test21.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import test21.service.ITest21Q;

@Configuration
@ComponentScan
@EnableBinding(ITest21Q.class)
public class Test21QConfig {
}
