package kz.iitu.springlab.web;

import kz.iitu.springlab.scope.SingletonBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/lab2")
public class Lab2Controller {

    private final SingletonBean singletonBean;

    public Lab2Controller(SingletonBean singletonBean) {
        this.singletonBean = singletonBean;
    }

    @GetMapping("/scopes")
    public Map<String, Object> getScopesDemo() {
        return singletonBean.demo();
    }
}