def deleteK(stack, k):
    k = int(k)
    for i in range(k):
        stack.pop()

def printK(stack, k):
    k = int(k)
    if k <= len(stack):
        print(stack[k - 1])

def undo(history):
    return history.pop()

if __name__ == '__main__':
    S = []
    history = []
    n = int(input())
    
    for i in range(n):
        line = input().split()
        op = line[0]
        
        if op == "1":
            history.append(S[:])
            S.extend(list(line[1])) # Sửa lại để append đúng ký tự
            
        elif op == "2":
            history.append(S[:])
            deleteK(S, line[1])
            
        elif op == "3":
            printK(S, line[1])
            
        elif op == "4":
            S = undo(history) # Không append(S) lại vào history nữa