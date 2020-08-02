from linkedlist import *


class LinkedListQueue:
    def __init__(self):
        self.first = None
        self.last = None
        self.size == 0

    def enqueue(self, value):
        if self.first == None:
            self.first = LinkedListNode(value, None)
            self.last = self.first
        else:
            self.last.next = LinkedListNode(value, None)
            self.last = self.last.next

        self.size += 1

    def dequeue(self):
        if size == 0:
            return

        ret = self.first.value
        self.first = self.first.next
        self.size -= 1
        return ret

    def peek(self):
        if self.isEmpty():
            return

        return self.first.value

    def isEmpty(self):
        return self.size == 0

    def size(self):
        return self.size


class ResizingArrayQueue:
    def __init__(self):
        raise NotImplementedError

    def enqueue(self, value):
        raise NotImplementedError

    def dequeue(self):
        raise NotImplementedError

    def peek(self):
        raise NotImplementedError

    def isEmpty(self):
        raise NotImplementedError

    def size(self):
        raise NotImplementedError
