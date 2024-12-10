// Time Complexity :O(log(m+n))
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        if(n1>n2) return findMedianSortedArrays(nums2, nums1);

        int l =0;
        int h =n1;

        while(l<=h){
            int partx = l+(h-l)/2;
            int party = (n1+n2)/2 - partx;

            int l1 =  partx == 0 ? Integer.MIN_VALUE : nums1[partx-1];
            int r1 =  partx == n1 ? Integer.MAX_VALUE : nums1[partx];
            int l2 =  party == 0 ? Integer.MIN_VALUE : nums2[party-1];
            int r2 =  party == n2 ? Integer.MAX_VALUE : nums2[party];

            if(l1 <= r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2;
                }else{
                    return Math.min(r1,r2);
                }
            }else if(l2 > r1){
                l = partx+1;
            }else{
                h=partx-1;
            }
        }
        return -1;
    }
}
