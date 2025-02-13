from Stack import Stack
from Queue import Queue

stack = Stack()
queue = Queue()

stack.push(5)
print(stack.peek())
print(stack)
stack.pop()
print(stack.peek())
print(stack)

print('---' + '\n' + '---' + '\n' + '---')
       
queue.push(4)
print(queue.peek())
print(queue)
queue.pop()
print(queue.peek())
print(queue)
