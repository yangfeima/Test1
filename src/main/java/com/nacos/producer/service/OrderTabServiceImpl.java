package com.nacos.producer.service;

import com.nacos.producer.exception.ServiceException;
import com.nacos.producer.model.OrderTab;
import org.springframework.stereotype.Service;
import com.nacos.producer.mapper.OrderTabMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import javax.annotation.Resource;

/**
 * 订单操作接口实现类
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
@Service
public class OrderTabServiceImpl implements OrderTabService {

    @Resource
    private OrderTabMapper orderTabMapper;


    /**
     * 添加订单接口实现
     * @author  HX0011159
     * @description 添加订单接口实现
     * @param  orderTab　订单实体参数
     * @return  void
     * @date  2020/4/20
     */
    @Override
    public void addOrderTab(OrderTab orderTab){
        orderTabMapper.addOrderTab(orderTab);
    }

    /**
     * 修改订单接口实现
     * @author  HX0011159
     * @description 修改订单接口实现
     * @param  orderTab　订单实体参数
     * @return  void
     * @date  2020/4/20
     */
    @Override
    public void updateOrderTab(OrderTab orderTab){
        orderTabMapper.updateOrderTab(orderTab);
    }


    /**
     * 根据订单ID删除订单接口实现
     * @author  HX0011159
     * @description 根据订单ID删除订单接口实现
     * @param  orderId　订单Id参数
     * @return  void
     * @date  2020/4/20
     */
    @Override
    public void deleteByOrderId(String orderId){
        orderTabMapper.deleteByOrderId(orderId);
    }

    /**
     * 查询全部订单信息接口实现
     * @author  HX0011159
     * @description 查询全部订单信息接口实现
     * @return  java.util.List<com.nacos.producer.model.OrderTab>
     * @date  2020/4/20
     */
    @Override
    public List<OrderTab> findAll(){
        List<OrderTab> list = orderTabMapper.findAll();
        if (list.size() > 0){
            return list;
        } else {
           throw new ServiceException("没有数据！","-1");
        }
    }

    /**
     * 测试本地事务
     * @author  HX0011159
     * @description 测试本地事务  不要在代码上try catch否则写第二个表报错时不会回滚
     * @return  void
     * @date  2020/4/20
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void testTranslation(){
        try {
            String orderId = System.currentTimeMillis() + "";
            OrderTab order = new OrderTab();
            order.setOrderId(orderId);
            order.setStatus(1);
            orderTabMapper.addOrderTab(order);
            OrderTab orders = new OrderTab();
            orders.setOrderId(orderId);
            orders.setStatus(0);
            orderTabMapper.updateOrderTab(orders);
        }catch (Exception e) {
            throw new ServiceException("测试本地事务处理异常" + e.getMessage(),"-1");
        }
    }
}
