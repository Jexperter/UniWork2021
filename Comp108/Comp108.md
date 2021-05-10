# Comp108 - Revsion Notes: 

## PseudoCode:
What is an algorithm?
A sequence of precise and concise instructions that guid to solve a specific problem in a finite amount of time 

### Example: Compute the nth power:
1. input: number x and non negative value n 
2. set p to 1
3. repeat while p = px
4. output p

PseudoCode:
```
sum = 1
i = 0
while (i <= n) do 
    begin
        sum *= 1
        i  * = 1
    end 
output sum
```         
TOP TIP:
When trying to work out what the code does, add a variable such as n = 5 then work it out systematically 

## Algorithm Efficiency:
Why does it matter:
* Speeds up the computation
* efficency matters 
* Demands a great increase 

Time:  1. increased speed of computation 
* run  2. Waste of time to cheat 
* measure 

Efficiency (Questions):
If we doubled the input size, how long would it take?
If we doubled the speed, how much can be transferred? 

### Scenario:
* An algorithm takes n² comparisons to sort n
* We need 1 second to sort 5 numbers 
* 1 sec => 25 \* 100 
* 1 sec => 2500 
* If we increase the numbers sorted to 50, the algorithm would not be efficient 

## Hierachy of functions: 

1         |  log n     |  n²         |    2^n
----------  ----------  ------------  -------------
Constant    log         polynomial      exponential 

## Data Structures:
Dynamic Data:
    Data may grow or change over time

Operations
* Search    
* Insert 
* Delete    
* Maximum

### Arrays: 
* has an index
* size n where A[0, N]
* out of bounds if out of range 
```
sum = 0, i = 1
while (i <= n) do 
    begin
        sum = sum + A[i]
        i = i + 1
    end 
output sum
```

#### Sequential Search:
* input: N numbers into an array 
* input: if key is in array 
* algorithm checks for key 

```
i = 0
found = false
while (i <= n and !found) do
    begin
        if (key == A[i]) then
            found = true;
        else 
            i++
    end
    if (found) then 
        output "found"
    else 
        output "not found"
```            
#### Binary Search:
    * Accending order 
    * compares the key to the middle 
    * reduces number by a half 

```
first = 1
last = 1
found = false
while (first <= last and !found) do
    begin
        if (key < A[i]) last = m - 1
        if (key > A[i]) first = m + 1 
    end 
```    

### Stacks and queues:
Queue: first in, first out 

Stack: first in, last out 

Enqueue: increments tail, decrements head
Dequeue: increments head, decrements tail 

Enqueue(Q, x)
```
Q[tail] = x
tail = tail + 1
```
Dequeue(Q)
```
x = Q[head]
head = head + 1
return x
```

Push: adds a value to the top

Pop: removes a value from the top

