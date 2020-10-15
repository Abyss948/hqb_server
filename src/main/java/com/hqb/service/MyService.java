package com.hqb.service;

import org.springframework.stereotype.Service;

import java.util.Map;


public interface MyService {
    Map<String, Object> getMyByUserid(int userid);
}
