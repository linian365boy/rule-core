package com.jp.nian.rule.engine;

import java.util.Arrays;
import java.util.Date;
import com.jp.nian.rule.vo.CriticalConditionEnum;
import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;
import com.jp.nian.rule.vo.TypeEnum;

public class RuleTest8 {
	
	/**
	 * main:有规则
	 * 如果用户购买的商品满100元，那么打9折；满150，打8.5折，满200以上打8折。
	 * 测试1：购买商品110元，期望输出110*90%
	 * 测试2：用户输入190元，期望输出190*85%
	 * 测试3：用户输入200元，期望输出200*80%
	 * 测试4：用户输入80元，期望输出80
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
		inputParam.setValue("99");
		/** 用户的输入 end **/
		
		/** 需要满足的运算条件  start **/
		Operation operation = new Operation();
		operation.setCriticalType(CriticalConditionEnum.Operation);
		operation.setCriticalOperation(Double.parseDouble(inputParam.getValue())>=100);
		operation.setPriority(1);
		operation.setExpectVal(String.valueOf(Double.parseDouble(inputParam.getValue())*0.9));
		
		Operation operation2 = new Operation();
		operation2.setCriticalType(CriticalConditionEnum.Operation);
		operation2.setCriticalOperation(Double.parseDouble(inputParam.getValue())>=150);
		operation2.setPriority(2);
		operation2.setExpectVal(String.valueOf(Double.parseDouble(inputParam.getValue())*0.85));
		
		Operation operation3 = new Operation();
		operation3.setCriticalType(CriticalConditionEnum.Operation);
		operation3.setCriticalOperation(Double.parseDouble(inputParam.getValue())>=200);
		operation3.setPriority(3);
		operation3.setExpectVal(String.valueOf(Double.parseDouble(inputParam.getValue())*0.8));
		/** 需要满足的条件  end **/
		
		Rule rule = new Rule();
		rule.setInputParams(Arrays.asList(inputParam));
		rule.setName("第八个规则例子");
		rule.setCreateDate(new Date());
		/** 需要根据前端输入的优先值，进行先后顺序绑定，高优先值，放在第一个 **/
		rule.setOperation(operation3).exclude(operation2).exclude(operation);
		rule.setOutputType(TypeEnum.Double);
		/** 设置不满足条件返回值  **/
		rule.setFalseValue(String.valueOf(Double.parseDouble(inputParam.getValue())));
		/** 设置满足条件返回值  **/
		//rule.setTrueValue(String.valueOf(Double.parseDouble(inputParam.getValue())*0.9));
		
		Object strResult = engine.loadRule(rule).execute();
		System.out.println("the result is "+strResult);
		System.out.println("the rule info is "+ rule);
	}
	
}
