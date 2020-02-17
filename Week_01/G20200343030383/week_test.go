package leetcode

import (
	"testing"

	"math/rand"
	"sort"

	"github.com/stretchr/testify/assert"
)

/* test for https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/ */
func TestRemoveDuplicates(t *testing.T) {
	assert := assert.New(t)
	/* test 1000 samples */
	for i := 0; i < 100; i++ {
		slice, dupCount := makeDuplicateSliceSample(i)
		assert.Equal(removeDuplicates(slice), len(slice)-dupCount)
	}
}

func makeDuplicateSliceSample(sampleSize int) (sample []int, dupCount int) {
	sample = make([]int, sampleSize)
	numsMap := make(map[int]bool)
	for i := 0; i < sampleSize; i++ {
		v := rand.Intn(10000)
		sample[i] = v
		if _, ok := numsMap[v]; ok {
			dupCount++
		} else {
			numsMap[v] = true
		}
	}
	sort.Ints(sample)
	return
}

/* test for https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/ */
func TestRotate(t *testing.T) {
	assert := assert.New(t)
	for i := 0; i < 100; i++ {
		sample := makeRotateSample(i)
		sample2 := make([]int, i)
		copy(sample2, sample)
		k := rand.Intn(37)
		/* cross test for rotate & rotate2 */
		rotate(sample, k)
		rotate2(sample2, k)
		assert.Equal(sample, sample2)
	}
}

func makeRotateSample(size int) []int {
	sample := make([]int, size)
	for i := 0; i < size; i++ {
		v := rand.Intn(10000)
		sample[i] = v
	}
	return sample
}

/* test for  https://leetcode-cn.com/problems/rotate-array/  */
func TestMergeLinkedList(t *testing.T) {
	assert := assert.New(t)
	l1, l2 := makeLinkedList([]int{}), makeLinkedList([]int{1})
	out := linkedListToSlice(mergeTwoLists(l1, l2))
	assert.Equal([]int{1}, out)

	l1, l2 = makeLinkedList([]int{1, 1, 3, 4}), makeLinkedList([]int{1, 2, 3, 3, 5})
	out = linkedListToSlice(mergeTwoLists(l1, l2))
	assert.Equal([]int{1, 1, 1, 2, 3, 3, 3, 4, 5}, out)
}

func makeLinkedList(nums []int) *ListNode {
	var node, head *ListNode
	for _, v := range nums {
		n := &ListNode{Val: v}
		if node != nil {
			node.Next = n
			node = n
		} else {
			node = n
			head = n
		}
	}
	return head
}

func linkedListToSlice(n *ListNode) (s []int) {
	for cur := n; cur != nil; {
		s = append(s, cur.Val)
		cur = cur.Next
	}
	return
}

/* test for https://leetcode-cn.com/problems/move-zeroes/submissions/ */
func TestMoveZeros(t *testing.T) {
	assert := assert.New(t)
	for i := 0; i < 100; i++ {
		s1 := makeSliceWithZeros(i)
		s2 := make([]int, i)
		copy(s2, s1)

		moveZeroes(s1)
		s3 := make([]int, i)
		var j int
		for _, v := range s2 {
			if v != 0 {
				s3[j] = v
				j++
			}
		}

		assert.Equal(s1, s3)
	}
}

func makeSliceWithZeros(sampleSize int) (sample []int) {
	sample = make([]int, sampleSize)
	for i := 0; i < sampleSize; i++ {
		if rand.Int()%2 == 0 {
			sample[i] = 0
		} else {
			sample[i] = rand.Intn(10000)
		}
	}
	return
}

/* test for https://leetcode-cn.com/problems/design-circular-deque/ */
func TestCircularDeque(t *testing.T) {
	assert := assert.New(t)
	q := Constructor(3)
	assert.True(q.InsertLast(1))
	assert.True(q.InsertLast(2))
	assert.True(q.InsertFront(3))
	assert.False(q.InsertFront(4))
	assert.Equal(2, q.GetRear())
	assert.True(q.IsFull())
	assert.True(q.DeleteLast())
	assert.True(q.InsertFront(4))
	assert.Equal(4, q.GetFront())
}

/* test for  https://leetcode.com/problems/trapping-rain-water/submissions/ */
func TestTrap(t *testing.T) {
	height := []int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
	assert := assert.New(t)
	assert.Equal(6, trap(height))
	assert.Equal(6, trap2(height))
}
