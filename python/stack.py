class Stack(object):
    def __init__(self):
        self.data = []

    def is_empty(self):
        return (len(self.data) == 0)

    def size(self):
        return len(self.data)

    def push(self, value):
        self.data.append(value)

    def pop(self):
        if self.is_empty():
            print("Stack underflow!")
        return self.data.pop()

    def peek(self):
        if self.is_empty():
            print("Stack underflow!")
        return self.data[len(self.data) - 1]

    def print(self):
        print(self.data)

def main():
    my_stack = Stack()
    my_stack.push(5)
    my_stack.push(10)
    my_stack.print()
    print(my_stack.pop())
    my_stack.print()

if __name__ == "__main__":
    main()