package com.pad.rest.webservices.restfulwebservices;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.context.support.ResourceBundleMessageSource;
import java.util.Locale;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	// @Bean
	// public ResourceBundleMessageSource messageSource() {
	// 	ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	// 	messageSource.setBasename("messages");
	// 	return messageSource;
	// }
}
