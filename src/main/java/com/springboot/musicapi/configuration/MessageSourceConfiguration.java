package com.springboot.musicapi.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 
 * @author Vinicius Falcão
 *
 */
@Configuration
public class MessageSourceConfiguration {

	private MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public MessageSourceAccessor messageSourceAccessor() {
		return new MessageSourceAccessor(messageSource(), Locale.getDefault());
	}

}
