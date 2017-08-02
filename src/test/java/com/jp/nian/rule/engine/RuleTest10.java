package com.jp.nian.rule.engine;

import java.util.Arrays;
import java.util.Date;
import com.jp.nian.rule.vo.CriticalConditionEnum;
import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;
import com.jp.nian.rule.vo.TypeEnum;

public class RuleTest10 {
	
	/**
	 * main:有规则
	 * 如果用户购买的商品满300，则赠品一个；满500，赠品两个
	 * 测试1：购买商品310元，期望输出赠品一个（生产中，订单服务应该去获取一个赠品的id，并为该用户下单）
	 * 测试2：用户输入501元，期望输出赠品两个（生产中，订单服务应该去获取一个赠品的id，并为该用户下单）
	 * 测试3：用户输入200元，期望输出没有赠品
	 * @author tanfan 
	 * @param args 
	 * @since JDK 1.7
	 */
	public static void main(String[] args) throws Exception {
		RuleEngine engine = RuleEngineFactory.newInstance().getRuleEngine();
		
		/** 模拟用户的输入 start **/
		Parameter inputParam = new Parameter();
		inputParam.setName("price");
		inputParam.setCnName("价格");
		inputParam.setType(TypeEnum.Double);
		inputParam.setValue("200");
		/** 用户的输入 end **/
		
		/** 需要满足的运算条件  start **/
		Operation operation = new Operation();
		/** 设置临界条件为运算**/
		operation.setCriticalType(CriticalConditionEnum.Operation);
		/** 设置临界条件的运算**/
		operation.setCriticalOperation(Double.parseDouble(inputParam.getValue())>=300);
		operation.setPriority(1);
		operation.setExpectVal("赠品一个");
		
		Operation operation2 = new Operation();
		operation2.setCriticalType(CriticalConditionEnum.Operation);
		operation2.setCriticalOperation(Double.parseDouble(inputParam.getValue())>=500);
		operation2.setPriority(2);
		operation2.setExpectVal("赠品两个");
		/** 需要满足的条件  end **/
		
		Rule rule = new Rule();
		rule.setInputParams(Arrays.asList(inputParam));
		rule.setName("第十个规则例子");
		rule.setCreateDate(new Date());
		/** 需要根据前端输入的优先值，进行先后顺序绑定，高优先值，放在第一个 **/
		rule.setOperation(operation2).exclude(operation);
		rule.setOutputType(TypeEnum.Double);
		/** 设置不满足条件返回值  **/
		rule.setFalseValue("没有赠品");
		
		Object strResult = engine.loadRule(rule).execute();
		System.out.println("the result is "+strResult);
		System.out.println("the rule info is "+ rule);
	}
	
}
