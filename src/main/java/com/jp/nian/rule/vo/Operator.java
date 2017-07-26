package com.jp.nian.rule.vo;

/**
 * @ClassName: Operation  
 * @Description: 规则之间需要用到的一些运算符
 * @date: 2016年7月8日 上午10:22:53 
 * 
 * @author tanfan 
 * @version  
 * @since JDK 1.7
 */
public enum Operator {
	
	Eq("eq","="),
	GreaterThan("greaterThan",">"),
	LessThan("lessThan","<"),
	GreaterThanEq("greaterThanEq",">="),
	LessThanEq("lessThanEq","<=");
	
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 备注
	 */
	private String comment;
	
	private Operator(String name, String comment){
		this.name = name;
		this.comment = comment;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
