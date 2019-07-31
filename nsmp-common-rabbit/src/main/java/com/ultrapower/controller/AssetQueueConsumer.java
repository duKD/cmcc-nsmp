package com.ultrapower.controller;

import com.ultrapower.util.SerializeUtil;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.IOException;
import java.util.Map;

public class AssetQueueConsumer implements MessageListener {
    //当rountingKey与bindingKey匹配时进入该方法
    public void onMessage(Message message) {
        byte[] body = message.getBody();
        Map<String,Object> map = (Map<String,Object>)SerializeUtil.unserialize(body);
        //使用HttpClient远程调用Es
        String url="http://localhost:8888/es/updateEs?pkAsset="+map.get("pkAsset")+"&type="+map.get("type");
        // 根据地址获取请求
        HttpGet httpGet = new HttpGet(url);
        // 获取当前客户端对象
        HttpClient httpClient = new DefaultHttpClient();
        // 通过请求对象获取响应对象
        try {
            httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
