package com.hqb.service;

import org.springframework.stereotype.Service;

import java.util.Map;


public interface WebClientService {
    Map<String, Object> getWebClientByUserid(int userid);
}
