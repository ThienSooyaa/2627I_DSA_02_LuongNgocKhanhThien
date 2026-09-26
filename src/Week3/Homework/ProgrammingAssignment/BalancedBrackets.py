def checkForBalance(s, x):
    if (s == ")"):
        if (x == "("):
            return True
    elif (s == "]"):
        if (x == "["):
            return True
    elif (s == "}"):
        if (x == "{"):
            return True
    return False

def isBalanced(s):
    stack = []
    for i in s:
        if i in {"{", "(", "["}:
            stack.append(i)
        else:
            if not stack or not checkForBalance(i, stack.pop()):
                return "NO"
                
    if not stack:
        return "YES"
    else:
        return "NO"

if __name__=='__main__':
    t=int(input("Enter the number of test case: "))
    for i in range(t):
        s=input(f"Test case #{i+1}: ")
        result= isBalanced(s)
        print(result)