package com.jp.nian.rule.engine;

import java.util.Arrays;
import java.util.Date;
import com.jp.nian.rule.vo.CriticalConditionEnum;
import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;
import com.jp.nian.rule.vo.TypeEnum;

public class RuleTest6 {
	
	/**
	 * main:有规则
	 * 如果用户输入第一个数与第二个数相加等于5，则返回success，否则返回fail。
	 * 测试1：用户输入0，1，期望输出fail
	 * 测试2：用户输入2，3，期望输出success
	 * 测试3：用户输入3，2，期望输出success
	 * 测试4：用户输入4，1，期望输出success
	 * 测试5：用户输入5，0，期望输出success
	 * 测试6：用户输入2，2，期望输出fail
	 * @author tanfan 
	 * @param args 
	 * @since JDK 1.7
	 */
	public static void main(String[] args) throws Exception {
		RuleEngine engine = RuleEngineFactory.newInstance().getRuleEngine();
		
		/** 模拟用户的输入 start **/
		Parameter inputParam = new Parameter();
		inputParam.setName("number1");
		inputParam.setCnName("数字1");
		inputParam.setType(TypeEnum.Long);
		inputParam.setValue("2");
		
		Parameter inputParam2 = new Parameter();
		inputParam2.setName("number2");
		inputParam2.setCnName("数字2");
		inputParam2.setType(TypeEnum.Long);
		inputParam2.setValue("3");
		/** 用户的输入 end **/
		
		/** 需要满足的条件  start **/
		Operation operation = new Operation();
		operation.setCriticalType(CriticalConditionEnum.Operation);
		operation.setCriticalOperation(Long.parseLong(inputParam.getValue())+Long.parseLong(inputParam2.getValue()) == 5);
		/** 需要满足的条件  end **/
		
		Rule rule = new Rule();
		rule.setInputParams(Arrays.asList(inputParam));
		rule.setName("第六个规则例子");
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
