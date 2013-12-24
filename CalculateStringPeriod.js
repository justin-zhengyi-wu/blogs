function solution(str) {
    var result = -1, reg, left;
    for (var len = parseInt(str.length / 2); len > 0; len--) {
        reg = str.substring(0, len);
        left = str.substring(len);
        var valid = true;
        for (var startIndex = 0; startIndex <= left.length; startIndex += len) {
            var endIndex = startIndex + len;
            if (endIndex > left.length) {
                endIndex = left.length;
            }
            var fragment = left.substring(startIndex, endIndex);
            if (!(fragment.length <= reg.length && reg.indexOf(fragment) === 0)) {
                valid = false;
                break;
            }
        }
        if (valid) {
            result = reg.length;
        }
    }
    return result;
}

console.log(solution('ababababababababa'));
console.log(solution('abcdabcdabcd'));
console.log(solution('111111111111110000000000000011111111111111000000000000001111111111111100000000000000'));
console.log(solution('abcd1abcd2abcd'));
console.log(solution('javajavakljalksdfaskjavakaljkljjavaj'));
