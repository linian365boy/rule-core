package com.jp.nian.rule.engine;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.time.DateUtils;

import com.jp.nian.rule.compare.RuleCompare;
import com.jp.nian.rule.condition.RuleCondition;
import com.jp.nian.rule.context.Context;
import com.jp.nian.rule.vo.CriticalConditionEnum;
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
		Operation operation = compute(rule);
		if(operation != null){
			if(operation.getExpectVal() != null){
				return operation.getExpectVal();
			}else{
				return rule.getTrueValue();
			}
		}
		return rule.getFalseValue();
	}
	
	/**
	 * computeReturnOperation:返回符合条件的那个运算
	 * @author tanfan 
	 * @param rule
	 * @return
	 * @throws Exception 
	 * @since JDK 1.7
	 */
	private Operation compute(Rule rule) throws Exception {
		RuleCondition condition = rule.getCondition();
		List<Operation> operations = condition.getOperations();
		Operation resultOper = null;
		for(Operation oper : operations){
			boolean flag = compare(oper);
			if(flag){
				if(oper.getNextOperator() == Operator.And){
					continue;
				}else if(oper.getNextOperator() == Operator.Ex){
					resultOper = oper;
					break;
				}
			}else{
				if(oper.getNextOperator() == Operator.Or || 
						oper.getNextOperator() == Operator.Ex){
					continue;
				}
			}
			if(flag){
				resultOper = oper;
			}
			break;
		}
		return resultOper;
	}
	
	private boolean compare(Operation operation) throws Exception {
		Parameter param = operation.getParam();
		//临界值，真实类型，用作比较。比如年龄，应该是数值类型；姓名，应该是字符串类型。
		if(operation.getCriticalType() == CriticalConditionEnum.Operation){
			return operation.isCriticalOperation();
		}else{
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
