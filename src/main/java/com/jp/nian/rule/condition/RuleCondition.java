package com.jp.nian.rule.condition;

import java.util.ArrayList;
import java.util.List;

import com.jp.nian.rule.vo.Operation;
import com.jp.nian.rule.vo.Operator;

/**
 * @ClassName: RuleCondition  
 * @Description: 组合规则引擎的多条件，（或、与） 
 * @date: 2017年7月26日 下午6:34:57 
 * 
 * @author tanfan 
 * @version  
 * @since JDK 1.7
 */
public class RuleCondition {
	/**
	 * 数组List存放运算
	 */
	private List<Operation> operations = new ArrayList<>();
	
	/**
	 * and:构造and节点
	 * @author tanfan 
	 * @param operation
	 * @return 
	 * @since JDK 1.7
	 */
	public RuleCondition and(Operation operation) {
		if(operations.size() > 0){
			Operation lastOperation = operations.get(operations.size()-1);
			lastOperation.setNextOperator(Operator.And);
			lastOperation.setNextOperation(operation);
		}
		operations.add(operation);
		return this;
	}
	
	/**
	 * and:构造or节点
	 * @author tanfan 
	 * @param operation
	 * @return 
	 * @since JDK 1.7
	 */
	public RuleCondition or(Operation operation) {
		Operation lastOperation = operations.get(operations.size()-1);
		lastOperation.setNextOperator(Operator.Or);
		lastOperation.setNextOperation(operation);
		operations.add(operation);
		return this;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}
