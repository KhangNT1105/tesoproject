/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.crawler.config;

import com.teso.story.crawler.controller.CrawlerController;
import com.teso.story.lib.TStoryCrawlerService;
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
public class ThriftSever {

    @Bean
    public TProtocolFactory tProtocolFactory() {
        return new TBinaryProtocol.Factory();
    }

    @Bean
    public ServletRegistrationBean thriftBookServlet(TProtocolFactory protocolFactory, CrawlerController controller) {
        TServlet tServlet = new TServlet(new TStoryCrawlerService.Processor<>(controller), protocolFactory);
        return new ServletRegistrationBean(tServlet, "/storycrawler");
    }
}
