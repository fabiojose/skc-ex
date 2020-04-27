package github.fabiojose;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author fabiojose
 */
@Configuration
public class AppConfiguration {

    @Autowired
    BuildProperties buildProperties;

    @PostConstruct
    public void init() {
        System.setProperty("APP_NAME", buildProperties.getName());
    }
}
