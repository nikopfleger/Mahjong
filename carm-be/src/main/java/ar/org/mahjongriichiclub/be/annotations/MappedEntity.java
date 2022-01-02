package ar.org.mahjongriichiclub.be.annotations;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
@Documented
public @interface MappedEntity {
	
	@SuppressWarnings("rawtypes")
	public Class entity();

}
