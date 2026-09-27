"""
 1.3.9 (*)
Viết một chương trình đọc từ input chuẩn một biểu thức không có các dấu ngoặc mở và in ra biểu thức trung tố tương đương

(biểu thức có đủ các dấu ngoặc đóng). Ví dụ, với input sau:

1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )

chương trình của bạn cần in ra:

( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) )

"""

def convertToInfix(expression):
    stack = []
    for token in expression.split():
        if token == ')':
            right = stack.pop()
            operator = stack.pop()
            left = stack.pop()

            new_expr = f"( {left} {operator} {right} )"
            stack.append(new_expr)

        else:
            stack.append(token)

    return ' '.join(stack)

if __name__=="__main__":
    print("enter the string: ")
    s=input()
    print("the answer is: ")
    print(convertToInfix(s))
           
            