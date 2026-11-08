# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def insertIntoBST(self, root: TreeNode | None, val: int) -> TreeNode | None:
        if not root:
            return TreeNode(val)
        head=root
        while head:
            if head.val<val:
                if head.right:
                    head=head.right
                else:
                    head.right=TreeNode(val)
                    return root
            else:
                if head.left:
                    head=head.left
                else:
                    head.left=TreeNode(val)
                    return root