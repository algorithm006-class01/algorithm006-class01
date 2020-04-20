class Solution {
    /*
     * 解决方案：参数方程
     *         线段1: x = x1 + t1(x2-x1)
     *                y = y1 + t1(y2-y1)   0<=t1<=1
     *         线段2: x = x3 + t2(x4-x3)
     *                y = y3 + t2(y4-y3)   0<=t2<=1
     * 
     * 判断两线段是否平行：(y2-y1)/(x2-x1) == (y4-y3)/(x4-x3) 
     *               即 (x4-x3)(y2-y1) == (y4-y3)(x2-x1)
     *      1.平行，判断两线段在一条直线上：(y2-y1)/(x2-x1) == (y3-y1)/(x3-x1)
     *        1.1 在一条直线上，判断在不在线段上
     *          1.1.1 线段有重叠，选X值最小的点
     *          1.1.2 线段没有重叠，没有交点，返回空值
     *        1.2 不在一条直线上，没有交点，返回空值
     *      2.不平行
     *        2.1 两线段有交点，返回交点
     *        2.2 没有交点，返回空值
     *
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    public double[] intersection1(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0], y1 = start1[1], x2 = end1[0], y2 = end1[1]; // 线段1两端点
        int x3 = start2[0], y3 = start2[1], x4 = end2[0], y4 = end2[1]; // 线段2两端点

        double[] ans = new double[2];
        Arrays.fill(ans, Double.MAX_VALUE);
        if ((y2 - y1) * (x4 - x3) == (y4 - y3) * (x2 - x1)) { // 判断两线段所在直线是否平行
            if ((y3 - y1) * (x2 - x1) == (y2 - y1) * (x3 - x1)) { // 判断两线段是否在一条直线上，等价于判断(x3, y3)是否在线段1上
                // 判断两线段是否有重叠，依次测试四个端点是不是在另外的线段上，选目标点
                if (inside(x1, y1, x2, y2, x3, y3)) update(ans, (double) x3, (double) y3);
                if (inside(x1, y1, x2, y2, x4, y4)) update(ans, (double) x4, (double) y4);
                if (inside(x3, y3, x4, y4, x1, y1)) update(ans, (double) x1, (double) y1);
                if (inside(x3, y3, x4, y4, x2, y2)) update(ans, (double) x1, (double) y1);
            }
        } else { // 两线段所在直线不平行
            // 连立方程，求解t1和t2
            double t1 = (double) (x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3))
                    / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double) (x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1))
                    / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            // 判断两线段是否有交点，等价于“判断t1和t2是否均在[0,1]之间”
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                ans[0] = x1 + t1 * (x2 - x1);
                ans[1] = y1 + t1 * (y2 - y1);
            }
        }
        return ans[0] == Double.MAX_VALUE ? new double[0] : ans;
    }

    // 判断 (x, y) 是否在「线段」(x1, y1)~(x2, y2) 上
    // 这里的前提是 (x, y) 一定在「直线」(x1, y1)~(x2, y2) 上
    private boolean inside(int x1, int y1, int x2, int y2, int x, int y) {
        // 若与 x 轴平行，只需要判断 x 的部分
        // 若与 y 轴平行，只需要判断 y 的部分
        // 若为普通线段，则都要判断
        return (x1 == x2 || (Math.min(x1, x2) <= x && x <= Math.max(x1, x2)))
                && (y1 == y2 || (Math.min(y1, y2) <= y && y <= Math.max(y1, y2)));
    }

    private void update(double[] ans, double x, double y) {
        if (x < ans[0] || (x == ans[0] && y < ans[1])) {
            ans[0] = x;
            ans[1] = y;
        }
    }

    /*
     * 解决方案：叉积法
     *      基础知识：
     *           1. 向量叉积的模：对于向量a(x1, y1)和b(x2, y2)，|a x b| = |a||b|sin(a,b) = x1y2 - x2y1
     *               1.1 叉积的模>0，说明向量a逆时针旋转可以与b共线
     *               1.2 叉积的模<0，说明向量a顺时针旋转可以与b共线
     *               1.3 叉积的模=0，说明向量a和b已经共线
     *           2. 三角形面积：S = |AB x AC| / 2，sin(a, b)相当于把一个向量投影成另一个向量为底边的高；
     *           3. 定比分点：若P(x, y)在线段AB上，A(x1, y1)、B(x2, y2),AP和BP的长度之比为λ
     *               x = (x1 + λx2)/(1 + λ)
     *               y = (y1 + λy2)/(1 + λ)
     *       
     *       解决步骤：
     *           1. 如果线段1和线段2在同一条直线上：使用向量共线来判断
     *               1.1 判断两线段是否重叠，选择四个端点中“解”端点
     *           2. 如果线段1和线段2相交
     *               2.1 计算三角形面积比
     *               2.2 计算定比分点（即线段交点）
     *           3. 其他情况，返回空值
     *
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int ax = start1[0], ay = start1[1], bx = end1[0], by = end1[1]; // 线段1两端点
        int cx = start2[0], cy = start2[1], dx = end2[0], dy = end2[1]; // 线段2两端点
        int abx = bx - ax, aby = by - ay, acx = cx - ax, acy = cy - ay, adx = dx - ax, ady = dy - ay;
        int cax = ax - cx, cay = ay - cy, cbx = bx - cx, cby = by - cy, cdx = dx - cx, cdy = dy - cy;

        double[] ans = new double[2];
        Arrays.fill(ans, Double.MAX_VALUE);
        // 两线段ab和cd在同一条直线上， 等价于“ca与cb共线，且ad与ab共线”
        if (cross(cax, cay, cbx, cby) == 0 && cross(adx, ady, abx, aby) == 0) {
            // 判断两线段是否有重叠，依次测试四个端点是不是在另外的线段上，选目标点
            if (bothSide(ax, ay, bx, by, cx, cy)) update(ans, (double) cx, (double) cy);
            if (bothSide(ax, ay, bx, by, dx, dy)) update(ans, (double) dx, (double) dy);
            if (bothSide(cx, cy, dx, dy, ax, ay)) update(ans, (double) ax, (double) ay);
            if (bothSide(cx, cy, dx, dy, bx, by)) update(ans, (double) bx, (double) by);
        } else if (cross(acx, acy, abx, aby) * cross(adx, ady, abx, aby) <= 0
                && cross(cax, cay, cdx, cdy) * cross(cbx, cby, cdx, cdy) <= 0) {
            // 线段ab与cd相交，等价于“c和d点在ab直线的不同侧，a和b点在cd直线的不同侧”
            // 计算三角形abc和abd面积，及面积比
            double ck = getArea(ax, ay, bx, by, cx, cy), dk = getArea(ax, ay, bx, by, dx, dy);
            double k = ck / dk;
            // 计算定比分点
            ans[0] = (cx + k * dx) / (1 + k);
            ans[1] = (cy + k * dy) / (1 + k);
        }

        return ans[0] == Double.MAX_VALUE ? new double[0] : ans;
    }

    // 叉积运算
    private double cross(int ux, int uy, int vx, int vy) {
        return ux * vy - vx * uy;
    }

    // 计算PQM三角形的面积
    private double getArea(int px, int py, int qx, int qy, int mx, int my) {
        int mpx = px - mx, mpy = py - my, mqx = qx - mx, mqy = qy - my;
        return Math.abs(0.5 * cross(mpx, mpy, mqx, mqy));
    }

    // 判断线段UV (ux, uy)--(vx, vy) 是否包含(mx, my)，U点和V点是否在M点的不同侧bothside
    private boolean bothSide(int ux, int uy, int vx, int vy, int mx, int my) {
        return (ux - mx) * (vx - mx) <= 0 && (uy - my) * (vy - my) <= 0;
    }
}