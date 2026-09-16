package kz.iitu.springlab.web;

import kz.iitu.springlab.notify.Notifier;
import kz.iitu.springlab.scope.SingletonBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/lab2")
public class Lab2Controller {

    private final SingletonBean singleton1;
    private final Notifier customNotifier;

    public Lab2Controller(SingletonBean singleton1, @Qualifier("html") Notifier customNotifier) {
        this.singleton1 = singleton1;
        this.customNotifier = customNotifier;
    }

    @GetMapping("/scopes")
    public Map<String, Object> getScopes() {
        return singleton1.demo();
    }

    @GetMapping("/custom")
    public String customNotify(@RequestParam String text) {
        return customNotifier.send(text);
    }
}
