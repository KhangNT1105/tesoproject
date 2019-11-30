/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.api.config;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ASUS
 */
@Configuration
public class ThriftClientConfig {

    @Bean
    public TProtocolFactory TProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }

}
