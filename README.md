# B-Tree Implementation in Java

## Description

This project implements a B-Tree data structure using Java.

A B-Tree is a self-balancing tree data structure in which each node can contain multiple keys and multiple children.

B-Trees are commonly used in databases and file systems because they can efficiently store and search large amounts of data.

## Features

- Create a B-Tree
- Insert elements
- Search for an element
- Traverse the B-Tree
- Automatically split full nodes
- Maintain the B-Tree properties

## Technologies Used

- Java
- Data Structures
- B-Tree
- Object-Oriented Programming

## B-Tree Properties

For a B-Tree with minimum degree `t`:

- Maximum number of keys in a node = `2t - 1`
- Minimum number of keys in a non-root node = `t - 1`
- Maximum number of children = `2t`
- Keys in every node are stored in sorted order.
- All leaf nodes are at the same level.
- When a node becomes full, it is split.

##   Algorithm for B-Tree Insertion
Start with an empty B-Tree.
Create the root node when the first element is inserted.
Check whether the root node is full.
If the root is not full:
Insert the new key into the appropriate position.
If the root is full:
Create a new root.
Split the old root into two nodes.
Move the middle key to the new root.
Insert the new key into the appropriate child.
While inserting into a non-leaf node:
Find the appropriate child.
Check whether the child is full.
If the child is full, split the child.
Move the middle key to the parent.
Continue insertion into the correct child.
Keep all keys in sorted order.
Continue until the key is inserted.
Algorithm for Searching
Start from the root.
Compare the search key with the keys in the current node.
If the key is found, return the node.
If the current node is a leaf and the key is not found, return false.
Otherwise, select the appropriate child.
Repeat the process until the key is found or a leaf node is reached.
Algorithm for Traversal
Start from the root.
Visit the left child.
Print the current key.
Visit the next child.
Continue until all keys are visited.
The traversal displays the keys in sorted order.
Example Tree

After inserting:

10, 20, 5, 6, 12, 30, 7, 17

The B-Tree can be represented as:

             [10, 20]
            /    |    \
       [5,6,7] [12,17] [30]
Output
B-Tree traversal:
5 6 7 10 12 17 20 30

Key 12 found
Time Complexity
Operation	Time Complexity
Search	O(log n)
Insertion	O(log n)
Traversal	O(n)
Node Splitting	O(t)
Space Complexity
O(n)

where n is the number of keys stored in the B-Tree.

Advantages
Efficient searching
Efficient insertion
Keeps the tree balanced
Suitable for large amounts of data
Reduces the number of disk accesses
Used in databases and file systems
Applications

B-Trees are commonly used in:

Database indexing
File systems
Disk storage systems
Search systems
Large-scale data storage
How to Run
1. Compile the program
javac BTree.java
2. Run the program
java BTree
Conclusion

The B-Tree implementation demonstrates how a balanced multi-way tree can efficiently perform insertion, searching, and traversal.

The automatic splitting of full nodes ensures that the tree remains balanced and provides efficient operations.

Author

K.Anuananda


