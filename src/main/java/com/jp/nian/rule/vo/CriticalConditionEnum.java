package com.jp.nian.rule.vo;

public enum CriticalConditionEnum {
	
	Operation("operation","运算"),
	Equal("equal","默认的临界条件");
	
	private String name;
	private String comment;
	
	private CriticalConditionEnum(String name, String comment){
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
