def priority(s):
    if s in {"*", "/"}:
        return 3
    elif s in {"+", "-"}:
        return 2
    elif s.isdigit():
        return 0
    elif s == "(":
        return 1


def InfixToPostfix(s):
    queue = []
    stack = []

    for i in range(len(s)):
        c = s[i]

        if c == ")":
            while stack and stack[-1] != "(":
                queue.append(stack.pop())

            if stack:
                stack.pop()

        elif c == "(":
            stack.append(c)

        elif priority(c) == 0:
            queue.append(c)

        else:
            while stack and stack[-1] != "(" and priority(stack[-1]) >= priority(c):
                queue.append(stack.pop())

            stack.append(c)

    while stack:
        queue.append(stack.pop())

    for i in queue:
        print(i, end="")


if __name__ == "__main__":
    s = input().split()
    InfixToPostfix(s)