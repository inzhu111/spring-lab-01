package kz.iitu.springlab.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LifecycleLogger {

    private static final Logger log = LoggerFactory.getLogger(LifecycleLogger.class);

    public LifecycleLogger() {
        log.info("--> LifecycleLogger: Constructing bean...");
    }

    @PostConstruct
    public void init() {
        log.info("--> LifecycleLogger: @PostConstruct invoked!");
    }

    @PreDestroy
    public void destroy() {
        log.info("--> LifecycleLogger: @PreDestroy invoked!");
    }
}