package com.sbm.mc.matchingaccelerator;

import com.sbm.mc.matchingaccelerator.config.AsyncSyncConfiguration;
import com.sbm.mc.matchingaccelerator.config.EmbeddedSQL;
import com.sbm.mc.matchingaccelerator.config.JacksonConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { MatchingAcceleratorApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedSQL
public @interface IntegrationTest {
}
