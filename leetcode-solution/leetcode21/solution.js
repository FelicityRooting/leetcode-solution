// Merge Two Sorted Lists
// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

// Example:

// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4

// 思路：
// 1. 建立一个array，把两个linkedlist里的数都push到里面
// 2. 给array排序后再把它还原成linkedlist

var mergeTwoLists = function(l1, l2) {
    var result = [];
    while (l1) {
        result.push(new ListNode(l1.val));
        l1 = l1.next;
    }
    while (l2) {
        result.push(new ListNode(l2.val));
        l2 = l2.next;
    }
    // If Function(a, b) is less than 0, sort a to an index lower than b, 
    // i.e. a comes first.
    // If Function(a, b) returns 0, leave a and b unchanged with respect to 
    // each other, but sorted with respect to all different elements. 
    result.sort(function(a, b) {
        return a.val - b.val;
    });
    if (result.length === 0) return null;
    for (var i = 0; i < result.length - 1; i++) {
        result[i].next = result[i + 1];   
    }
    return result[0];
};