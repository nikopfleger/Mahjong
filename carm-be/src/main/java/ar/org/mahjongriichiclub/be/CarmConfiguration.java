package ar.org.mahjongriichiclub.be;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import ar.org.mahjongriichiclub.be.annotations.MappedEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class CarmConfiguration implements WebMvcConfigurer {
	
	private static final Logger logger = LogManager.getRootLogger();
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Bean
	public BiMap<Class<?>, Class<?>> entityDTORelationship() {
		
		HashMap<Class<?>, Class<?>> entityDTORelationship = new HashMap<>();
		
		Reflections reflections = new Reflections("ar.org.mahjongriichiclub.be.dto");
		Set<Class<?>> dtoClasses = reflections.getTypesAnnotatedWith(MappedEntity.class);
		
		for (Class<?> dto : dtoClasses) {
			MappedEntity anno = dto.getAnnotation(MappedEntity.class);
			Class<?> entity = anno.entity();
			entityDTORelationship.put(entity, dto);
		}
		
		return HashBiMap.create(entityDTORelationship);
	}

	@Bean
	public MapperFactory mapperFactory() {		
		
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	
		BiMap<Class<?>, Class<?>> entityDTORelationship = entityDTORelationship();

		for (Map.Entry<Class<?>, Class<?>> e : entityDTORelationship.entrySet()) {
		    mapperFactory.classMap(e.getKey(), e.getValue());
		    String message = "MapperFactory: Mapping entity=" + e.getKey().getSimpleName() + " with dto=" + e.getValue().getSimpleName();
		    logger.info(message);
		}
		return mapperFactory;
	}

	@Bean
	@Override
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

	@Bean
	public LocaleResolver localeResolver() {
		SessionLocaleResolver slr = new SessionLocaleResolver();
		slr.setDefaultLocale(new Locale("es", ""));
		return slr;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

}
