// Valid Parentheses

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

//    1. Open brackets must be closed by the same type of brackets.
//    2. Open brackets must be closed in the correct order.

// Note that an empty string is also considered valid.

// 思路：
// 1.先写一个object，把左右两种一一对应。
// 2.建立一个stack
// 3.先把左半边的传进stack
// 4.如果遇到右半边的，取出stack的数与之比对，如果是一样的，继续往后轮
// 5.如果不一样，直接return false

var isValid = function(s) {
    const paren = {
        '(': ')',
        '{': '}',
        '[': ']'
    }
    var stack = [];
    for (let i = 0; i <= s.length - 1; i++) {
        //先把左半边的都存入stack里
        if (s.charAt(i) in paren) {
            // 注意in 和 of的区别
            stack.push(s.charAt(i));
        } else {
            // 如果此时的s.charAt(i)是右半边，那么取出最近的stack里的数，与
            // s.charAt(i)比对，看是不是一对，是的话，继续比对下一个，不是的话return false
            var key = stack.pop();
            if (s.charAt(i) === paren[key]) {
                continue;
            } else {
                return false;
            }
        }
    }
    //最后stack里面所有的都被pop了，那就是对的了
    if (stack.length === 0) {
        return true;
    } else {
        return false;
    }
};