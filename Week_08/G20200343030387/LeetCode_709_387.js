/**
 * @param {string} str
 * @return {string}
 */
var toLowerCase = function (str) {
    //return str.toLowerCase()
    let res = ''
    for (let i = 0; i < str.length; i++) {
        const charCode = str[i].charCodeAt()
        if (charCode >= 65 && charCode <= 90) {
            res += String.fromCharCode(charCode + 32)
        } else {
            res += str[i]
        }
    }
    return res
};