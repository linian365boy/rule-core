package com.jp.nian.rule.engine;

import java.util.Arrays;
import java.util.Date;
import com.jp.nian.rule.vo.CriticalConditionEnum;
import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;
import com.jp.nian.rule.vo.TypeEnum;

public class RuleTest9 {
	
	/**
	 * main:有规则
	 * 如果用户购买的商品满80，减5；满130减8；满170以上减10
	 * 测试1：购买商品110元，期望输出110-5
	 * 测试2：用户输入150元，期望输出150-8
	 * 测试3：用户输入200元，期望输出200-10
	 * 测试4：用户输入70元，期望输出70
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
		inputParam.setValue("70");
		/** 用户的输入 end **/
		
		/** 需要满足的运算条件  start **/
		Operation operation = new Operation();
		/** 设置临界条件为运算**/
		operation.setCriticalType(CriticalConditionEnum.Operation);
		/** 设置临界条件的运算**/
		operation.setCriticalOperation(Double.parseDouble(inputParam.getValue())>=80);
		operation.setPriority(1);
		operation.setExpectVal(String.valueOf(Double.parseDouble(inputParam.getValue())-5));
		
		Operation operation2 = new Operation();
		operation2.setCriticalType(CriticalConditionEnum.Operation);
		operation2.setCriticalOperation(Double.parseDouble(inputParam.getValue())>=130);
		operation2.setPriority(2);
		operation2.setExpectVal(String.valueOf(Double.parseDouble(inputParam.getValue())-8));
		
		Operation operation3 = new Operation();
		operation3.setCriticalType(CriticalConditionEnum.Operation);
		operation3.setCriticalOperation(Double.parseDouble(inputParam.getValue())>=170);
		operation3.setPriority(3);
		operation3.setExpectVal(String.valueOf(Double.parseDouble(inputParam.getValue())-10));
		/** 需要满足的条件  end **/
		
		Rule rule = new Rule();
		rule.setInputParams(Arrays.asList(inputParam));
		rule.setName("第九个规则例子");
		rule.setCreateDate(new Date());
		/** 需要根据前端输入的优先值，进行先后顺序绑定，高优先值，放在第一个 **/
		rule.setOperation(operation3).exclude(operation2).exclude(operation);
		rule.setOutputType(TypeEnum.Double);
		/** 设置不满足条件返回值  **/
		rule.setFalseValue(String.valueOf(Double.parseDouble(inputParam.getValue())));
		
		Object strResult = engine.loadRule(rule).execute();
		System.out.println("the result is "+strResult);
		System.out.println("the rule info is "+ rule);
	}
	
}
