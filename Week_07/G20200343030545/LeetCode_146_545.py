class DoubleLinkNode:
    def __init__(self, key=None, val=None):
        self.key = key
        self.val = val
        self.prev = None
        self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.size = 0
        self.mapping = {}
        self.tail_node = DoubleLinkNode()
        self.head_node = DoubleLinkNode()

        self.head_node.next = self.tail_node
        self.tail_node.prev = self.head_node

    def get(self, key: int) -> int:
        node = self.mapping.get(key)
        if node is None:
            return -1

        self.move_to_head(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        node = self.mapping.get(key)

        if not node:
            node = DoubleLinkNode(key, value)
            self.mapping[key] = node
            self.size += 1
            self.add_to_head(node)

            if self.size > self.capacity:
                tail_node = self.pop_tail_node()
                del self.mapping[tail_node.key]
                self.size -= 1
        else:
            node.val = value
            self.move_to_head(node)

    def move_to_head(self, node: DoubleLinkNode):
        self.remove_to_head(node)
        self.add_to_head(node)

    def add_to_head(self, node: DoubleLinkNode):
        node.prev = self.head_node
        node.next = self.head_node.next
        self.head_node.next.prev = node
        self.head_node.next = node

    def pop_tail_node(self) -> DoubleLinkNode:
        tail_node = self.tail_node.prev
        self.remove_to_head(tail_node)
        return tail_node

    def remove_to_head(self, node: DoubleLinkNode):
        prev_node = node.prev
        next_node = node.next

        prev_node.next = next_node
        next_node.prev = prev_node
