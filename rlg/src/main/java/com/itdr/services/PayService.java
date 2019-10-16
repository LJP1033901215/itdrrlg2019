package com.itdr.services;

import com.itdr.common.ServerResponse;
import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpRequest;

import java.util.Map;

public interface PayService {
    ServerResponse aliPay(Long orderNo,Integer uid);

    ServerResponse alipayCaliback(Map<String, String> newMao);

}