Push(S, x)
```
top = top + 1
S[top] = x
```
Pop(S)
```
top = top - 1
S[top] = x
```
### Linked Lists:
Traversing:
```
node = head 
while (node != null) do 
    begin 
        output node.data 
        node = node.next
end 
```
Searching:
```
found = false;
node = head 
while (node != null and !found) do
    begin
        if (node.data == key) then
            found = true
        else 
            node = node.next;
end    
``` 
#### Bubble Sort:
Starts from the first element and swaps adjacent items if not in acending order, the last item is the largest 
```
for (i = n downto 2) do 
    for (j = 1 to i-1) do
        begin
            if (A[j] > A[j+1]) then 
                swap(A[j] & A[j+1])
            j = j + 1    
        end
    i = i + 1    
end        
```
Time Complexity: O(n^2)   
#### Selection Sort:
```
i = 1
while (i <= n) do
    begin 
        loc = i
        j = i + 1;
        while (j <= n) do
            begin
                if (A[j] < A[loc]) then
                    loc = j
                j = j + 1
            end
        swap (A[i], A[loc])
        i = i + 1
end   
```
Time Complexity: O(n^2)  
#### Insertion Sort: 
```        
for (i = 2 to n) do 
    begin
        key = A[i]
        loc = 1
        while (loc < I and A[loc] < key) do 
            loc = loc + 1
        for (j = 1 downto loc + 1) do 
            A[j] = A[j-1]
        A[loc] = key
end 
```
Time Complexity: O(n^2)
### Trees:
A tree T = (V, E) consists of vertices V and a set of edges E such that for any pair of vertices U, there is exactly one path between u and v
![tree](https://github.com/jash2002/UniWork2021/blob/main/Comp108/images/2021-05-08%2018_22_53-Lecture%2017%20-%20Trees%20(Part%20I%20basics)_%20202021-COMP108%20-%20Data%20Structures%20and%20Algorit.png)
* There is exactly one path between any two vertices 
* T is connected and there is no cycle in T 
* T is connected and removal of one edge disconnects T 
* T is acyclic and adding one edge creatred a cycle 
* T is connected and m = n - 1 (where n = |V|, m = |E|)

#### Proof of Lemma:
Base case: a tree with single vertex has no edges 
induction step: p(n - 1) => p(n) for n > 1

#### Rooted trees: 
* Top vertex is called root
* A vertex U may have some children , u is called the parent 
* Degree of a vertex is the number of children it has 
* A vertex with no children is called a leaf 

#### Binary Trees:
* A degree of two at most 
* two subtrees 
* 3 Ways to traverse a binary tree

**preoder - (Vertex, Left, Right)**

**inorder - (Left, Vertex, Right)**

**postorder - (Left, Right, Vertex)** 

### Graphs: 
An undirected graph G = (V, E), each edge is an unordered pair of vertice {c,b} = {b,c}.
![undirected graph](https://github.com/jash2002/UniWork2021/blob/main/Comp108/images/2021-05-08%2018_56_19-Lecture%2020%20-%20Graphs%20(Part%20I%20%26%20II%2C%20basics%2C%20representation)_%20202021-COMP108%20-%20Data.png)

A directed graph G = (V, E), each edge is an ordered pair of vertices {c,b} != {b,c} 
![directed graph](https://github.com/jash2002/UniWork2021/blob/main/Comp108/images/directedgraph.png)

A graph is simple if it doesn't have a self loop 

A graph is multigraph if it has multiple connections to each node 

In an undirected graph g, suppose that e = {u,v} is an edge of G 
* u and v are called endponts of e
* e is said to be incident with u and v
* e is said to connect u and v 
* The degree of a vertex is the number of connections coming from that node 

#### Representation of undirected graphs:
* An undirected graph can be represented by adjacent matrix, adjacent list, incidence list, incidence matrix 

When we have a graph with n vertices we use a n x n matrix 

#### Adjacent Matrix: 
* Matrix can only contain 0 or 1 
* If there is a connection between them then 1 
* if there is no connection then 0 

#### Incidence Matrix: 
* Matrix can only contain 1 or 0 
* If number is connected by node then 1 else 0 

#### Undirected graph - paths and circuits:
![a path](https://github.com/jash2002/UniWork2021/blob/main/Comp108/images/graph.png)
if u = v then the path is called a cycle 

#### Euler Circuit 
* A simple circuit visits each edge at most once 
* An euler circuit is a circuit visiting every edge exactly once 

A trivial condition: 
* The graph must be connected 
* find a circuit in the graph 
* expand a node in the graph 

### Greedy Algorithm:
* input: Given n items with weights and values and a knapsack with capacity W 
* output: Find the most valuebale subset of items that can fit into the knapsack 
* Applications: A transport plane is to deliver the most valuable items  

Exhaustive algorithm: 
* Try every subset of n items 
* compute total weight of subset 
* compute total value 

#### Minimun Spanning Tree:
Given an undirected graph G 

* The dges are labelled by weight 

Spanning tree of G 

* Contains all vertices in G 

Minimum spanning tree:

* Tree with lowest weight 

#### Kruskal Algorithm: 
* Look at the whole graph, find edge with minimum weight 
* Find 2nd minimum weight edge 
* keep finding the minimum weight 
* continue until there is a cycle 
Time Complexity: O(mlogm)

#### Single Source Path: 
Given a particular vertex called the source 

* Find the shortest path from the source to all other vertices(smallest weight )

#### Dijkstra Algorithm:
* chose an edge adjacent to any of the chosen vertices such that cost of path to source is minimum


### Divide and Conquer Algorithms: 
[4 6 3 2 8 7 5 1]

* Divide into two groups 

[4 6 3 2] [8 7 5 1]

[4 6] [3 2] [8 7] [5 1]

*Add the two numbers and keep going 

Time complexity: O(n)

#### Merge Sort Algorithm:
* Divide conquer 
* divide sequence into two halves 
* sort the two halves
* merge the sorted paths 

```
assume n is a power of 2
Mergesort(A[i..n]) 
if n > 1 then 
    begin 
        copy A[1..n/2] to B[1..n/2]
        copy A[(n/2+1)..n] to C[1..n/2]
    merge(B)
    merge(C)
    merge(A, B, C)
end
```
Each node takes O(r) time when there is r integers 
Each level takes O(n) time because of total numbers inside is n 
There are O(log n) levels 
Overall: O(n log n) time 

#### Fibonacci Numbers:
![fib](https://github.com/jash2002/UniWork2021/blob/main/Comp108/images/fib.png)

### Dynamic Programming:
* Add the children to get the parent number 
8 Time complexity: O(n)

#### Assembly Line Problem
![assembly line](https://github.com/jash2002/UniWork2021/blob/main/Comp108/images/ass.png)
Lines represent transfer time = cost





















