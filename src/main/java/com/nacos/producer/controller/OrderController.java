package com.nacos.producer.controller;

import com.nacos.producer.service.OrderTabService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * <功能详细描述>
 *
 * @author HX0011159
 * @title OrderController
 * @date 2020/4/16
 * @since <版本号>
 */
@RestController
public class OrderController {

    @Autowired
    private OrderTabService orderTabService;

    @GetMapping("/order")
    public void order(){
        //本地修改数据库更改
        orderTabService.addOrderTab();
        System.out.println(RootContext.getXID());
       // int i=1/0;
    }
}
