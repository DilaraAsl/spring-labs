package com.cydeo.spring05thymeleaf.converter;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@ConfigurationPropertiesBinding
public class UUIDConverter  implements Converter<String, UUID> {
    @Override
    public UUID convert(String source) {

        return UUID.fromString(source);
    }
}
