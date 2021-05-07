# COMP124 - Revsion Notes :computer:

## Overview of system architecture:

### A personal computer:
    * A uses a computer for many things, these inclue Websites, emails these are called system apps.

### A modern system:
#### CPU:
    * Fetches instructions from memory  
    * Synchronised by a fast clock, 3GH clock = 3 billion cycles 

#### The System Bus:
    * Allows all components to talk to each other via a **"bus"**
    * Point to point: quite expensive and complicated 
    * Split into: 
        * Address lines
        * Data lines 
        * Control lines 

#### Memory:
    * RAM, cheap, volatile
    * ROM, boot system code 
    * Flash, read and write for files 
    
    A 32 bit system points data to 4 bytes of memory worth data.
    Least significant it = 0 bit on the right ->
    Most significant bit = 32 bit on the left <-


### The CPU Fetch Cycle: 
    > Very fast 
    > Direct Access
    > Register ->  points to a memory address

#### Registers:
    * Instruction Pointer -> points to the next point in memory 
    * Instruction register -> holds current point in memory
##### The step by step process:
    * Step 1: Copy the address in instruction pointer to the memeory address register 
    * Step 2: Arrives in the memory direct register, copied to the instruction register 
    * Step 3: Decodes whats in the instruction register 
    * Step 4: Uses the arithmetic logic unit to fetch operands 
    * Step 5: Carried out execution 
    * Step 6: Loop back to Step 1

### Machine Language sets:
    * Data transfer:
        * Load, pop, store
    * Arithmetic 
        * Add, sub, sum 
    * Logical
        * xor, shift, and, or 
    * Control flow 
        * jmp, loop 

### Assembly Programming:
    EAX: Accumulator register 
    EBX: Base register 
    ECX: Counter register 
    EDX: Data register 

### Example of low level assembly code: 

    ```Assembly 
    mov eax, count1 
    add eax, count2
    sub eax, 10
    mov num, eax 
    num = count1 + count2 - 10
    ```
#### Flag registers:
    * -s (positive, negative)
    * -z (if result is zero)
    * -c (carrying the zero flag)

