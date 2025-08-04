package custom_annotations;

import java.lang.annotation.*;

public class CustomAnnotation {
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface MyStep {
        String value() default "";
    }
}
