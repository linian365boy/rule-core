package com.jp.nian.rule.engine;

import com.jp.nian.rule.vo.Rule;

/**
 * @ClassName: RuleEngine  
 * @Description: 抽象规则引擎 
 * @date: 2016年7月6日 下午2:22:40 
 * 
 * @author tanfan 
 * @version  
 * @since JDK 1.7
 */
public abstract class RuleEngine {
	/**
	 * loadRule:加载规则 
	 * @author tanfan 
	 * @param oper 
	 * @since JDK 1.7
	 */
	public abstract RuleEngine loadRule(Rule rule);
	/**
	 * execute:根据条件执行规则
	 * @author tanfan  
	 * @param <T>
	 * @since JDK 1.7
	 * @return T 返回值
	 */
	public abstract Object execute() throws Exception;
}
