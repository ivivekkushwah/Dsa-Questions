class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] arr = {-1, -1};

        int i = 2;
        int minD = Integer.MAX_VALUE;
        int maxD = 0;
        int firstC = 0;
        int prevC = 0;

        return checkMiniandMaxi(
            head,
            head.next,
            head.next.next,
            i,
            arr,
            minD,
            maxD,
            firstC,
            prevC
        );
    }

    public int[] checkMiniandMaxi(
        ListNode prev,
        ListNode curr,
        ListNode after,
        int i,
        int[] arr,
        int minD,
        int maxD,
        int firstC,
        int prevC
    ) {
        if (after == null) {
            if (firstC != 0 && prevC != firstC) {
                arr[0] = minD;
                arr[1] = maxD;
            }
            return arr;
        }

        boolean critical =
            (prev.val < curr.val && curr.val > after.val) ||
            (prev.val > curr.val && curr.val < after.val);

        if (critical) {

            if (prevC != 0) {
                minD = Math.min(minD, i - prevC);
            }

            if (firstC != 0) {
                maxD = Math.max(maxD, i - firstC);
            }

            if (firstC == 0) {
                firstC = i;
            }

            prevC = i;
        }

        return checkMiniandMaxi(
            curr,
            after,
            after.next,
            i + 1,
            arr,
            minD,
            maxD,
            firstC,
            prevC
        );
    }
}