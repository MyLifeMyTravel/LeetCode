/**
 * Created by littlejie on 2017/5/20.
 */
public class Q4MedianofTwoSortedArrays {

    public static void main(String[] args) {
//        int[] nums1 = {1, 2};
//        int[] nums2 = {3, 4};
        //1、1、2、3、4、4、5、9
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 2, 3, 4, 9};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    /**
     * 采用二分法，时间复杂度O(log(n+m))
     * @see <a href="http://blog.csdn.net/yutianzuijin/article/details/11499917/">http://blog.csdn.net/yutianzuijin/article/details/11499917/</a>
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int nums1[], int nums2[]) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 != 0)
            return (double) findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);//k传得是第k个，index实则k-1
        else {
            double x = findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2);//k传得是第k个，index实则k-1
            double y = findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);//k传得是第k个，index实则k-1
            return (x + y) / 2;
        }
    }

    public static int findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int m = end1 - start1 + 1;
        int n = end2 - start2 + 1;

        if (m > n)
            return findKth(nums2, start2, end2, nums1, start1, end1, k);
        if (m == 0)
            return nums2[k - 1];
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);

        int partA = Math.min(k / 2, m);
        int partB = k - partA;
        if (nums1[start1 + partA - 1] < nums2[start2 + partB - 1]) {
            return findKth(nums1, start1 + partA, end1, nums2, start2, end2, k - partA);
        } else if (nums1[start1 + partA - 1] > nums2[start2 + partB - 1]) {
            return findKth(nums1, start1, end1, nums2, start2 + partB, end2, k - partB);
        } else {
            return nums1[start1 + partA - 1];
        }
    }

//    /**
//     * 时间复杂度为 O(n+m)
//     * @param nums1
//     * @param nums2
//     * @return
//     */
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int length1 = nums1.length;
//        int length2 = nums2.length;
//        int[] merge = new int[length1 + length2];
//        int i = 0, j = 0, k = 0;
//        //两个数组比较并合并，肯定是其中一个数组先合并完成，所以必须考虑将另一个数组剩下的数据放入数组中
//        while (i < length1 || j < length2) {
//            if (i < length1 && j < length2) {
//                merge[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
//            } else if (i < length1) {
//                merge[k++] = nums1[i++];
//            } else if (j < length2) {
//                merge[k++] = nums2[j++];
//            }
//        }
//        int size = merge.length;
//        if (size % 2 == 0) {
//            return (merge[size / 2] + merge[size / 2 - 1]) / 2.0;
//        } else {
//            return merge[size / 2];
//        }
//    }
}
