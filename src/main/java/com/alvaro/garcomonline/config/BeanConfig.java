package com.alvaro.garcomonline.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    /*
    Istanciar na classe para converter o model para DTO, no ServiceImpl
    Exemplo: var userModel = modelMapper.map(userDTO, UserModel.class);
     */

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;
    }

}
