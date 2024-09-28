package ru.specialist.building;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER })
@Qualifier("logs") // аннотация Spring !!!
public @interface WoodQualifier {
	String value() default "Sergey";
}
