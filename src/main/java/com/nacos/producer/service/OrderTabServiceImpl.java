package com.nacos.producer.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nacos.producer.exception.ServiceException;
import com.nacos.producer.model.OrderTab;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.nacos.producer.mapper.OrderTabMapper;
import javax.annotation.Resource;

/**
 * 订单操作接口实现类
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
@Service
public class OrderTabServiceImpl extends ServiceImpl<OrderTabMapper, OrderTab> implements OrderTabService {

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
    public void insertOrderTab(OrderTab orderTab){
        orderTabMapper.insert(orderTab);
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
        orderTabMapper.updateById(orderTab);
    }


    /**
     * 根据订单ID删除订单接口实现
     * @author  HX0011159
     * @description 根据订单ID删除订单接口实现
     * @param  id　Id
     * @return  void
     * @date  2020/4/20
     */
    @Override
    public void deleteById(int id){
        orderTabMapper.deleteById(id);
    }

    /**
     * 分页查询全部订单信息接口
     * @author  HX0011159
     * @description  
     * @return  com.baomidou.mybatisplus.core.metadata.IPage<com.nacos.producer.model.OrderTab>
     * @date  2020/4/22
     */
    @Override
    public IPage<OrderTab> findAll(){
        QueryWrapper<OrderTab> wrapper = new QueryWrapper<>();
        Page<OrderTab> page = new Page<>(3, 5);
        IPage<OrderTab> iPage = orderTabMapper.selectPage(page,wrapper);
        if (iPage.getRecords().size() > 0){
            return iPage;
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
            orderTabMapper.insert(order);
            OrderTab orders = new OrderTab();
            orders.setOrderId(orderId);
            orders.setStatus(0);
            orderTabMapper.insert(orders);
        }catch (Exception e) {
            throw new ServiceException("测试本地事务处理异常" + e.getMessage(),"-1");
        }
    }
}
