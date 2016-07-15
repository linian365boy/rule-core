package com.jp.nian.rule.engine;

import com.jp.nian.rule.vo.Operation;

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
	public abstract void setOperation(Operation oper);
	public abstract void execute();
}
