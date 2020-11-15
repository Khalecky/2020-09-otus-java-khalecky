package my.homeworks.hw03.my_framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@MyFrameworkAnnotation
public @interface Before {
    public String myVar() default "qwerty";
}
