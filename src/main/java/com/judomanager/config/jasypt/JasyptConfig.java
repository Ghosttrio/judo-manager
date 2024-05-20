package com.judomanager.config.jasypt;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

@Configuration
@EnableEncryptableProperties
public class JasyptConfig {
    private static final String ITERATION = "1000";

    private static final String POOL_SIZE = "2";

    private static final String GENERATOR_CLASS_NAME = "org.jasypt.salt.RandomSaltGenerator";

    private static final String ALGORITHM = "PBEWithMD5AndDES";

    private static final String OUTPUT_TYPE = "BASE256";

    @Bean
    @Primary
    public StringEncryptor jasyptStringEncryptor(Environment environment) {
        String password = environment.getProperty("jasypt.encryptor.password");
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(password);
        config.setAlgorithm(ALGORITHM);
        config.setKeyObtentionIterations(ITERATION);
        config.setPoolSize(POOL_SIZE);
        config.setSaltGeneratorClassName(GENERATOR_CLASS_NAME);
        config.setStringOutputType(OUTPUT_TYPE);
        encryptor.setConfig(config);
        return encryptor;
    }

}