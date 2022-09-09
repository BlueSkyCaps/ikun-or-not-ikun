package top.reminisce.ikun.anno;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author BlueSkyCarry
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IsiKunConstantValidator.class})
public @interface IsiKun {
    String message() default "回答错误：你不是真的iKun！";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
