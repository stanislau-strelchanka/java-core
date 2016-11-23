package chap6.interfaces.annotations.bankingdemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Stas on 02/04/2015.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface BankingAnnotation {
    SecurityLevelEnum securityLevel() default SecurityLevelEnum.NORMAL;
}

