Table of Contents
=================

* [数据结构](#数据结构)
  * [数组](#数组)
  * [二叉树](#二叉树)
    * [递归](#递归)
    * [遍历](#遍历)
    * [重建](#重建)
    * [优先队列](#优先队列)
    * [二叉搜索树](#二叉搜索树)
    * [并查集](#并查集)
  * [链表](#链表)
  * [栈](#栈)
    * [计算器](#计算器)
    * [单调栈](#单调栈)
    * [单调队列](#单调队列)
  * [字典树](#字典树)
  * [哈希表](#哈希表)
  * [其他数据结构](#其他数据结构)
* [算法](#算法)
  * [动态规划](#动态规划)
    * [贪心](#贪心)
    * [序列问题](#序列问题)
      * [单一序列问题](#单一序列问题)
      * [双序列问题](#双序列问题)
    * [背包问题](#背包问题)
    * [股票问题](#股票问题)
    * [打家劫舍](#打家劫舍)
  * [二分搜索](#二分搜索)
  * [双指针](#双指针)
    * [快慢指针](#快慢指针)
    * [滑动窗口](#滑动窗口)
    * [左右指针](#左右指针)
  * [深搜回溯](#深搜回溯)
  * [广搜](#广搜)
  * [分治](#分治)
* [其他](#其他)
  * [找规律](#找规律)
  * [排序](#排序)
  * [水塘抽样](#水塘抽样)
  * [斐波那契](#斐波那契)
  * [位运算](#位运算)

Created by [gh-md-toc](https://github.com/ekalinin/github-markdown-toc.go)

# 数据结构
## 数组
原数组==[O(n)]==>前缀和数组==[O(1)]==>范围和==[O(n)]==>差分数组  
原数组<==[O(n)]==前缀和数组  
原数组<==[O(n)]==差分数组  
原数组<==[O(n^2)]==范围和

- [1109. Corporate Flight Bookings](src/main/java/com/wzx/leetcode/No1109CorporateFlightBookings.java): 差分数组
- [560. Subarray Sum Equals K](src/main/java/com/wzx/leetcode/No560SubarraySumEqualsK.java): 前缀和数组
- [380. Insert Delete GetRandom O(1)](src/main/java/com/wzx/leetcode/No380InsertDeleteGetRandomO1.java)
- [710. Random Pick with Blacklist](src/main/java/com/wzx/leetcode/No710RandomPickWithBlacklist.java)

符号位替代哈希表
- [offer3. 数组中的重复数字](src/main/java/com/wzx/sword/No3DuplicateNum.java)
- [448. Find All Numbers Disappeared in an Array](src/main/java/com/wzx/leetcode/No448FindAllNumbersDisappearedInAnArray.java)
- [645. Set Mismatch](src/main/java/com/wzx/leetcode/No645SetMismatch.java)

众数
- [offer39. 数组中出现次数超过一半的数字](src/main/java/com/wzx/sword/No39MoreThanHalfOfTheOccurrences.java)

## 二叉树
### 递归
- [572. Subtree of Another Tree](src/main/java/com/wzx/leetcode/No572SubtreeOfAnotherTree.java)
- [100. Same Tree](src/main/java/com/wzx/leetcode/No100SameTree.java)
- [226. Invert Binary Tree](src/main/java/com/wzx/leetcode/No226InvertBinaryTree.java)
- [654. Maximum Binary Tree](src/main/java/com/wzx/leetcode/No654MaximumBinaryTree.java)
- [114. Flatten Binary Tree to Linked List](src/main/java/com/wzx/leetcode/No114FlattenBinaryTreeToLinkedList.java)
- [110. Balanced Binary Tree](src/main/java/com/wzx/leetcode/No110BalancedBinaryTree.java)
- [112. Path Sum](src/main/java/com/wzx/leetcode/No112PathSum.java)
- [113. Path Sum II](src/main/java/com/wzx/leetcode/No113PathSum2.java)
- [104. Maximum Depth of Binary Tree](src/main/java/com/wzx/leetcode/No104MaximumDepthOfBinaryTree.java)
- [111. Minimum Depth of Binary Tree](src/main/java/com/wzx/leetcode/No111MinimumDepthOfBinaryTree.java)
- [222. Count Complete Tree Nodes](src/main/java/com/wzx/leetcode/No222CountCompleteTreeNodes.java)
- [101. Symmetric Tree](src/main/java/com/wzx/leetcode/No101SymmetricTree.java)
- [116. Populating Next Right Pointers in Each Node](src/main/java/com/wzx/leetcode/No116PopulatingNextRightPointersInEachNode.java)
- [236. Lowest Common Ancestor of a Binary Tree](src/main/java/com/wzx/leetcode/No236LowestCommonAncestorOfABinaryTree.java)
- [652. Find Duplicate Subtrees](src/main/java/com/wzx/leetcode/No652FindDuplicateSubtrees.java)

### 遍历

- [144. Binary Tree Preorder Traversal](src/main/java/com/wzx/leetcode/No144BinaryTreePreorderTraversal.java): [前序遍历](https://masterwangzx.com/2019/03/16/binary-tree/#前序遍历)
- [94. Binary Tree Inorder Traversal](src/main/java/com/wzx/leetcode/No94BinaryTreeInorderTraversal.java): [中序遍历](https://masterwangzx.com/2019/03/16/binary-tree/#中序遍历)
- [145. Binary Tree Postorder Traversal](src/main/java/com/wzx/leetcode/No145BinaryTreePostorderTraversal.java): [后序遍历](https://masterwangzx.com/2019/03/16/binary-tree/#后序遍历)
- [102. Binary Tree Level Order Traversal](src/main/java/com/wzx/leetcode/No102BinaryTreeLevelOrderTraversal.java): [层序遍历](https://masterwangzx.com/2019/03/16/binary-tree/#层序遍历)
- [offer8. 二叉树的下一个节点](src/main/java/com/wzx/sword/No8BinaryTreeNextNode.java)
- [offer32. 从上到下打印二叉树 III](src/main/java/com/wzx/leetcode/No32PrintTheBinaryTreeFromTopToBottom3.java)

### 重建
- [105. Construct Binary Tree from Preorder and Inorder Traversal](src/main/java/com/wzx/leetcode/No105ConstructBinaryTreeFromPreorderAndInorderTraversal.java): [先跟+中根](https://masterwangzx.com/2019/03/16/binary-tree/#%E5%85%88%E8%B7%9F%E4%B8%AD%E6%A0%B9)
- [106. Construct Binary Tree from Inorder and Postorder Traversal](src/main/java/com/wzx/leetcode/No106ConstructBinaryTreeFromInorderAndPostorderTraversal.java): [中根+后跟](https://masterwangzx.com/2019/03/16/binary-tree/#%E4%B8%AD%E6%A0%B9%E5%90%8E%E6%A0%B9)
- [889. Construct Binary Tree from Preorder and Postorder Traversal](src/main/java/com/wzx/leetcode/No889ConstructBinaryTreeFromPreorderAndPostorderTraversal.java): [先跟+后跟](https://masterwangzx.com/2019/03/16/binary-tree/#%E5%85%88%E6%A0%B9%E5%90%8E%E6%A0%B9)
- [offer37. 序列化二叉树](src/main/java/com/wzx/sword/No37SerializedBinaryTree.java)

### 优先队列
- [347. Top K Frequent Elements](src/main/java/com/wzx/leetcode/No347TopKFrequentElements.java): [最小堆](https://masterwangzx.com/2019/10/25/min-heap)
- [295. Find Median from Data Stream](src/main/java/com/wzx/leetcode/No295FindMedianFromDataStream.java)

### 二叉搜索树
- [98. Validate Binary Search Tree](src/main/java/com/wzx/leetcode/No98ValidateBinarySearchTree.java)
- [700. Search in a Binary Search Tree](src/main/java/com/wzx/leetcode/No700SearchInABinarySearchTree.java)
- [701. Insert into a Binary Search Tree](src/main/java/com/wzx/leetcode/No701InsertIntoABinarySearchTree.java)
- [450. Delete Node in a BST](src/main/java/com/wzx/leetcode/No450DeleteNodeInABST.java)
- [538. Convert BST to Greater Tree](src/main/java/com/wzx/leetcode/No538ConvertBSTToGreaterTree.java)
- [230. Kth Smallest Element in a BST](src/main/java/com/wzx/leetcode/No230KthSmallestElementInABST.java)
- [offer54. 二叉搜索树的第k大节点](src/main/java/com/wzx/sword/No54TheKLargestNodeOfTheBinarySearchTree.java)
- [offer33. 二叉搜索树的后序遍历序列](src/main/java/com/wzx/sword/No33PostOrderTraversalSequenceOfBinarySearchTree.java)
- [offer36. 二叉搜索树与双向链表](src/main/java/com/wzx/sword/No36BST2DoublyLinkedList.java)
- [offer68. 二叉搜索树的最近公共祖先](src/main/java/com/wzx/sword/No68NearestCommonAncestorOfBinarySearchTree.java)

### 并查集
- [130. Surrounded Regions](src/main/java/com/wzx/leetcode/No130SurroundedRegions.java)
- [990. Satisfiability of Equality Equations](src/main/java/com/wzx/leetcode/No990SatisfiabilityOfEqualityEquations.java)

## 链表
> PreviousNode, CurrentNode, NextNode, head, tail and sentinel nodes

- [234. Palindrome Linked List](src/main/java/com/wzx/leetcode/No234PalindromeLinkedList.java)
- [206. Reverse Linked List](src/main/java/com/wzx/leetcode/No206ReverseLinkedList.java)
- [92. Reverse Linked List II](src/main/java/com/wzx/leetcode/No92ReverseLinkedList2.java)
- [25. Reverse Nodes in k-Group](src/main/java/com/wzx/leetcode/No25ReverseNodesInKGroup.java)
- [141. LinkedListCycle](src/main/java/com/wzx/leetcode/No141LinkedListCycle.java)
- [142. LinkedListCycle2](src/main/java/com/wzx/leetcode/No142LinkedListCycle2.java)
- [2. AddTwoNumbers](src/main/java/com/wzx/leetcode/No2AddTwoNumbers.java)
- [21. MergeTwoSortedLists](src/main/java/com/wzx/leetcode/No21MergeTwoSortedLists.java)
- [61. RotateList](src/main/java/com/wzx/leetcode/No61RotateList.java)
- [138. CopyListWithRandomPointer](src/main/java/com/wzx/leetcode/No138CopyListWithRandomPointer.java)
- [160. IntersectionOfTwoLinkedLists](src/main/java/com/wzx/leetcode/No160IntersectionOfTwoLinkedLists.java)
- [430. FlattenAMultilevelDoublyLinkedList](src/main/java/com/wzx/leetcode/No430FlattenAMultilevelDoublyLinkedList.java)
- [707. DesignLinkedList](src/main/java/com/wzx/leetcode/No707DesignLinkedList.java)
- [offer6. 从尾到头打印链表](src/main/java/com/wzx/sword/No6PrintListNode.java)

## 栈
- [445. AddTwoNumbers2](src/main/java/com/wzx/leetcode/No445AddTwoNumbers2.java)
- [316. Remove Duplicate Letters](src/main/java/com/wzx/leetcode/No316RemoveDuplicateLetters.java)
- [20. Valid Parentheses](src/main/java/com/wzx/leetcode/No20ValidParentheses.java)
- [offer9. 用两个栈实现队列](src/main/java/com/wzx/sword/No9TwoStackImplementQueue.java)
- [offer31. 栈的压入、弹出序列](src/main/java/com/wzx/sword/No31StackSequence.java)

### 计算器
- [224. Basic Calculator](src/main/java/com/wzx/leetcode/No224BasicCalculator.java)
- [227. Basic Calculator II](src/main/java/com/wzx/leetcode/No227BasicCalculator2.java)
- [772. Basic Calculator III](src/main/java/com/wzx/leetcode/No772BasicCalculator3.java)

### 单调栈
> 从一个方向看数组，前方的元素会将后面的较小元素阻挡
> 
> 若从前往后看，却从后往前遍历，则需要记录下可以看到的元素到栈中，所以栈中的元素是单调的，就是单调栈
> 
> 每次新元素入栈后，不断弹出比新元素小(大)的栈顶元素

- [496. Next Greater Element I](src/main/java/com/wzx/leetcode/No496NextGreaterElement1.java)
- [503. Next Greater Element II](src/main/java/com/wzx/leetcode/No503NextGreaterElement2.java)
- [offer30. 包含min函数的栈](src/main/java/com/wzx/sword/No30MinStack.java)
- [739. Daily Temperatures](src/main/java/com/wzx/leetcode/No739DailyTemperatures.java)
- [456. 132 Pattern](src/main/java/com/wzx/leetcode/No456132Pattern.java)

### 单调队列
> 从一个方向看数组，前方的元素会将后面的较小元素阻挡
> 
> 若从后往前看，却从前往后遍历，则需要记录下可以看到的元素到队列中，所以栈中的元素是单调的，就是单调队列
> 
> 每次新元素入栈后，不断将比新元素小(大)的队尾元素出队

- [offer59. 滑动窗口的最大值](src/main/java/com/wzx/sword/No59MaximumSlidingWindow.java)
- [offer59. 队列的最大值](src/main/java/com/wzx/sword/No59MaximumValueOfTheQueue.java)

## 字典树
- [211. Design Add and Search Words Data Structure](src/main/java/com/wzx/leetcode/No211DesignAddAndSearchWordsDataStructure.java)

## 哈希表
- [offer50. 第一个只出现一次的字符](src/main/java/com/wzx/sword/No50TheFirstCharacterThatAppearsOnlyOnce.java)
- [offer39. 数组中出现次数超过一半的数字](src/main/java/com/wzx/sword/No39MoreThanHalfOfTheOccurrences.java)
- [1. tow sum](src/main/java/com/wzx/leetcode/No1TwoSum.java)
- [454. 4Sum II](src/main/java/com/wzx/leetcode/No454FourSum2.java)

## 其他数据结构
- [146. LRU Cache](src/main/java/com/wzx/leetcode/No146LRUCache.java)
- [460. LFU Cache](src/main/java/com/wzx/leetcode/No460LFUCache.java)
- [355. Design Twitter](src/main/java/com/wzx/leetcode/No355DesignTwitter.java)

# 算法

## 动态规划
> [动态规划](https://labuladong.gitbook.io/algo/di-ling-zhang-bi-du-xi-lie/dong-tai-gui-hua-xiang-jie-jin-jie)

- [offer46. 把数字翻译成字符串](src/main/java/com/wzx/sword/No46TranslateNumbersIntoStrings.java)
- [offer47. 礼物的最大值](src/main/java/com/wzx/sword/No47MaximumGift.java)
- [887. Super Egg Drop](src/main/java/com/wzx/leetcode/No887SuperEggDrop.java)
- [877. Stone Game](src/main/java/com/wzx/leetcode/No877StoneGame.java)
- [28. Implement strStr()](src/main/java/com/wzx/leetcode/No28ImplementStrStr.java): [字符串匹配算法](https://masterwangzx.com/2020/10/03/str-match/)
- [264. ugly number II](src/main/java/com/wzx/leetcode/No264UglyNumberII.java)
- [Offer60. n个骰子的点数](src/main/java/com/wzx/sword/No60NumberOfNDice.java)

### 贪心
- [offer14. 剪绳子](src/main/java/com/wzx/sword/No14CutTheRope.java)
- [53. maximum subarray](src/main/java/com/wzx/leetcode/No53MaximumSubarray.java)
- [55. Jump Game](src/main/java/com/wzx/leetcode/No55JumpGame.java)
- [45. Jump Game II](src/main/java/com/wzx/leetcode/No45JumpGameII.java)

区间问题
- [435. Non-overlapping Intervals](src/main/java/com/wzx/leetcode/No435NonOverlappingIntervals.java)
- [452. Minimum Number of Arrows to Burst Balloons](src/main/java/com/wzx/leetcode/No452MinimumNumberOfArrowsToBurstBalloons.java)
- [1288. Remove Covered Intervals](src/main/java/com/wzx/leetcode/No1288RemoveCoveredIntervals.java)
- [56. Merge Intervals](src/main/java/com/wzx/leetcode/No56MergeIntervals.java)
- [986. Interval List Intersections](src/main/java/com/wzx/leetcode/No986IntervalListIntersections.java)

### 序列问题
- 子串(sub array): 原序列的连续元素的组成的新序列
- 子序列(sub sequence):  原序列的非连续元素(符合原序列顺序)的组成的新序列

#### 单一序列问题
> dp[i]: 以第i个元素结尾的序列

- [53. maximum subarray](src/main/java/com/wzx/leetcode/No53MaximumSubarray.java)
- [offer48. 最长不含重复字符的子字符串](src/main/java/com/wzx/sword/No48TheLongestSubstringWithoutRepeatedCharacters.java)
- [300. Longest Increasing Subsequence](src/main/java/com/wzx/leetcode/No300LongestIncreasingSubsequence.java)
- [354. Russian Doll Envelopes](src/main/java/com/wzx/leetcode/No354RussianDollEnvelopes.java)
- [53. Maximum subarray](src/main/java/com/wzx/leetcode/No53MaximumSubarray.java)

#### 双序列问题
> 回文序列是自身与自身比较也是双序列问题
> 
> dp[i, j]: 子串i~j

- [72. Edit Distance](src/main/java/com/wzx/leetcode/No72EditDistance.java)
- [10. Regular Expression Matching](src/main/java/com/wzx/leetcode/No10RegularExpressionMatching.java)
- [1312. Minimum Insertion Steps to Make a String Palindrome](src/main/java/com/wzx/leetcode/No1312MinimumInsertionStepsToMakeAStringPalindrome.java)
- [5. Longest Palindromic Substring](src/main/java/com/wzx/leetcode/No5LongestPalindromicSubstring.java)
- [1143. Longest Common Subsequence](src/main/java/com/wzx/leetcode/No1143LongestCommonSubsequence.java)
- [516. Longest Palindromic Subsequence](src/main/java/com/wzx/leetcode/No516LongestPalindromicSubsequence.java)

### 背包问题
- [322. Coin Change](src/main/java/com/wzx/leetcode/No322CoinChange.java): 完全背包
- [518. Coin Change 2](src/main/java/com/wzx/leetcode/No518CoinChange2.java): 完全背包
- [416. Partition Equal Subset Sum](src/main/java/com/wzx/leetcode/No416PartitionEqualSubsetSum.java): 0-1背包    
- [494. Target Sum](src/main/java/com/wzx/leetcode/No494TargetSum.java): 0-1背包

### 股票问题
> [股票问题](https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/tuan-mie-gu-piao-wen-ti)

- [121. Best Time to Buy and Sell Stock](src/main/java/com/wzx/leetcode/No121BestTimeToBuyAndSellStock.java)
- [122. Best Time to Buy and Sell Stock II](src/main/java/com/wzx/leetcode/No122BestTimeToBuyAndSellStock2.java)
- [123. Best Time to Buy and Sell Stock III](src/main/java/com/wzx/leetcode/No123BestTimeToBuyAndSellStock3.java)
- [188. Best Time to Buy and Sell Stock IV](src/main/java/com/wzx/leetcode/No188BestTimeToBuyAndSellStock4.java)
- [309. Best Time to Buy and Sell Stock with Cooldown](src/main/java/com/wzx/leetcode/No309BestTimeToBuyAndSellStockWithCooldown.java)
- [714. Best Time to Buy and Sell Stock with Transaction Fee](src/main/java/com/wzx/leetcode/No714BestTimeToBuyAndSellStockWithTransactionFee.java)

### 打家劫舍
- [198. House Robber](src/main/java/com/wzx/leetcode/No198HouseRobber.java)
- [213. House Robber II](src/main/java/com/wzx/leetcode/No213HouseRobber2.java)
- [337. House Robber III](src/main/java/com/wzx/leetcode/No337HouseRobber3.java)

## 二分搜索
- [34. Find First and Last Position of Element in Sorted Array](src/main/java/com/wzx/leetcode/No34FindFirstAndLastPositionOfElementInSortedArray.java): [上下界查找](https://masterwangzx.com/2020/03/03/binary-search/)
- [offer4. 二维数组中的查找](src/main/java/com/wzx/sword/No4TwoDimensionalArraySearch.java)
- [offer11. 旋转数组的最小数字](src/main/java/com/wzx/sword/No11RotateMinNum.java)
- [offer53. 0～n-1中缺失的数字](src/main/java/com/wzx/sword/No53TheMissingNumbers.java)
- [793. Preimage Size of Factorial Zeroes Function](src/main/java/com/wzx/leetcode/No793PreimageSizeOfFactorialZeroesFunction.java)
- [392. Is Subsequence](src/main/java/com/wzx/leetcode/No392IsSubsequence.java)

## 双指针
- [offer21. 调整数组顺序使奇数位于偶数前面](src/main/java/com/wzx/sword/No21AdjustArrayOrder.java)
- [offer5. 替换空格](src/main/java/com/wzx/sword/No5ReplaceWhiteSpace.java)
- [392. Is Subsequence](src/main/java/com/wzx/leetcode/No392IsSubsequence.java)

### 快慢指针
- [141. LinkedListCycle](src/main/java/com/wzx/leetcode/No141LinkedListCycle.java)
- [19. Remove Nth Node From End of List](src/main/java/com/wzx/leetcode/No19RemoveNthNodeFromEndOfList.java)
- [141. LinkedListCycle](src/main/java/com/wzx/leetcode/No141LinkedListCycle.java)
- [142. LinkedListCycle2](src/main/java/com/wzx/leetcode/No142LinkedListCycle2.java)
- [26. Remove Duplicates from Sorted Array](src/main/java/com/wzx/leetcode/No26RemoveDuplicatesFromSortedArray.java)
- [83. Remove Duplicates from Sorted List](src/main/java/com/wzx/leetcode/No83RemoveDuplicatesFromSortedList.java)
- [82. Remove Duplicates from Sorted List II](src/main/java/com/wzx/leetcode/No82RemoveDuplicatesFromSortedList2.java)
- [19. Remove Nth Node From End of List](src/main/java/com/wzx/leetcode/No19RemoveNthNodeFromEndOfList.java)
- [27. Remove Element](src/main/java/com/wzx/leetcode/No27RemoveElement.java)
- [283. Move Zeroes](src/main/java/com/wzx/leetcode/No283MoveZeroes.java)

### 滑动窗口
- [76. Minimum Window Substring](src/main/java/com/wzx/leetcode/No76MinimumWindowSubstring.java)
- [438. Find All Anagrams in a String](src/main/java/com/wzx/leetcode/No438FindAllAnagramsInAString.java)
- [567. Permutation in String](src/main/java/com/wzx/leetcode/No567PermutationInString.java)
- [offer48. 最长不含重复字符的子字符串](src/main/java/com/wzx/sword/No48TheLongestSubstringWithoutRepeatedCharacters.java)
- [offer57. 和为s的连续正数序列](src/main/java/com/wzx/sword/No57NSum.java)
- [offer58. 翻转单词顺序](src/main/java/com/wzx/sword/No58ReverseWordOrder.java)

### 左右指针
- [167. two sum II - input array is sorted](src/main/java/com/wzx/leetcode/No167TwoSum2InputArrayIsSorted.java)
- [15. 3sum](src/main/java/com/wzx/leetcode/No15ThreeSum.java)
- [16. 3sum closest](src/main/java/com/wzx/leetcode/No16ThreeSumClosest.java)
- [923. 3sum with multiplicity](src/main/java/com/wzx/leetcode/No923ThreeSumWithMultiplicity.java)
- [18. 4Sum](src/main/java/com/wzx/leetcode/No18FourSum.java)
- [42. trapping rain water](src/main/java/com/wzx/leetcode/No42TrappingRainWater.java)
- [5. Longest Palindromic Substring](src/main/java/com/wzx/leetcode/No5LongestPalindromicSubstring.java)

## 深搜回溯
- [offer12. 矩阵中的路径](src/main/java/com/wzx/sword/No12MatrixPath.java)
- [offer38. 字符串的排列](src/main/java/com/wzx/sword/No38StringArrangement.java)
- [46. Permutations](src/main/java/com/wzx/leetcode/No46Permutations.java)
- [47. Permutations II](src/main/java/com/wzx/leetcode/No47Permutations2.java)
- [51. N-Queens](src/main/java/com/wzx/leetcode/No51NQueens.java)
- [52. N-Queens II](src/main/java/com/wzx/leetcode/No52NQueens2.java)
- [offer13. 机器人的运动范围](src/main/java/com/wzx/sword/No13RobotMovementRange.java)
- [offer17. 打印从1到最大的n位数](src/main/java/com/wzx/sword/No17PrintMaximumNDigits.java)
- [130. Surrounded Regions](src/main/java/com/wzx/leetcode/No130SurroundedRegions.java)
- [77. Combinations](src/main/java/com/wzx/leetcode/No77Combinations.java)
- [78. Subsets](src/main/java/com/wzx/leetcode/No78Subsets.java)
- [37. Sudoku Solver](src/main/java/com/wzx/leetcode/No37SudokuSolver.java)
- [22. Generate Parentheses](src/main/java/com/wzx/leetcode/No22GenerateParentheses.java)

## 广搜
- [111. Minimum Depth of Binary Tree](src/main/java/com/wzx/leetcode/No111MinimumDepthOfBinaryTree.java)
- [752. Open the Lock](src/main/java/com/wzx/leetcode/No752OpenTheLock.java)
- [773. Sliding Puzzle](src/main/java/com/wzx/leetcode/No773SlidingPuzzle.java)

## 分治
> [分治](https://mp.weixin.qq.com/s/fcCJFk89w953gXDjnlZFIA)

- [241. Different Ways to Add Parentheses](src/main/java/com/wzx/leetcode/No241DifferentWaysToAddParentheses.java)
- [53. Maximum subarray](src/main/java/com/wzx/leetcode/No53MaximumSubarray.java)

# 其他
- [offer1. 单例模式](src/main/java/com/wzx/sword/No1Singleton.java) [线程安全的单例模式](https://masterwangzx.com/2021/01/10/java-singleton/)
- [offer20. 表示数值的字符串](src/main/java/com/wzx/sword/No20StringRepresentingNumericValue.java)
- [921. Minimum Add to Make Parentheses Valid](src/main/java/com/wzx/leetcode/No921MinimumAddToMakeParenthesesValid.java)
- [1541. Minimum Insertions to Balance a Parentheses String](src/main/java/com/wzx/leetcode/No1541MinimumInsertionsToBalanceAParenthesesString.java)
- [offer61. 扑克牌中的顺子](src/main/java/com/wzx/sword/No61StraightInPlayingCards.java)
- [341. Flatten Nested List Iterator](src/main/java/com/wzx/leetcode/No341FlattenNestedListIterator.java)
- [43. Multiply Strings](src/main/java/com/wzx/leetcode/No43MultiplyStrings.java)
- [969. Pancake Sorting](src/main/java/com/wzx/leetcode/No969PancakeSorting.java)
- [855. Exam Room](src/main/java/com/wzx/leetcode/No855ExamRoom.java)

## 找规律

- [offer43. 1~n整数中1出现的次数](src/main/java/com/wzx/sword/No43NumberOfOccurrencesOf1InAnInteger.java)
- [offer29. 顺时针打印矩阵](src/main/java/com/wzx/sword/No29PrintMatrixClockwise.java)
- [offer44. 数字序列中某一位的数字](src/main/java/com/wzx/sword/No44ADigitInASequenceOfNumbers.java)
- [offer45. 把数组排成最小的数](src/main/java/com/wzx/sword/No45ArrangeTheArrayIntoTheSmallestNumber.java)
- [offer62. 圆圈中最后剩下的数字](src/main/java/com/wzx/sword/No62TheLastRemainingNumberInTheCircle.java): 约瑟夫环
- [offer66. 构建乘积数组](src/main/java/com/wzx/sword/No66BuildAnArrayOfProducts.java)
- [391. Perfect Rectangle](src/main/java/com/wzx/leetcode/No391PerfectRectangle.java)
- [172. Factorial Trailing Zeroes](src/main/java/com/wzx/leetcode/No172FactorialTrailingZeroes.java)
- [204. Count Primes](src/main/java/com/wzx/leetcode/No204CountPrimes.java)
- [263. Ugly Number](src/main/java/com/wzx/leetcode/No263UglyNumber.java)

## 排序
- [912. Sort an Array.cpp](src/main/java/com/wzx/leetcode/No912SortAnArray.java): [内排序算法](https://masterwangzx.com/2019/11/26/inner-sort/)
- [310. Minimum Height Trees](src/main/java/com/wzx/leetcode/No310MinimumHeightTrees.java): [拓扑排序](https://masterwangzx.com/2018/10/09/python-animal-system/)
- [215. Kth Largest Element in an Array](src/main/java/com/wzx/leetcode/No215KthLargestElementInAnArray.java)
- [347. Top K Frequent Elements](src/main/java/com/wzx/leetcode/No347TopKFrequentElements.java)
- [offer51. 数组中的逆序对](src/main/java/com/wzx/sword/No51ReversedPairsInTheArray.java)

## 水塘抽样
> [水塘抽样](https://mp.weixin.qq.com/s/DrBFYAZnPBgNNay2wjNU-A)

- [382. Linked List Random Node](src/main/java/com/wzx/leetcode/No382LinkedListRandomNode.java)
- [398. Random Pick Index](src/main/java/com/wzx/leetcode/No398RandomPickIndex.java)

## 斐波那契
- [offer10. 斐波那契数组](src/main/java/com/wzx/sword/No10FibonacciSequence.java)
- [offer10. 变态青蛙跳](src/main/java/com/wzx/sword/No10StepUp.java)
- [offer12. 矩形覆盖](src/main/java/com/wzx/sword/No12MatrixCoverage.java)

## 位运算
- [offer56. 数组中数字出现的次数1](src/main/java/com/wzx/sword/No56NumberOfOccurrencesOfNumbersInTheArray1.java)
- [offer56. 数组中数字出现的次数2](src/main/java/com/wzx/sword/No56NumberOfOccurrencesOfNumbersInTheArray2.java)
- [offer15. 二进制中1的个数](src/main/java/com/wzx/sword/No15NumOfOneInBinary.java)
- [offer16. 数值的整数次方](src/main/java/com/wzx/sword/No16IntegerPower.java)
- [offer64. 求1+2+…+n](src/main/java/com/wzx/sword/No64Solve1ton.java)
- [offer65. 不用加减乘除做加法](src/main/java/com/wzx/sword/No65NoAddSubtractMultiplyDivide.java)