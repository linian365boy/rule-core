package com.jp.nian.rule.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: Operation  
 * @Description: 运算，是需要包括运算符与参数的 
 * @date: 2017年7月26日 下午12:31:47 
 * 
 * @author tanfan 
 * @version  
 * @since JDK 1.7
 */
public class Operation {
	/**
	 * 参数
	 */
	private Parameter param;
	/**
	 * 运算符
	 */
	private Operator operator;
	/**
	 * 临界值，类型是param的参数类型
	 */
	private String criticalValue;
	/**
	 * 与下一个运算的运算符
	 */
	private Operator nextOperator;
	/**
	 * 下一个运算
	 */
	private Operation nextOperation;
	/**
	 * 临界运算
	 */
	private boolean criticalOperation;
	/**
	 * 临界的条件类型，默认是Equal
	 */
	private CriticalConditionEnum criticalType = CriticalConditionEnum.Equal;
	
	public Parameter getParam() {
		return param;
	}
	
	public void setParam(Parameter param) {
		this.param = param;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getCriticalValue() {
		return criticalValue;
	}

	public void setCriticalValue(String criticalValue) {
		this.criticalValue = criticalValue;
	}
	
	public Operator getNextOperator() {
		return nextOperator;
	}

	public void setNextOperator(Operator nextOperator) {
		this.nextOperator = nextOperator;
	}
	
	public void setNextOperation(Operation operation) {
		this.nextOperation = operation;
	}
	
	public Operation getNextOperation() {
		return nextOperation;
	}

	public boolean isCriticalOperation() {
		return criticalOperation;
	}

	public void setCriticalOperation(boolean criticalOperation) {
		this.criticalOperation = criticalOperation;
	}
	
	public CriticalConditionEnum getCriticalType() {
		return criticalType;
	}

	public void setCriticalType(CriticalConditionEnum criticalType) {
		this.criticalType = criticalType;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
