package com.hyzs.essearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @program: es-search
 * @description:
 * @author: hux
 * @create: 2020-04-03 09:32
 **/
@Component
@Configurable
public class ElasticSearchConnector {

    @Value("${es.enable}")
    private boolean enable;

    @Value("${es.onlineFlag}")
    private String onlineFlag;

    @Value("${es.clusterName}")
    private String clusterName;


    @Value("${es.nodes}")
    private String nodes;


    @PostConstruct
    void init() {System.setProperty("es.set.netty.runtime.available.processors","false");}


    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", "es601").put("client.transport.sniff", true).build();
        TransportClient client = new PreBuiltTransportClient(settings);
        String[] nodesIp = "172.16.119.32:9300".split(";");
        for (int i = 0; i < nodesIp.length; i++){
            String[] ips = nodesIp[i].split(":");
            if (ips.length == 2){
                TransportAddress node = new TransportAddress(InetAddress.getByName(ips[0]), Integer.parseInt(ips[1]));
                client.addTransportAddress(node);
            }
        }
        return client;
    }

    @Override
    public String toString(){
        return "ElasticSearchConfig{" +
                "clusterName='" + clusterName + '\'' +
                ", nodes='" + nodes + '\'' +
                "}";
    }


    public boolean isEnable(){ return enable;}

    public String getClusterName(){
        return clusterName;
    }

    public String getNodes(){ return nodes;}

    public String getOnlineFlag(){
        return onlineFlag;
    }

}
