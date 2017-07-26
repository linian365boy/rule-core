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
	private Object criticalValue;
	
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

	public Object getCriticalValue() {
		return criticalValue;
	}

	public void setCriticalValue(Object criticalValue) {
		this.criticalValue = criticalValue;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
