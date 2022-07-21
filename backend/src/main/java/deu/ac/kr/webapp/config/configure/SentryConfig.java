package deu.ac.kr.webapp.config.configure;

import io.sentry.spring.tracing.SentryTracingConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(SentryTracingConfiguration.class)
@Configuration
public class SentryConfig {
}
