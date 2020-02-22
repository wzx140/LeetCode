#include "header/SortArray.h"

#include <cmath>
#include <queue>
#include <algorithm>

using std::pow;
using std::log;
using std::swap;
using std::abs;
using std::max;
using std::priority_queue;
using std::max_element;
using std::min_element;

/**
 * https://leetcode.com/problems/sort-an-array/
 */

 /************
 / 插入排序
 /************

 /**
  * 直接插入排序
  * time:最坏O(n^2)
  * time:平均O(n^2)
  * time:最好O(n^2)
  * space:O(1)
  */
vector<int> SortArray::sortArray1(vector<int>& nums) {
	int length = nums.size();
	for (int i = 1; i < length; i++) {
		int record = nums[i];
		int j = i - 1;
		// 空出插入record的位置
		while (j >= 0 && nums[j] > record) {
			nums[j + 1] = nums[j];
			j--;
		}
		// 插入
		nums[j + 1] = record;
	}
	return nums;
}

/**
 * shell排序，使用Hibbard增量序列
 * time:最坏O(n^(3/2))
 * time:平均O(nlogn)
 * time:最好O(n)
 * space:O(1)
 */
vector<int> SortArray::sortArray2(vector<int>& nums) {
	int length = nums.size();

	for (int k = log(length + 1) / log(2); k > 0; k--) {
		int delta = pow(2, k) - 1;

		// 遍历每个相距为delta的序列
		for (int start = 0; start < delta; start++) {

			// 以相距为delta的序列应用插入排序
			for (int i = delta + start; i < length; i += delta) {
				int record = nums[i];
				int j = i - 1;
				// 空出插入record的位置
				while (j >= 0 && nums[j] > record) {
					nums[j + 1] = nums[j];
					j--;
				}
				// 插入
				nums[j + 1] = record;
			}
		}
	}

	return nums;
}

/************
/ 选择排序
/************

/**
 * 直接选择排序
 * time:最坏O(n^2)
 * time:平均O(n^2)
 * time:最好O(n^2)
 * space:O(1)
 */
vector<int> SortArray::sortArray3(vector<int>& nums) {
	int length = nums.size();
	for (int i = 0; i < length; i++) {
		// 找到i之后最小的值
		int minIndex = i;
		int minValue = nums[i];
		for (int j = i; j < length; j++) {
			if (minValue > nums[j]) {
				minIndex = j;
				minValue = nums[j];
			}
		}
		swap(nums[i], nums[minIndex]);
	}

	return nums;
}

/**
 * 堆排序
 * time:最坏O(nlogn)
 * time:平均O(nlogn)
 * time:最好O(nlogn)
 * space:O(1)
 */
vector<int> SortArray::sortArray4(vector<int>& nums) {
	int length = nums.size();
	priority_queue<int> max_heap;

	// 建堆
	for (int i = 0; i < length; i++) {
		max_heap.push(nums[i]);
	}

	for (int i = length - 1; i >= 0; i--) {
		nums[i] = max_heap.top();
		max_heap.pop();
	}

	return nums;
}

/************
/ 选择排序
/************

/**
 * 冒泡排序
 * time:最坏O(n^2)
 * time:平均O(n^2)
 * time:最好O(n)
 * space:O(1)
 */
vector<int> SortArray::sortArray5(vector<int>& nums) {
	int length = nums.size();
	for (int i = 0; i < length - 1; i++) {
		bool isSwap = false;

		// 冒泡
		for (int j = length - 1; j > i; j--) {
			if (nums[j] < nums[j - 1]) {
				swap(nums[j], nums[j - 1]);
				isSwap = true;
			}
		}
		// 未发生交换说明已经全部排序完成
		if (!isSwap) {
			return nums;
		}
	}

	return nums;
}

/**
 * 快速排序
 * time:最坏O(nlogn)
 * time:平均O(nlogn)
 * time:最好O(nlogn)
 * space:O(logn)
 */
void QuickSort(vector<int>& nums, int left, int right) {

	if (left >= right) {
		return;
	}

	// 选择轴值
	int pivot = (right - left) / 2 + left;
	int record = nums[pivot];

	// 每次从左边或右边拿出大于或小于pivot的值放到对面
	// 交替执行
	int l = left;
	int r = right;
	nums[pivot] = nums[right];
	while (l < r) {
		while (nums[l] <= record && l < r) {
			l++;
		}
		if (l < r) {
			nums[r--] = nums[l];
		}
		while (nums[r] > record && l < r) {
			r--;
		}
		if (l < r) {
			nums[l++] = nums[r];
		}
	}
	nums[l] = record;

	QuickSort(nums, left, l - 1);
	QuickSort(nums, l + 1, right);
}
vector<int> SortArray::sortArray6(vector<int>& nums) {

	QuickSort(nums, 0, nums.size() - 1);
	return nums;
}

