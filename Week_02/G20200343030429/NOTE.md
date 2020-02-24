#学习笔记
## 一、递归四步：
    1. recursion terminator 
    递归终结条件
    2. process logic in current level
    处理当前层逻辑
    3. drill down
    下探到下一层
    4. restore current status
    清理当前层（有时不需要）
    
    public void recursion(int level, int param) {
        // 递归终结条件
        if (level > MAX_VALUE) {
        
            return;    
        }
        
        // 处理当前层逻辑
        process(level, param);
        // 下探到下一层
        recursion(level : level + 1, newParam);
        // 清理
    }
## 二、思维要点
    1. 不要人肉进行递归（最大误区）
    2. 找到最近最简的方法，将其拆解成可重复解决的问题（重复子问题）
    3. 数学归纳法思维
