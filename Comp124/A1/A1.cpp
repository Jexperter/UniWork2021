//201499939
//Jonathan Ash 
#include <stdio.h>
#include <stdlib.h>

int main(void) {
	char msg[] = "How many numbers would you like to enter? ";
	char fmt[] = "%d";
	int z;
	char num[] = "Please enter a number: ";
	char numin[] = "%d";
	int n;
	int pos = 0;
	char positive[] = "Positive: %d\n";
	int negit = 0;
	char negative[] = "Negative: %d\n";
	char zero[] = "Zero: %d\n";
	signed int zeroed = 0;
	char space[] = "\n";
	char line[] = "- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n";



	_asm {
		
		lea eax, msg 
		push eax 
		call printf //Prints opening message 
		pop eax
		lea eax, z
		push eax 
		lea eax, fmt 
		push eax 
		call scanf //Asks for user input 
		add esp, 8
		
		mov ecx, z
	numinput: 
		push ecx
		je end  
		lea eax, num
		push eax
		call printf //Prints output 
		pop eax 
		lea eax, n //Setting n to the top of the stack
		push eax 
		lea eax, numin //Allowing for user input 
		push eax
		call scanf //retreives n which is at the top of the stack  
		add esp, 100 
		lea eax, space 
		push eax 
		call printf 
		pop eax 
		pop ecx
	
		
		//Start of comparing values 
		mov eax, n
		mov ebx, 0 //set eax to 0 
		cmp eax, ebx // compare two vars
		jg posi //if n > 0 then... 
		jl negi // if n < 0 then...
		je zer //if n = 0

		 		

	posi:
		mov eax, pos
		inc eax //Increases pos var by 1
		mov pos, eax
		loop numinput
	
	negi:
		mov eax, negit
		inc eax// Increases neg var by 1
		mov negit, eax
		loop numinput 
	
	zer:
		mov eax, zeroed 
		inc eax //Increases zero var by 1
		mov zeroed, eax 
		loop numinput
			
	end:
		lea eax, line 
		push eax //adding some user interface, pushing onto stack 
		call printf 
		pop eax 
		push pos
		lea eax, positive
		push eax
		call printf //calling print on the values in the stack 
		add esp, 100
		push negit
		lea eax, negative
		push eax
		call printf
		add esp, 100
		push zeroed 
		lea eax, zero 
		push eax 
		call printf 
		pop eax 
		pop zeroed 

	}

	return 0; 
}
