package com.jp.nian.rule.vo;

import java.io.Serializable;

public class Parameter implements Serializable {
	/** 
	 * serialVersionUID:序列化
	 * @since JDK 1.7 
	 */ 
	private static final long serialVersionUID = -2996445759006867398L;
	/**
	 * 参数名称
	 */
	private String name;
	/**
	 * 参数类型
	 */
	private String type;
	/**
	 * 参数中文描述
	 */
	private String cnName;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
}
