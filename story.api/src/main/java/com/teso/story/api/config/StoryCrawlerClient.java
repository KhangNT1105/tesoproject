/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teso.story.api.config;

import com.teso.story.lib.TStoryCrawlerService;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;
import org.springframework.stereotype.Component;

/**
 *
 * @author ASUS
 */
@Component
public class StoryCrawlerClient extends TStoryCrawlerService.Client {
    
    public StoryCrawlerClient(TProtocolFactory prot) throws TTransportException {
        super(prot.getProtocol(new THttpClient("http://localhost:8082/storycrawler")));
    }
    
}
