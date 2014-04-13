UniversalWebCrawler
==========

   1、读取xml
   2、读取website的name属性，获取当前网站名称
   3、读取所有step，其子节点放入Array，对于每个节点
       1.提取nodename，判断是什么操作
       2.然后根据节点名称获取后面的参数
       操作+参数 作为数组元素，按照step顺序放入一个Array
   4、爬虫接收上面的Array，依次执行各步骤
       1.创建全局WebClient，方便所有步骤使用
       2.针对每个步骤，调用Motion中的对应类执行