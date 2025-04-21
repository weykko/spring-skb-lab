package ru.urfu.springskblab.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {PasswordValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Password {
    String message() default "Пароль должен быть длинной от 8 символов, содержать заглавные буквы и цифры";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
