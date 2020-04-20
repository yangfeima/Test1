package com.nacos.producer.mapper;


import com.nacos.producer.model.OrderTab;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * 订单Mapper
 *
 * @author HX0011159
 * @date 2020/4/20
 * @since <版本号>
 */
@Mapper
public interface OrderTabMapper {


	/**
	 * 新增订单信息更新一个
	 * @author  HX0011159
	 * @description  新增订单信息更新一个
	 * @param  orderTab　订单实体参数
	 * @return  void
	 * @date  2020/4/20
	 */
	 void addOrderTab(OrderTab orderTab);

	/**
	 * 更改订单信息
	 * @author  HX0011159
	 * @description 更改订单信息
	 * @param  orderTab　订单实体参数
	 * @return  void
	 * @date  2020/4/20
	 */
	 void updateOrderTab(OrderTab orderTab);

	/**
	 * 根据订单ID删除订单
	 * @author  HX0011159
	 * @description 根据订单ID删除订单
	 * @param  orderId　订单Id参数
	 * @return  void
	 * @date  2020/4/20
	 */
	 void deleteByOrderId(String orderId);

	/**
	 * 查询全部订单信息
	 * @author  HX0011159
	 * @description 查询全部订单信息
	 * @return  java.util.List<com.nacos.producer.model.OrderTab>
	 * @date  2020/4/20
	 */
	 List<OrderTab> findAll();

}
