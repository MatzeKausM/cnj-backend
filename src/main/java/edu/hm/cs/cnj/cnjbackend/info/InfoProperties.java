package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix="cnj.info")

public class InfoProperties {

}