/************
/ 其他
/************

/**
 * 归并排序
 * time:最坏O(nlogn)
 * time:平均O(nlogn)
 * time:最好O(nlogn)
 * space:O(nlogn)
 */
void merge(vector<int>& array, vector<int>& temp, int left, int right, int middle) {
	if (left >= right) {
		return;
	}

	// 左序列正序，右序列倒序
	for (int i = left; i <= middle; i++) {
		temp[i] = array[i];
	}
	for (int i = middle + 1; i <= right; i++) {
		temp[right - (i - middle) + 1] = array[i];
	}

	// 左右子序列索引
	int index1 = left;
	int index2 = right;
	// 合并后的索引
	int index = left;
	// 从左右序列两边向中间的方向，归并
	while (index <= right) {
		if (temp[index1] <= temp[index2]) {
			array[index++] = temp[index1++];
		} else {
			array[index++] = temp[index2--];
		}
	}

}
void MergeSort(vector<int>& array, vector<int>& temp, int left, int right) {
	if (left >= right) {
		return;
	}
	int middle = (right - left) / 2 + left;

	MergeSort(array, temp, left, middle);
	MergeSort(array, temp, middle + 1, right);
	merge(array, temp, left, right, middle);
}
vector<int> SortArray::sortArray7(vector<int>& nums) {

	// 临时数组引用传递，节省空间
	vector<int> temp(nums);
	MergeSort(nums, temp, 0, nums.size() - 1);
	return nums;
}

/************
/ 分配排序
/************

/**
 * 桶式排序
 * time:最坏O(n+m)
 * time:平均O(n+m)
 * time:最好O(n+m)
 * space:O(n+m)
 */
void bucketSort(vector<int>& array, int min, int max) {
	int n = array.size();
	// 桶个数
	int m = max - min + 1;
	vector<int> count(m, 0);
	vector<int> temp(n, 0);
	for (int i = 0; i < n; i++) {
		temp[i] = array[i];
	}
	// 统计每个桶中的元素个数
	for (int i = 0; i < n; i++) {
		count[array[i] - min]++;
	}
	// 统计小于等于i的元素个数
	for (int i = 1; i < m; i++) {
		count[i] += count[i - 1];
	}
	// 从后向前，保证稳定性
	for (int i = n - 1; i >= 0; i--) {
		array[--count[temp[i] - min]] = temp[i];
	}
}
vector<int> SortArray::sortArray8(vector<int>& nums) {

	// 区间范围
	int maxValue = *max_element(nums.begin(), nums.end());
	int minValue = *min_element(nums.begin(), nums.end());
	bucketSort(nums, minValue, maxValue);
	return nums;
}

/**
 * 基数排序
 * time:最坏O(d(n+r))
 * time:平均O(d(n+r))
 * time:最好O(d(n+r))
 * space:O(n+r)
 */
void RadixtSort(vector<int>& array, int d, int radix, int minR, int maxR) {
	int n = array.size();
	// 桶个数
	int r = maxR - minR + 1;
	vector<int> count(r, 0);
	vector<int> temp(n, 0);
	// 对每一位应用桶排序
	for (int i = 0; i <= d; i++) {
		for (int j = 0; j < r; j++) {
			count[j] = 0;
		}
		// 统计每个桶中的元素个数
		for (int j = 0; j < n; j++) {
			int k = array[j] / (int)pow(radix, i) % radix;
			count[k - minR]++;
		}
		// 统计小于等于i的元素个数
		for (int j = 1; j < r; j++) {
			count[j] += count[j - 1];
		}
		for (int j = 0; j < n; j++) {
			temp[j] = array[j];
		}
		// 从后向前，保证稳定性
		for (int j = n - 1; j >= 0; j--) {
			int k = temp[j] / (int)pow(radix, i) % radix;
			array[--count[k - minR]] = temp[j];
		}
	}
}
vector<int> SortArray::sortArray9(vector<int>& nums) {

	int maxValue = *max_element(nums.begin(), nums.end());
	int minValue = *min_element(nums.begin(), nums.end());
	RadixtSort(nums, log(max(abs(maxValue), abs(minValue))) / log(10), 10, -9, 9);
	return nums;
}
