/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.data.config;

import com.teso.story.data.controller.storyController;
import com.teso.story.lib.TStoryDataService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ASUS
 */
@Configuration
public class ThriftServer {

    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }
    @Bean
    public ServletRegistrationBean thriftBookServlet(TProtocolFactory protocolFactory,storyController controller){
        TServlet tServlet = new TServlet(new TStoryDataService.Processor<>(controller), protocolFactory);
        return new ServletRegistrationBean(tServlet,"/storydata");
    }
}
