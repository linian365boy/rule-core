package com.jp.nian.rule.vo;

import java.io.Serializable;
import java.util.Date;

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
	private Parameter inputParam;
	//出参
	private Parameter outputParam;
	
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
	public Parameter getInputParam() {
		return inputParam;
	}
	public void setInputParam(Parameter inputParam) {
		this.inputParam = inputParam;
	}
	public Parameter getOutputParam() {
		return outputParam;
	}
	public void setOutputParam(Parameter outputParam) {
		this.outputParam = outputParam;
	}
}
