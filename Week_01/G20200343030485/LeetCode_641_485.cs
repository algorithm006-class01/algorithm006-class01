public class MyCircularDeque
    {
        private LinkedList<int> ll;
        private readonly int capacity;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k)
        {
            ll = new LinkedList<int>();
            capacity = k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public bool InsertFront(int value)
        {
            if (ll.Count >= capacity)
            {
                return false;
            }

            ll.AddFirst(value);

            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public bool InsertLast(int value)
        {
            if (ll.Count >= capacity)
            {
                return false;
            }

            ll.AddLast(value);

            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public bool DeleteFront()
        {
            if (ll.Count == 0)
            {
                return false;
            }

            ll.RemoveFirst();

            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public bool DeleteLast()
        {
            if (ll.Count == 0)
            {
                return false;
            }

            ll.RemoveLast();

            return true;
        }

        /** Get the front item from the deque. */
        public int GetFront()
        {
            if (ll.Count == 0)
            {
                return -1;
            }

            return ll.First.Value;
        }

        /** Get the last item from the deque. */
        public int GetRear()
        {
            if (ll.Count == 0)
            {
                return -1;
            }

            return ll.Last.Value;
        }

        /** Checks whether the circular deque is empty or not. */
        public bool IsEmpty()
        {
            return (ll.Count == 0);
        }

        /** Checks whether the circular deque is full or not. */
        public bool IsFull()
        {
            return ll.Count == capacity;
        }

        /**
         * Your MyCircularDeque object will be instantiated and called as such:
         * MyCircularDeque obj = new MyCircularDeque(k);
         * bool param_1 = obj.InsertFront(value);
         * bool param_2 = obj.InsertLast(value);
         * bool param_3 = obj.DeleteFront();
         * bool param_4 = obj.DeleteLast();
         * int param_5 = obj.GetFront();
         * int param_6 = obj.GetRear();
         * bool param_7 = obj.IsEmpty();
         * bool param_8 = obj.IsFull();
         */
    }