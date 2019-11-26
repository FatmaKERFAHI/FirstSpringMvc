package org.eclipse.FirstSpringMvc.configuration;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
	SpringResourceTemplateResolver templateResolver = new
	SpringResourceTemplateResolver();
	templateResolver.setPrefix("/WEB-INF/views/");
	templateResolver.setSuffix(".html");
	return templateResolver;
	}
	@Bean
	public SpringTemplateEngine templateEngine() {
	SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	templateEngine.setTemplateResolver(templateResolver());
	return templateEngine;
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	ThymeleafViewResolver resolver = new ThymeleafViewResolver();
	resolver.setTemplateEngine(templateEngine());
	resolver.setViewNames(new String [] {"thymeleaf/*"});
	registry.viewResolver(resolver);
	}
	@Bean
	InternalResourceViewResolver jspViewResolver() {
	InternalResourceViewResolver viewResolver = new
	InternalResourceViewResolver();
	viewResolver.setPrefix("/WEB-INF/views/");
	viewResolver.setSuffix(".jsp");
	viewResolver.setViewNames("jsp/*");
	return viewResolver;
	}
	@Bean
	public LocaleResolver localeResolver() {
	SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
	sessionLocaleResolver.setDefaultLocale(Locale.FRANCE);
	return sessionLocaleResolver;
	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	localeChangeInterceptor.setParamName("language");
	return localeChangeInterceptor;
	}
	@Bean
	public MessageSource messageSource() {
	ReloadableResourceBundleMessageSource messageSource = new
	ReloadableResourceBundleMessageSource();
	messageSource.setBasename("classpath:messages");
	messageSource.setDefaultEncoding("UTF-8");
	return messageSource;
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(localeChangeInterceptor());
	}
	
	}

