package test21.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test21.data.model.SimpleRequest;
import test21.services.DoService;

@Slf4j
@RestController
@RequestMapping("/check-user")
public class DoController {
    @Autowired
    DoService service;

    @PostMapping
    public void assumeUserCheck(@RequestBody SimpleRequest request) {
        log.debug("Incomig message for produser DoController" + request.toString());
        service.sendMessage(request);
    }
}
