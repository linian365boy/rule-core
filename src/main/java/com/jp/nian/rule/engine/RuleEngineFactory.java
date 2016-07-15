package com.jp.nian.rule.engine;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @ClassName: RuleEngineFactory  
 * @Description: 静态内部类实现单例工厂 
 * @date: 2016年7月6日 下午5:58:34 
 * 
 * @author tanfan 
 * @version  
 * @since JDK 1.7
 */
public class RuleEngineFactory implements Serializable {
	/** 
	 * serialVersionUID:序列化
	 * @since JDK 1.7 
	 */ 
	private static final long serialVersionUID = -9014631908354445743L;
	
	private RuleEngineFactory(){}
	
	//静态内部类
	private static class RuleEngineFactoryInner{
		private static RuleEngineFactory instance = new RuleEngineFactory();
	}
	
	public static RuleEngineFactory newInstance() {
		return RuleEngineFactoryInner.instance;
	}

	public RuleEngine getRuleEngine() {
		return new DefaultRuleEngine();
	}
	
	/**
    * 反序列化单例需要 ,在反序列化时会被调用，若不加此方法 则反序列化的类不是单例的
    */
	private Object readResolve() throws ObjectStreamException {
		return newInstance();
    }
}
