package ru.urfu.springskblab.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {})
@NotNull(message = "Username не может быть пустым")
@Size(min = 3, max = 24, message = "Username должен быть от 3 до 24 символов")
@Pattern(regexp = "^[a-zA-Z]+$", message = "Username должен содержать только английские буквы")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Username {
    String message() default "Username должен содержать только английские буквы и быть длинной от 3 до 24 символов";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
