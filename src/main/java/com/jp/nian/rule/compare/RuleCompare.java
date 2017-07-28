package com.jp.nian.rule.compare;

import java.util.Comparator;

public class RuleCompare<T> implements Comparator<T> {

	@Override
	public int compare(T t1, T t2) {
		if(t1==t2) return 0;
		if(t1 instanceof Long){
			Long l1 = (Long)t1;
			Long l2 = (Long)t2;
			return Long.compare(l1, l2);
		}else if(t1 instanceof String){
			String s1 = (String)t1;
			String s2 = (String)t2;
			return s1.compareTo(s2);
		}else if(t1 instanceof Double){
			Double d1 = (Double)t1;
			Double d2 = (Double)t2;
			return Double.compare(d1, d2);
		}
		return 0;
	}
	
}
