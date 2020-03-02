学习笔记

本周时间学习时间有限, 没有太多总结, 后面会不上
分治代码模板
def divide_conquer(problem, param1, param2, ...): 
  # 处理结束递归方法
  if problem is None: 
	print_result 
	return 

  # 准备数据
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # 执行子问题
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # 生成最终结果
  result = process_result(subresult1, subresult2, subresult3, …)

  # 重置当前状态
