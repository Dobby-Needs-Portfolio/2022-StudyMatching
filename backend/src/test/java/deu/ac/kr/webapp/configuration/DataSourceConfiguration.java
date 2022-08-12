package deu.ac.kr.webapp.configuration;

import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import ch.vorburger.mariadb4j.springframework.MariaDB4jSpringService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

/**
 * <p>DataSource Configuration Class that configures MariaDB4J for unit testing.</p>
 * <p>Check <a href="https://github.com/vorburger/MariaDB4j/issues/64">This Github Issue from MariaDB4J repo</a>
 * to understand How this code works.</p>
 *
 * @author Mina-1316
 * @version 1.0
 */
@Lazy
@Configuration
@PropertySource("classpath:application-test.properties")
public class DataSourceConfiguration {

  @Bean
  MariaDB4jSpringService md4jService(
      @Value("${app.mariaDB4j.database}") String database,
      @Value("${app.mariaDB4j.port}") int port,
      @Value("${app.mariaDB4j.dataDir}") String dataDirectory
  ) throws ManagedProcessException {
    MariaDB4jSpringService md4jService = new MariaDB4jSpringService();

    md4jService.setDefaultPort(port);
    md4jService.setDefaultDataDir(dataDirectory);
    md4jService.start();
    md4jService.getDB().createDB(database);
    return md4jService;
  }

  @Bean
  @DependsOn("md4jService")
  DataSource dataSource(
      MariaDB4jSpringService md4jService,
      @Value("${app.mariaDB4j.database}") String database,
      @Value("${spring.datasource.username}") String username,
      @Value("${spring.datasource.password}") String password
  ) {

    DBConfigurationBuilder config = md4jService.getConfiguration();

    String url = "jdbc:mariadb://localhost:"
        + config.getPort()
        + "/"
        + database;

    return DataSourceBuilder.create()
        .username(username)
        .password(password)
        .url(url)
        .driverClassName("org.mariadb.jdbc.Driver")
        .build();
  }

}