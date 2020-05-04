package configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@PropertySource(value = {"application.properties"})
@EntityScan("com.endava.school4it.memebook.entity")
@ComponentScan("com.endava.school4it.memebook.dao")
@ComponentScan("com.endava.school4it.retrofit")
@ComponentScan("com.endava.school4it.pageObject")
@ComponentScan("com.endava.school4it.hooks")
@EnableJpaRepositories(basePackages = {"com.endava.school4it.memebook.repository"})
public class AppConfiguration {

}
