#Làm trên Leetcode

def isValidBST(self, root: TreeNode | None) -> bool:
    def check(node,low,high):
        if not node:
            return True
        elif node.val>=high or node.val<=low:
            return False
            
        left=check(node.left,low,node.val)
        right=check(node.right,node.val,high)

        return left and right

    return check(root,float("-inf"),float("inf"))



