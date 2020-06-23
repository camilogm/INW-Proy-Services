package sv.hawklibrary.com.ORM.Annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({FIELD,PARAMETER, })
@Retention(RetentionPolicy.RUNTIME)
public @interface Identity {

	int value() default 1;
}
