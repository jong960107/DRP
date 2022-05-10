package com.jong960107;

import java.util.Locale;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class DropthebeatAlone2Application {

	public static void main(String[] args) {
		SpringApplication.run(DropthebeatAlone2Application.class, args);
	}

	
}
