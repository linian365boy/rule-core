package com.jp.nian.rule.engine;

import java.util.Arrays;
import java.util.Date;

import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Operator;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;
import com.jp.nian.rule.vo.TypeEnum;

public class RuleTest5 {
	
	/**
	 * main:有规则
	 * 如果用户输入名称输入偶数时，则返回success，否则返回fail。
	 * 测试1：用户输入0，期望输出success
	 * 测试2：用户输入1，期望输出fail
	 * 测试1：用户输入2，期望输出success
	 * 测试2：用户输入3，期望输出fail
	 * @author tanfan 
	 * @param args 
	 * @since JDK 1.7
	 */
	public static void main(String[] args) throws Exception {
		RuleEngine engine = RuleEngineFactory.newInstance().getRuleEngine();
		
		/** 模拟用户的输入 start **/
		Parameter inputParam = new Parameter();
		inputParam.setName("number");
		inputParam.setCnName("数字");
		inputParam.setType(TypeEnum.Long);
		inputParam.setValue("0");
		/** 用户的输入 end **/
		
		/** 需要满足的条件  start **/
		Operation operation = new Operation();
		operation.setOperator(Operator.Eq);
		operation.setParam(inputParam);
		//operation.setCriticalValue();
		/** 需要满足的条件  end **/
		
		Rule rule = new Rule();
		rule.setInputParams(Arrays.asList(inputParam));
		rule.setName("第五个规则例子");
		rule.setCreateDate(new Date());
		rule.setOperation(operation);
		rule.setOutputType(TypeEnum.String);
		rule.setFalseValue("fail");
		rule.setTrueValue("success");
		
		Object strResult = engine.loadRule(rule).execute();
		System.out.println("the result is "+strResult);
		System.out.println("the rule info is "+ rule);
	}
	
}
