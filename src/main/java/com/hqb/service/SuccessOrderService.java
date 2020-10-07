package com.hqb.service;
import com.hqb.pojo.Success;

import java.util.List;

public interface SuccessOrderService {
    List<Success> getSuccessOrderByProvideid(int provideid);
    List<Success> getSuccessOrderByNeedid(int needid);
}
