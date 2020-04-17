package com.nacos.producer.model;


import lombok.Getter;
import lombok.Setter;
/**
 *
 * <功能详细描述>
 *
 * @author HX0011159
 * @title OrderTab
 * @date 2020/4/16
 * @since <版本号>
 */
@Setter
@Getter
public class OrderTab {

	private int id;
	private String orderId;
	/**
	 * 0:未处理，1：成功  2：失败
	 */
	private int status;
	private String createTime;
}
