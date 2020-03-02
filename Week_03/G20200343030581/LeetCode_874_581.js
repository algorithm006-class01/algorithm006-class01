/*
 * @lc app=leetcode.cn id=874 lang=javascript
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
/**
 * @param {number[]} commands
 * @param {number[][]} obstacles
 * @return {number}
 */
var robotSim = function(commands, obstacles) {
    let dx = [0, 1, 0, -1],
        dy = [1, 0, -1, 0],
        dir = 0,
        x = 0,
        y = 0;
    
    let set = new Set();
    obstacles.forEach(e => set.add(e.join(',')));
    
    let res = 0;

    for (let cmd of commands) {
        if (cmd == '-2')
            dir = (dir + 3) % 4;
        else if (cmd == '-1')
            dir = (dir + 1) % 4;
        else {
            for (let step = 1; step <= cmd; step++) {
                let nx = x + dx[dir];
                let ny = y + dy[dir];
                if (set.has(nx + ',' + ny)) {
                    break;
                } else {
                    x = nx, y = ny;
                    res = Math.max(res, x * x + y * y);
                }
            }
        }
    }

    return res
};
// @lc code=end


