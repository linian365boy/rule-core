# Java 规则引擎 实现
> 规则引擎，纯属兴趣研究

###### @TODO，目标
- 规则可以动态新增、修改，落地于DB
- 规则包括用户的多个输入参数、运算符、运算（条件）

###### @DONE 测试类在src/test/java下
- 目前完成条件测试----如果用户输入名称为tanfan，则返回success，否则返回fail。					
   - RuleTest1.java
- 目前完成条件测试----如果用户输入名称为tanfan或者niange或者呵呵，则返回success，否则返回fail。	
   - RuleTest2.java
- 目前完成条件测试----如果用户输入名称为tanfan，并且年龄为20，则返回success，否则返回fail。		
   - RuleTest3.java
- 目前完成条件测试----如果用户输入名称为tanfan，并且年龄小于20，则返回success，否则返回fail。		
   - RuleTest4.java
- 目前完成条件测试----如果用户输入名称输入偶数时，则返回success，否则返回fail。					
   - RuleTest5.java
- 目前完成条件测试----如果用户输入第一个数与第二个数相加等于5，则返回success，否则返回fail。			
   - RuleTest6.java
- 目前完成条件测试----如果用户购买商品满100元，那么商品价格打9折，否则不打折。						
   - RuleTest7.java
- 目前完成条件测试----如果用户购买的商品满100元，那么打9折；满150，打8.5折，满200以上打8折 		
   - RuleTest8.java
- 目前完成条件测试----如果用户购买的商品满80，减5；满130减8；满170以上减10				
   - RuleTest9.java
- 目前完成条件测试----如果用户购买的商品满300，则赠品一个；满500，赠品两个	
   - RuleTest10.java

###### @DOING 测试类在src/test/java下
- 如果用户购买的商品满300，则赠品一个；满500，赠品两个

###### @TODO，还可以继续完善的条件（实际生活中的例子，电商活动经常有的）
- 如果用户购买的商品满100元，那么打9折；满150，打8.5折，满200以上打8折 	（满折）
- 如果用户购买的商品满80，减5；满130减8；满170以上减10				（满减）
- 如果用户购买的商品满300，则赠品一个；满500，赠品两个					（满赠）
- 以上活动满足条件可以同时参与
- 支持规则存放在DB
- 支持从DB/文件获取规则

###### 规则引擎构思图：
![规则引擎构思](https://github.com/linian365boy/rule-core/blob/master/src/main/resources/%E8%A7%84%E5%88%99%E5%BC%95%E6%93%8E%E6%9E%84%E6%80%9D.png)
![规则引擎设计](https://github.com/linian365boy/rule-core/blob/master/src/main/resources/%E8%A7%84%E5%88%99%E5%BC%95%E6%93%8E%E8%AE%BE%E8%AE%A1.png)
--- 
