package com.fangbo.spring.annotation.respository;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRespository implements UserRespository {

    public void save() {
        System.out.println("UserJdbcRespository save......");
    }
}
