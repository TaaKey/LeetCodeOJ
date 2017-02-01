package MergeKSortedLists;

import Util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Wentao on 1/31/2017.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode fake = new ListNode(-1);
        ListNode point = fake;
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            if (point.next != null) {
                queue.add(point.next);
            }
        }
        return fake.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    private ListNode partion(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (start + end) / 2;
            ListNode l1 = partion(lists, start, mid);
            ListNode l2 = partion(lists, mid + 1, end);
            return merge(l1, l2);
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);
        ListNode point = fake;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                point.next = l1;
                l1 = l1.next;
            } else {
                point.next = l2;
                l2 = l2.next;
            }
            point = point.next;
        }
        while (l1 != null) {
            point.next = l1;
            l1 = l1.next;
            point = point.next;
        }
        while (l2 != null) {
            point.next = l2;
            l2 = l2.next;
            point = point.next;
        }
        return fake.next;
    }

    private ListNode merge2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }
}

