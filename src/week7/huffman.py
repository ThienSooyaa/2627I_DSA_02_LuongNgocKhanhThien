import heapq

# Class to represent Huffman tree node
class Node:

    # Leaf node
    def __init__(self, d, i, left=None, right=None):
        # frequency
        self.data = d  
        
        # smallest original index in subtree
        self.index = i  
        
        # smallest original index in subtree
        self.left = left
        self.right = right

# Function to traverse tree in preorder
# manner and push the Huffman representation
# of each character.
def preOrder(root, ans, curr):
    if root is None:
        return

    # Leaf node represents a character.
    if root.left is None and root.right is None:
        # single character case
        if curr == "":
            curr = "0" 
        ans.append(curr)
        return

    preOrder(root.left, ans, curr + '0')
    preOrder(root.right, ans, curr + '1')

def huffmanCodes(s, freq):
    
    n = len(s)
    
    # Min heap for Node class.
    pq = []

    for i in range(n):
        # include index
        tmp = Node(freq[i], i) 
        heapq.heappush(pq, (tmp.data, tmp.index, tmp))

    # single character
    if n == 1:
        return ["0"]

    # Construct Huffman tree.
    while len(pq) >= 2:
        
        # Left node
        f1, i1, l = heapq.heappop(pq)
        
        # Right node
        f2, i2, r = heapq.heappop(pq)
           
        # internal node with freq + index   
        newNode = Node(l.data + r.data, min(l.index, r.index), l, r) 
        heapq.heappush(pq, (newNode.data, newNode.index, newNode))

    root = pq[0][2]
    ans = []
    preOrder(root, ans, "")
    return ans

# Example usage
if __name__ == "__main__":
    s = "abcdef"
    freq = [8,77,20,14,9,65]
    ans = huffmanCodes(s, freq)
    for i in range(len(ans)):
        print(ans[i], end=" ")