package com.esportsmore.web.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.qiniu")
public class QiNCFG {

    private String secretKey;

    private String appId;
}
