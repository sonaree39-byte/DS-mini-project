Stack: 
A stack is a linear data structure that follows the LIFO (Last In First Out) principle.
In the parking system, it is used to manage normal parking slots where the last parked vehicle may need to exit first in a single-lane scenario.
It helps in simple slot allocation and removal operations efficiently.

Heap:
A heap is a tree-based data structure used to manage priority elements efficiently.
In this system, it will be used to manage VIP parking slots where vehicles with higher priority get parking first.
It allows insertion and removal in O(log n) time.

Hash Table:
A hash table stores key-value pairs and allows fast searching.
In this system, vehicle number will be the key and slot number will be the value.
It provides O(1) average time complexity for search operations.
