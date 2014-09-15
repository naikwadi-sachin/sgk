package org.sgk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.sgk.controller")
public class WebappConfig extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver getInternalResourcevViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource serverMessageSource()
	{
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/i18n/messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}

/*
 * @Bean
    ReloadableResourceBundleMessageSource serverMessageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(
                "/WEB-INF/i18n/messages",
                "/WEB-INF/i18n/monitor"
        );
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(messagesCacheTime);
        new LogbackConfig(config.getString("log.dir")).registerLoggers(logLevels);
        return messageSource;
    }
 * */
 