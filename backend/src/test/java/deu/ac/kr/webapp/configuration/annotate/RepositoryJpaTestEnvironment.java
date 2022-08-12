package deu.ac.kr.webapp.configuration.annotate;


import deu.ac.kr.webapp.configuration.DataSourceConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

/**
 * This class annotates the test class to use configured embedded database.
 *
 * @author Mina-1316
 * @see DataSourceConfiguration
 * @version 1.0
 */
@DataJpaTest
// Use MariaDB4J for testing embedded database.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(DataSourceConfiguration.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RepositoryJpaTestEnvironment {
}
