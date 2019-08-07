package com.sucl.hbase.demp.demo;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * HBase相关配置
 */
@Configuration
public class HBaseConfig {

    @Value("${HBase.nodes}")
    private String nodes;

//    @Value("${HBase.master}")
//    private String master;

    @Value("${HBase.maxsize}")
    private String maxsize;

    @Bean
    public HBaseService getHbaseService() {
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", nodes);  //hdp-nn01,hdp-nn02,hdp-dn03
        conf.set("hbase.client.keyvalue.maxsize", maxsize);
        conf.set("hbase.zookeeper.property.clientPort", "2181");
//        conf.set("hbase.zookeeper.quorum", "hdp-nn01,hdp-nn02,hdp-dn03");//这是我用到的3个节点
//        conf.set("hbase.master", master);

        return new HBaseService(conf);
    }
}
