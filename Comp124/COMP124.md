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

#### Jumps in Assembly:
* jc    Carry flag is set 
* jnc   Carry flag is clear 
* jz    zero flag is set 
* jnz   zero flag is set 
* js    sign flag is set 
* jns   sign flag is clear 
* jo    overflow flag is set 
* jno   overflow flag is clear 

Comapring Values: 
* cmp is used to compare to values 

Conditional Jumps:
* je    if cmp = cmp 
* jne   if cmp != cmp
* jg    if cpm > cmp
* jle   if cmp <= cmp
* jl    if cmp < cmp
* jge   if cmp >= cmp 

### Variable Addressing Arrays:
* variable is a location in memory 
* wants the address of memeory location 
* lea : loads the address of the variable 

## Subroutines: 
section of code which can be invoked repeatedly as the program continues

### Uses:
* saves effort 
* reduses the size of code 
* share code 
* packages 
* provide ease of access 

Return Addresses:
have to store an address for every call of subroutine 

### Subroutine Parameters 
Value Parameter: needs a value such as integer and/or ascii

Pass by value: compared two values 
calling C library can disrupt counters, so push to the stack to protect it 

## Evolution of Operating Systems 
Driven by the desire to do something which a program cannot

Early systems:
"job" is loaded from punch cards to be thread to a printer 

Batch Systems: 
job passed to human operator 
more efficient 

MultiProgramming: 
Loads several progra,s to run, sharing the cpu 
I/O computational overlaps

### Proccesses and interupts 
* Depends on the ability to interupt at regular clock intervals 

* An interupt
    * automatic call outside program execution 
    * interupt service routines 
    * can take place at any point

Processes:
* algorithm in source program is static
* process in activity performed by a computer is dynamic 

OS Structure: 

Kernel:
* in memory 
* system calls are used to create procesesses 
* uses sudo etc 

System on: 
1. interupt the bootloader 
1. runs diagnostic check 
1. loads os 
1. kernel ceates system processes 
1. user active 

## Oprating System Pyramid:
![pyramid]()

Each manager:
* Monitors
* Enforces polices 
* Allocates resources 
* de-allocate resources 

### Subsystem managers:
Memory Manger:
* Protects the space of memeory which is used by the OS 
* Validates the memory 
* allocates areas of memeory not in use 
* keeps track of user input and actions 
* De-allocate sections if needed

Processor Manager:
* Creates processes 
* performs initisalisation 
* checks status of processes 
* assigns to processes to CPU 
* handles termination of processes 
* manages queues
* handles i/o 
* provide stack memory

Device Manager:
* monitors every device connected to the computer 
* allocates system drivers 
* deals with requests 
* performs communication from one device to another 

File Manager:
* keeps track of files 
* manages the file location
* deals with file functions 

Network Manager:
* printer, disks 
* network stacks 

### Processes:
The OS maintains a **Processor Control Block**

PCB conatins:
    
    * unique process ID 
    
    * userID 
    
    * process state 
    
    * position in memory
    
    * time used 
    
    * register values 
    
    * resources allocated 

#### Process States:

Running: only one process can be executing at a given time and may be interupted if no I/O calls are made 

Ready: refers to a process that is able to run, but does not have CPU 

Waiting: refers to the process that is not able to continue even with CPU 

#### Process Creation:

processes are **spawned**

The original process is called the parent and the new process is called the child

Unix Example: 

Exec() system call allows one process to execute another 

fork() creates a new process 

wait() suspends parent until child terminates

Zombies and Orphans:

If the parent doesn't know that their child has died therefore the child is a **zombie**

If the parent dies before the child, the child is then an **orphan**
