package deu.ac.kr.webapp.controller;

import io.sentry.Sentry;
import io.sentry.spring.tracing.SentrySpan;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller @Log4j2
public class TestController {
    @GetMapping("/test") @ResponseBody
    public String test() {
        return "Hello World!";
    }

    @GetMapping("/sentry-test") @ResponseBody
    @SentrySpan
    public String sentryTest() {
        throw new RuntimeException("Test Exception");
    }
}
