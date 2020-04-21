package com.nacos.producer.service;

import com.nacos.producer.model.OrderTab;
import java.util.List;

/**
 * 订单操作接口
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
public interface OrderTabService {


    /**
     * 添加订单接口
     * @author  HX0011159
     * @description 添加订单接口
     * @param  orderTab　订单实体参数
     * @return  void
     * @date  2020/4/20
     */
     void addOrderTab(OrderTab orderTab);


    /**
     * 修改订单接口
     * @author  HX0011159
     * @description 修改订单接口
     * @param  orderTab　订单实体参数
     * @return  void
     * @date  2020/4/20
     */
     void updateOrderTab(OrderTab orderTab);


    /**
     * 根据订单ID删除订单接口
     * @author  HX0011159
     * @description 根据订单ID删除订单接口
     * @param  orderId　订单Id参数
     * @return  void
     * @date  2020/4/20
     */
     void deleteByOrderId(String orderId);

    /**
     * 查询全部订单信息接口
     * @author  HX0011159
     * @description 查询全部订单信息接口
     * @return  java.util.List<com.nacos.producer.model.OrderTab>
     * @date  2020/4/20
     */
     List<OrderTab> findAll();

     /**
      * 测试本地事务
      * @author  HX0011159
      * @description  测试本地事务
      * @return  void
      * @date  2020/4/20
      */
     void testTranslation();

}
