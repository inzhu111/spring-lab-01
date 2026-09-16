package kz.iitu.springlab.notify;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component("html")
@Order(3)
public class HtmlNotifier implements Notifier {

    private static final Logger log = LoggerFactory.getLogger(HtmlNotifier.class);

    @PostConstruct
    public void init() {
        log.info("HtmlNotifier initialized");
    }

    @Override
    public String channel() {
        return "html";
    }

    public String send(String message) {
        if (message == null) {
            return "<p></p>";
        }
        String escaped = message.replace("<", "&lt;").replace(">", "&gt;");
        return "<p>" + escaped + "</p>";
    }
}