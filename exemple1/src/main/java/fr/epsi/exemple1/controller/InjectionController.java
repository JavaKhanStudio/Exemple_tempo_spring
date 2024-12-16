package fr.epsi.exemple1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class InjectionController {

    @Value("${mon.api}")
    String api;

    @GetMapping
    public String getApi() {
        return api;
    }


}
