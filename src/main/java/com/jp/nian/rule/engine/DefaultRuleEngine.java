package com.jp.nian.rule.engine;

import java.util.List;

import com.jp.nian.rule.condition.RuleCondition;
import com.jp.nian.rule.context.Context;
import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Operator;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;

/**
 * @ClassName: DefaultRuleEngine  
 * @Description: 实现默认的规则引擎 
 * @date: 2016年7月6日 下午6:02:47 
 * 
 * @author tanfan 
 * @version  
 * @since JDK 1.7
 */
public class DefaultRuleEngine extends RuleEngine {
	public DefaultRuleEngine() {}
	
	@Override
	public Object execute() throws Exception {
		Rule rule = Context.getRule();
		//Class<?> clazz = Class.forName(rule.getOutputType());
		if(compute(rule)){
			return rule.getTrueValue();
		}else{
			return rule.getFalseValue();
		}
	}
	
	private boolean compute(Rule rule){
		List<Parameter> params = rule.getInputParams();
		for(Parameter param : params){
			String paramName = param.getName();
			String paramType = param.getType();
			String paramValue = param.getValue();
		}
		
		RuleCondition condition = rule.getCondition();
		List<Operation> operations = condition.getOperations();
		for(Operation oper : operations){
			boolean flag = compare(oper);
			if(flag){
				if(oper.getNextOperator() == Operator.And){
					continue;
				}
			}else{
				if(oper.getNextOperator() == Operator.Or){
					continue;
				}
			}
			return flag;
		}
		
		/*List<Operation> operations = rule.getOperations();
		for(Operation operation : operations){
			Parameter param = operation.getParam();
			Operator operator = operation.getOperator();
			Object value = operation.getCriticalValue();
			String valueStr = (String)value;
			switch(operator){
				case Eq: 
					return valueStr.equals(param.getValue());
				default: 
					return false;
			}
		}*/
		return false;
	}
	
	private boolean compare(Operation operation){
		Object value = operation.getCriticalValue();
		String valueStr = (String)value;
		Parameter param = operation.getParam();
		switch(operation.getOperator()){
			case Eq: 
				return valueStr.equals(param.getValue());
			default: 
				return false;
		}
	}

	@Override
	public RuleEngine loadRule(Rule rule) {
		Context.setRule(rule);
		return this;
	}

}
