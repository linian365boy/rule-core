package com.jp.nian.rule.engine;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.time.DateUtils;

import com.jp.nian.rule.compare.RuleCompare;
import com.jp.nian.rule.condition.RuleCondition;
import com.jp.nian.rule.context.Context;
import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Operator;
import com.jp.nian.rule.vo.Parameter;
import com.jp.nian.rule.vo.Rule;
import com.jp.nian.rule.vo.TypeEnum;

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
		if(compute(rule)){
			return rule.getTrueValue();
		}else{
			return rule.getFalseValue();
		}
	}
	
	private boolean compute(Rule rule) throws Exception {
		/*List<Parameter> params = rule.getInputParams();
		for(Parameter param : params){
			String paramName = param.getName();
			String paramType = param.getType();
			String paramValue = param.getValue();
			
		}*/
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
	
	private boolean compare(Operation operation) throws Exception {
		Parameter param = operation.getParam();
		//临界值，真实类型，用作比较。比如年龄，应该是数值类型；姓名，应该是字符串类型。
		Object value = getValue(param.getType(), operation.getCriticalValue());
		Object objVal = getValue(param.getType(), param.getValue());
		int result = Objects.compare(objVal, value, new RuleCompare<>());
		switch(operation.getOperator()){
			case Eq: 
				return result == 0;
			case GreaterThan:
				return result > 0;
			case LessThan:
				return result < 0;
			case GreaterThanEq:
				return result >= 0;
			case LessThanEq:
				return result <= 0;
			default: 
				return false;
		}
	}
	
	
	private Object getValue(TypeEnum type, String val) throws Exception {
		switch(type){	
			case Long: return Long.parseLong(val);
			case Double: return Double.parseDouble(val);
			case Date: return DateUtils.parseDate(val, "yyyy-MM-dd hh:mm:ss").getTime();
			default: return val;
		}
	}
	
	@Override
	public RuleEngine loadRule(Rule rule) {
		Context.setRule(rule);
		return this;
	}

}
