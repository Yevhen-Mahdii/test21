package test21.service;

import org.springframework.context.annotation.Import;
import test21.config.Test21QConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({Test21QConfig.class})
public @interface EnableTest21Stream {
}
