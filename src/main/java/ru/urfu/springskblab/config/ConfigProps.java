package ru.urfu.springskblab.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "config")
public class ConfigProps {
    private List<String> values;
}
