/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function (bills) {
  let five = 0, ten = 0
  for (let i = 0, len = bills.length; i < len; i++) {
    if (bills[i] === 5) {
      five++
    } else if (bills[i] === 10) {
      if (!five) {
        return false
      } else {
        five--
        ten++
      }
    } else {
      if (ten > 0 && five > 0) {
        five--
        ten--
      } else if (five >= 3) {
        five -= 3
      } else {
        return false
      }
    }
  }
  return true
}
