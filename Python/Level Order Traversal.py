def levelOrder(self,root):
        #Write your code here
        q = [ root ]
        i = 0
        while i < len(q):
            current = q[i]
            i += 1
            
        for current in q:
            if current:
                print(current.data, end = ' ')
                
                q.append(current.left)
                q.append(current.right)

T=int(input())
myTree=Solution()
root=None
for i in range(T):
    data=int(input())
    root=myTree.insert(root,data)
myTree.levelOrder(root)