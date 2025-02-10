from queue import Queue

if __name__ == "__main__":
    q = Queue(5)
    q.enqueue(100)
    q.enqueue(200)
    q.enqueue(300)
    q.print_queue()

    print("Peek:", q.peek())
    print("Dequeue:", q.dequeue())
    print("Dequeue:", q.dequeue())

    if q.is_empty():
        print("Queue is empty")
    else:
        print("Queue is not empty")

    q.print_queue()