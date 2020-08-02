from linkedlist import *


class LinkedListBag:
    def __init__(self):
        self.items = LinkedList(None)
        self.size = 0

    def add(self, value):
        self.items.head = LinkedListNode(val, self.items.head)
        self.size += 1

    def isEmpty(self):
        return self.size == 0

    def size(self):
        return self.size


class ResizingArrayBag:
    def __init__(self):
        self.items = [None, None]
        self.size = 0

    def add(self, value):
        def resize(capacity):
            self.items += [None] * (capacity - len(self.items))
        # double size of list if full
        if self.size == len(self.items):
            resize(2 * len(self.items))

        self.size += 1
        self.items[self.size] = value

    def isEmpty(self):
        return self.size == 0

    def size(self):
        return self.size
