package my.homeworks.hw03.my_framework.exceptions;

import java.lang.annotation.Annotation;

public class AnnotationNotExistsException extends Exception
{
    private String annotationClass;

    public AnnotationNotExistsException(String annotationClass) {
        this.annotationClass = annotationClass;
    }

    @Override
    public String getMessage() {
        return "Can't run framework test. Annotation not exist: " + annotationClass;
    }

}
