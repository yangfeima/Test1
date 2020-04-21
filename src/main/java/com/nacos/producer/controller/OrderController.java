package com.nacos.producer.controller;

import com.nacos.producer.model.OrderTab;
import com.nacos.producer.service.OrderTabService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.nacos.producer.contant.ResponseData;
/**
 * 订单类
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
@RestController
@Api(value = "订单类")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderTabService orderTabService;

    /**
     * 新增订单信息
     * @author  HX0011159
     * @description 新增订单信息
     * @param  orderTab 订单实体参数
     * @return  void
     * @date  2020/4/20
     */
    @PostMapping("/addOrder")
    @ApiOperation(value = "新增订单",notes = "新增订单")
    @ApiResponse(code = 400,message = "参数没有填好",response = String.class)
    public void addOrder(@RequestBody OrderTab orderTab){//如果添加@RequestBody则用json传递
        orderTabService.addOrderTab(orderTab);
    }

    /**
     * 更改订单信息
     * @author  HX0011159
     * @description 更改订单信息
     * @param  orderTab 订单实体参数
     * @return  void
     * @date  2020/4/20
     */
    @PutMapping("/updateOrder")
    @ApiOperation(value = "更改订单",notes = "更改订单")
    @ApiResponse(code = 400,message = "参数没有填好",response = String.class)
    public void updateOrder(OrderTab orderTab){//javabean传递
        orderTabService.updateOrderTab(orderTab);
    }


    /**
     * 根据订单ID删除订单
     * @author  HX0011159
     * @description 根据订单ID删除订单
     * @param  orderId 订单ID
     * @return  void
     * @date  2020/4/20
     */
    @GetMapping("/deleteOrder")
    @ApiOperation(value = "删除订单",notes = "根据订单Id删除订单")
    @ApiImplicitParam(paramType = "query",name = "orderId",value = "订单ID",required = true,dataType = "String")
    public void deleteOrder(@RequestParam String orderId){
        orderTabService.deleteByOrderId(orderId);
    }


    /**
     * 查询全部订单信息
     * @author  HX0011159
     * @description  查询全部订单信息
     * @return  java.util.List<com.nacos.producer.model.OrderTab>
     * @date  2020/4/20
     */
    @GetMapping("/findAllOrder")
    @ApiOperation(value = "查询全部订单",notes = "默认查询全部订单")
    public ResponseData findAllOrder(){
        try {
            List<OrderTab> list = orderTabService.findAll();
            ResponseData response = new ResponseData("查询全部订单成功",200);
            response.setData(list);
           return response;
        } catch (Exception e){
            LOGGER.error("查询全部订单失败：" + e.getMessage(), e);
            return new ResponseData(e.getMessage(),-1);
        }
    }


    /**
     * 测试本地事务
     * @author  HX0011159
     * @description  测试本地事务
     * @return  void
     * @date  2020/4/20
     */
    @GetMapping("/testTranslation")
    public void  testTranslation(){
            orderTabService.testTranslation();

    }
}
