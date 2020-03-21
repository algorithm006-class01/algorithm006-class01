// 回溯+不重复
var climbStairs = function(n) {
    var memory = {};
    return recursion(n);

    function recursion(step) {
        if (step<=2) return step;

        if (memory[step]) {
            return memory[step];
        }

        var currentSteps = recursion(step - 1) + recursion(step - 2);
        memory[step] = currentSteps;
        return currentSteps;
    }
};