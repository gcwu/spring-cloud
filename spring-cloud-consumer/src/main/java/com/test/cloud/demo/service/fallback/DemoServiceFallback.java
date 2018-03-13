package com.test.cloud.demo.service.fallback;

import com.alibaba.fastjson.JSON;
import com.test.cloud.common.util.ResultUtil;
import com.test.cloud.demo.service.DemoService;
import com.test.cloud.entity.User;
import org.springframework.stereotype.Component;

/**
 * 定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑
 */
@Component
public class DemoServiceFallback implements DemoService {
    @Override
    public User getUser(Integer id) {
        return null;
    }
}
