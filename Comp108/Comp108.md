# Comp108 - Revsion Notes: 

## PseudoCode:
What is an algorithm?
A sequence of precise and concise instructions that guid to solve a specific problem in a finite amount of time 

### Example: Comput the nth power:
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




