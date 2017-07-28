package com.jp.nian.rule.engine;

import java.util.Arrays;
import java.util.Date;

import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Operator;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;
import com.jp.nian.rule.vo.TypeEnum;

public class RuleTest4 {
	
	/**
	 * main:有规则
	 * 如果用户输入名称为tanfan，并且输入年龄小于20时，则返回success，否则返回fail。
	 * 测试1：用户输入nima，20，期望输出fail
	 * 测试2：用户输入tanfan，20，期望输出fail
	 * 测试3：用户输入nima，19，期望输出fail
	 * 测试4：用户输入tanfan，19，期望输出success
	 * @author tanfan 
	 * @param args 
	 * @since JDK 1.7
	 */
	public static void main(String[] args) throws Exception {
		RuleEngine engine = RuleEngineFactory.newInstance().getRuleEngine();
		
		/** 用户的输入 start **/
		Parameter inputParam = new Parameter();
		inputParam.setName("name");
		inputParam.setCnName("名称");
		inputParam.setType(TypeEnum.String);
		inputParam.setValue("tanfan");
		
		Parameter inputParam2 = new Parameter();
		inputParam2.setName("age");
		inputParam2.setCnName("年龄");
		inputParam2.setType(TypeEnum.Long);
		inputParam2.setValue("29");
		/** 用户的输入 end **/
		
		/** 需要满足的条件  start **/
		Operation operation = new Operation();
		operation.setOperator(Operator.Eq);
		operation.setParam(inputParam);
		operation.setCriticalValue("tanfan");
		
		Operation operation2 = new Operation();
		operation2.setOperator(Operator.LessThan);
		operation2.setParam(inputParam2);
		operation2.setCriticalValue("20");
		/** 需要满足的条件  end **/
		
		Rule rule = new Rule();
		rule.setInputParams(Arrays.asList(inputParam,inputParam2));
		rule.setName("第四个规则例子");
		rule.setCreateDate(new Date());
		rule.setOperation(operation).and(operation2);
		rule.setOutputType(TypeEnum.String);
		rule.setFalseValue("fail");
		rule.setTrueValue("success");
		
		Object strResult = engine.loadRule(rule).execute();
		System.out.println("the result is "+strResult);
		System.out.println("the rule info is "+ rule);
	}
	
}
