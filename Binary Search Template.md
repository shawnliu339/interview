# Binary Search Template
## Template 1
用于普通搜索
```
fun search(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.lastIndex
    while(left <= right) {
        val middle = (left + right) / 2
        if(target < nums[middle]) {
            right = middle - 1
        } else if(target > nums[middle]) {
            left = middle + 1
        } else {
            return middle
        }
    }
    
    return -1
}
```

## Template 2
用于寻找分界点, 常常用于拥有2段性的数组
```
fun firstBadVersion(n: Int) : Int {
    var left = 1
    var right = n
    while(left < right) {
        // Prevent (left + right) overflow
        val mid = left + (right - left) / 2
        if(isBadVersion(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    
    return left
}
```

## Template 3
用于寻找区间。  
区间比较的时候，要留最后两个值进行比较，而不是直接留最后一个值。  
因为，不能保证区间的正确性，例如[1,5], target=3，1是最接近的，但是，5被返回。  
```
fun findCloest(arr: IntArray, target: Int) {
    var left = 0
    var right = arr.lastIndex
    // 区间比较的时候，要留最后两个值进行比较，而不是直接留最后一个值
    // 因为，不能保证区间的正确性，例如[1,5], target=3，1是最接近的，但是，5被返回
    while(left + 1 < right) {
        val mid = (left + right) / 2
        if(target > arr[mid]) {
            // mid直接被赋值也是重点
            left = mid
        } else if(target < arr[mid]) {
            right = mid
        } else {
            left = mid
            break
        }
    }
    
    // post process
    return if(Math.abs(arr[left] - target) <= Math.abs(arr[right] - target)) {
        left
    } else {
        right
    }
}
```