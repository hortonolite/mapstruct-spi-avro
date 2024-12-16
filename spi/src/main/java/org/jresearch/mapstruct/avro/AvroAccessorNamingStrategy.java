package org.jresearch.mapstruct.avro;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;

import javax.lang.model.element.ExecutableElement;

import java.util.List;

public class AvroAccessorNamingStrategy extends DefaultAccessorNamingStrategy {

    protected static final List<String> METHODS_TO_IGNORE = List.of(
        "getSpecificData",
        "getSchema"
    );

    @Override
    public boolean isGetterMethod(ExecutableElement method) {
        String methodName = method.getSimpleName().toString();

        if (METHODS_TO_IGNORE.contains(methodName)) {
            return false;
        }
        return super.isGetterMethod(method);
    }

}
