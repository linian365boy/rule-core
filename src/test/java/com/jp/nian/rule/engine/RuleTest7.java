package com.jp.nian.rule.engine;

import java.util.Arrays;
import java.util.Date;
import com.jp.nian.rule.vo.CriticalConditionEnum;
import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;
import com.jp.nian.rule.vo.TypeEnum;

public class RuleTest7 {
	
	/**
	 * main:有规则
	 * 如果用户购买商品满100元，那么商品价格打9折，否则不打折。
	 * 测试1：购买商品190元，期望输出190*90%
	 * 测试2：用户输入90元，期望输出90
	 * 测试3：用户输入100元，期望输出100*90%
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
		inputParam.setValue("90");
		/** 用户的输入 end **/
		
		/** 需要满足的条件  start **/
		Operation operation = new Operation();
		operation.setCriticalType(CriticalConditionEnum.Operation);
		operation.setCriticalOperation(Double.parseDouble(inputParam.getValue())>=100);
		/** 需要满足的条件  end **/
		
		Rule rule = new Rule();
		rule.setInputParams(Arrays.asList(inputParam));
		rule.setName("第七个规则例子");
		rule.setCreateDate(new Date());
		rule.setOperation(operation);
		rule.setOutputType(TypeEnum.Double);
		/** 设置不满足条件返回值  **/
		rule.setFalseValue(String.valueOf(Double.parseDouble(inputParam.getValue())));
		/** 设置满足条件返回值  **/
		rule.setTrueValue(String.valueOf(Double.parseDouble(inputParam.getValue())*0.9));
		
		Object strResult = engine.loadRule(rule).execute();
		System.out.println("the result is "+strResult);
		System.out.println("the rule info is "+ rule);
	}
	
}
