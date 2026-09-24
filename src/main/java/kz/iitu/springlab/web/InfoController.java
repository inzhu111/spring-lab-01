package kz.iitu.springlab.web;

import kz.iitu.springlab.config.AppProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {

    private final AppProperties properties;

    public InfoController(AppProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/info")
    public Map<String, Object> getInfo() {
        return Map.of(
                "owner", properties.owner(),
                "group", properties.group(),
                "mail", properties.mail()
        );
    }
}