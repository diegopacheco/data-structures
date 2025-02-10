from stack import Stack

if __name__ == "__main__":
    s = Stack(5)
    s.push(100)
    s.push(200)
    s.push(300)
    s.print_stack()

    print("Top element:", s.peek())
    print("Pop:", s.pop())
    print("Pop:", s.pop())

    if s.is_empty():
        print("Stack is empty.")
    else:
        print("Stack is not empty.")
    s.print_stack()