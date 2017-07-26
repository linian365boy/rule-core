package com.jp.nian.rule.engine;

import java.util.Arrays;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;

public class MainTest {
	
	public static void main(String[] args) {
		RuleEngine engine = RuleEngineFactory.newInstance().getRuleEngine();
		Parameter inputParam = new Parameter();
		inputParam.setName("name");
		inputParam.setCnName("名称");
		inputParam.setType("java.lang.String");
		
		Parameter outputParam = new Parameter();
		outputParam.setName("result");
		outputParam.setCnName("结果");
		outputParam.setType("java.lang.String");
		
		Rule rule = new Rule();
		rule.setInputParam(Arrays.asList(inputParam));
		rule.setOutputParam(outputParam);
		rule.setName("第一个规则例子");
		
		//Operator oper = new Operator();
		//engine.setOperation(oper);
	}
	
}
