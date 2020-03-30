/**
 * @param {number} n
 * @return {boolean}
 */
// var isPowerOfTwo = function(n) {
//     if (n === 0) return false
//     return (n & (n - 1)) === 0
// };
var isPowerOfTwo = function(n) {
  if (n <= 0) return false
  return (n & n - 1) === 0
};
