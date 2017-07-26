package com.jp.nian.rule.context;

import com.jp.nian.rule.vo.Rule;

/**
 * @ClassName: Context  
 * @Description: 模拟上下文 
 * @date: 2017年7月26日 下午3:00:42 
 * 
 * @author tanfan 
 * @version  
 * @since JDK 1.7
 */
public class Context {
	
	private static ThreadLocal<Rule> ruleLocal = new ThreadLocal<Rule>(){
		protected Rule initialValue() {
			return null;
		};
	};
	
	public static void setRule(Rule value){
		ruleLocal.set(value);
	}
	
	public static Rule getRule(){
		return ruleLocal.get();
	}
}
