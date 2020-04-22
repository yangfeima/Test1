package com.nacos.producer.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nacos.producer.model.OrderTab;
import com.nacos.producer.service.OrderTabService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
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
    @PostMapping("/insertOrder")
    @ApiOperation(value = "新增订单",notes = "新增订单")
    @ApiResponse(code = 400,message = "参数没有填好",response = String.class)
    public void insertOrder(@RequestBody OrderTab orderTab){//如果添加@RequestBody则用json传递
        orderTabService.insertOrderTab(orderTab);
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
    public void updateOrder(@RequestBody OrderTab orderTab){//javabean传递
        orderTabService.updateOrderTab(orderTab);
    }


    /**
     * 根据ID删除订单
     * @author  HX0011159
     * @description 根据ID删除订单
     * @param  id ID
     * @return  void
     * @date  2020/4/20
     */
    @GetMapping("/deleteOrder")
    @ApiOperation(value = "根据Id删除订单",notes = "根据Id删除订单")
    @ApiImplicitParam(paramType = "query",name = "id",value = "id",required = true,dataType = "int")
    public void deleteOrder(@RequestParam int id){
        orderTabService.deleteById(id);
    }


    /**
     * 查询全部订单
     * @author  HX0011159
     * @description  
     * @return  com.nacos.producer.contant.ResponseData
     * @date  2020/4/22
     */
    @GetMapping("/findAllOrder")
    @ApiOperation(value = "查询全部订单",notes = "默认查询全部订单")
    public ResponseData findAllOrder(){
        try {
            IPage<OrderTab> list= orderTabService.findAll();
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
    public ResponseData  testTranslation(){
        try {
            orderTabService.testTranslation();
            return new ResponseData("测试本地事务提交成功",200);
        } catch (Exception e){
            LOGGER.error("测试本地事务提交失败：" + e.getMessage(), e);
            return new ResponseData(e.getMessage(),-1);
        }
    }
}
