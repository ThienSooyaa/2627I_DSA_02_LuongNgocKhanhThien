def PostfixToInfix(s):
    stack = []

    for c in s.split():
        if c in {"+", "-", "*", "/"}:
            right = stack.pop()
            left = stack.pop()

            expression = f"( {left} {c} {right} )"
            stack.append(expression)

        else:
            stack.append(c)

    return stack.pop()


if __name__ == "__main__":
    s = input()
    print(PostfixToInfix(s))