package com.jp.nian.rule.engine;

import java.util.Arrays;
import java.util.Date;

import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Operator;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;

public class RuleTest2 {
	
	/**
	 * main:有规则
	 * 如果用户输入名称为tanfan或者niange或者呵呵，则返回success，否则返回fail。
	 * 测试1：用户输入nima，期望输出fail
	 * 测试2：用户输入tanfan，期望输出success
	 * 测试3：用户输入niange，期望输出success
	 * 测试4：用户输入呵呵，期望输出success
	 * 测试5：用户输入呵呵da，期望输出fail
	 * @author tanfan 
	 * @param args 
	 * @since JDK 1.7
	 */
	public static void main(String[] args) throws Exception {
		RuleEngine engine = RuleEngineFactory.newInstance().getRuleEngine();
		Parameter inputParam = new Parameter();
		inputParam.setName("name");
		inputParam.setCnName("名称");
		inputParam.setType("java.lang.String");
		inputParam.setValue("呵呵da");
		
		Rule rule = new Rule();
		rule.setInputParams(Arrays.asList(inputParam));
		rule.setName("第二个规则例子");
		rule.setCreateDate(new Date());
		
		
		Operation operation = new Operation();
		operation.setOperator(Operator.Eq);
		operation.setParam(inputParam);
		operation.setCriticalValue("tanfan");
		
		Operation operation2 = new Operation();
		operation2.setOperator(Operator.Eq);
		operation2.setParam(inputParam);
		operation2.setCriticalValue("niange");
		
		Operation operation3 = new Operation();
		operation3.setOperator(Operator.Eq);
		operation3.setParam(inputParam);
		operation3.setCriticalValue("呵呵");
		
		//rule.setOperations(Arrays.asList(operation,operation2,operation3));
		rule.setOperation(operation).or(operation2).or(operation3);
		
		rule.setOutputType("java.lang.String");
		rule.setFalseValue("fail");
		rule.setTrueValue("success");
		
		Object strResult = engine.loadRule(rule).execute();
		System.out.println("the result is "+strResult);
	}
	
}
