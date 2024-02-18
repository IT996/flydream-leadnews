package com.flydream.article.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan({"com.flydream.common.mysql.core"})
@EnableScheduling
public class InitConfig {
}
