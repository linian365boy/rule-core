package com.jp.nian.rule.vo;

/**
 * @ClassName: TypeEnum  
 * @Description: 类型枚举 
 * @date: 2017年7月28日 下午12:51:17 
 * 
 * @author tanfan 
 * @version  
 * @since JDK 1.7
 */
public enum TypeEnum {
	
	Long("long","长整形"),
	Double("double","浮点型"),
	String("string","字符串"),
	Date("date","日期");
	
	private String typeName;
	private String comment;
	
	private TypeEnum(String typeName, String comment){
		this.typeName = typeName;
		this.comment = comment;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
