package com.jp.nian.rule.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.jp.nian.rule.condition.RuleCondition;

public class Rule implements Serializable {
	/** 
	 * serialVersionUID:序列化
	 * @since JDK 1.7 
	 */ 
	private static final long serialVersionUID = 9086287116677139111L;
	//规则名称
	private String name;
	//规则创建日期
	private Date createDate;
	//入参
	private List<Parameter> inputParams;
	//实际出参类型
	private String OutputType;
	/**
	 * True分支的结果
	 */
	private String trueValue;
	/**
	 * False分支的结果
	 */
	private String falseValue;
	/**
	 * 规则条件组合
	 */
	private RuleCondition condition = new RuleCondition();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<Parameter> getInputParams() {
		return inputParams;
	}
	public void setInputParams(List<Parameter> inputParams) {
		this.inputParams = inputParams;
	}
	public String getOutputType() {
		return OutputType;
	}
	public void setOutputType(String outputType) {
		OutputType = outputType;
	}
	public String getTrueValue() {
		return trueValue;
	}
	public void setTrueValue(String trueValue) {
		this.trueValue = trueValue;
	}
	public String getFalseValue() {
		return falseValue;
	}
	public void setFalseValue(String falseValue) {
		this.falseValue = falseValue;
	}
	
	public RuleCondition getCondition() {
		return condition;
	}
	public void setCondition(RuleCondition condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
	public RuleCondition setOperation(Operation operation) {
		//设置第一个条件
		return condition.and(operation);
	}
	
}
