def lca(root, v1, v2):
    head1, head2 = root, root

    stack1 = []
    stack2 = []

    while head1:
        stack1.append(head1)

        if head1.info == v1:
            break
        elif head1.info < v1:
            head1 = head1.right
        else:
            head1 = head1.left

    while head2:
        stack2.append(head2)

        if head2.info == v2:
            break
        elif head2.info < v2:
            head2 = head2.right
        else:
            head2 = head2.left

    while len(stack1) > len(stack2):
        stack1.pop()

    while len(stack2) > len(stack1):
        stack2.pop()

    while stack1 and stack2:
        p1 = stack1.pop()
        p2 = stack2.pop()

        if p1 is p2:
            return p1