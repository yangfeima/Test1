package com.nacos.producer.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.nacos.producer.model.OrderTab;

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
     void insertOrderTab(OrderTab orderTab);


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
     * 根据ID删除订单接口
     * @author  HX0011159
     * @description 根据ID删除订单接口
     * @param  id　Id参数
     * @return  void
     * @date  2020/4/20
     */
     void deleteById(int id);

    /**
     * 分页查询全部订单信息接口
     * @author  HX0011159
     * @description  
     * @return  com.baomidou.mybatisplus.core.metadata.IPage<com.nacos.producer.model.OrderTab>
     * @date  2020/4/22
     */
    IPage<OrderTab> findAll();

     /**
      * 测试本地事务
      * @author  HX0011159
      * @description  测试本地事务
      * @return  void
      * @date  2020/4/20
      */
     void testTranslation();

}
