package com.jp.nian.rule.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
	private List<Parameter> inputParam;
	//出参
	private Object outputParam;
	/**
	 * 运算
	 */
	private List<Operation> operations;
	
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
	public List<Parameter> getInputParam() {
		return inputParam;
	}
	public void setInputParam(List<Parameter> inputParam) {
		this.inputParam = inputParam;
	}
	public Object getOutputParam() {
		return outputParam;
	}
	public void setOutputParam(Object outputParam) {
		this.outputParam = outputParam;
	}
	
	public List<Operation> getOperations() {
		return operations;
	}
	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
