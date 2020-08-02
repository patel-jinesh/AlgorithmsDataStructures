from linkedlist import *


class LinkedListStack:
    def __init__(self):
        self.items = LinkedList(None)
        self.size = 0

    def push(self, value):
        self.items.head = LinkedListNode(value, self.items.head)
        self.size += 1

    def pop(self):
        if size == 0:
            return

        ret = self.items.head.value
        self.items.head = self.items.head.next
        self.size -= 1
        return ret

    def top(self):
        if self.isEmpty():
            return

        return self.items.head.value

    def isEmpty(self):
        return self.size == 0

    def size(self):
        return self.size


class ResizingArrayStack:
    def __init__(self):
        raise NotImplementedError

    def push(self, value):
        raise NotImplementedError

    def pop(self):
        raise NotImplementedError

    def top(self):
        raise NotImplementedError

    def isEmpty(self):
        raise NotImplementedError

    def size(self):
        raise NotImplementedError
