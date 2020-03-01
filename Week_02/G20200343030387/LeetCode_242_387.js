var isAnagram = function(s, t) {
    if (s.length !== t.length) return false
    const counterArr = new Array(26).fill(0)
    const base = "a".charCodeAt()
    const buildCharIndex = function(char) {
        return char.charCodeAt() - base
    }
    for (let i = 0; i < s.length; i++) {
        counterArr[buildCharIndex(s.charAt(i))]++
        counterArr[buildCharIndex(t.charAt(i))]--
    }
    for (let key of counterArr) {
        if (counterArr[key] !== 0) return false
    }
    return true
}
