package sberSchool.homework8.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {
    CacheType cachetype() default CacheType.FILE;
    String fileNamePrefix() default "data";
    boolean zip() default false;
    Class[] identityBy() default {String.class, Integer.class};
    boolean[] saveArgs() default {true, true};


}
