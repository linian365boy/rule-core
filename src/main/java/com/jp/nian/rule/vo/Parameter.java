package com.jp.nian.rule.vo;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @ClassName: Parameter  
 * @Description: 用户输入的参数 
 * @date: 2017年7月26日 上午11:44:17 
 * 
 * @author tanfan 
 * @version  
 * @since JDK 1.7
 */
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
	private TypeEnum type;
	/**
	 * 参数中文描述
	 */
	private String cnName;
	/**
	 * 参数值
	 */
	private String value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum type) {
		this.type = type;
	}
	public String getCnName() {
		return cnName;
	}
	public void setCnName(String cnName) {
		this.cnName = cnName;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
