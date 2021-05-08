
//
// Note: You are allowed to add additional methods if you need.
// Coded by Prudence Wong 2021-03-06
//
// Name: Jonathan Ash
// Student ID: 201499939
// MWS username: sgjash
//
// Time Complexity and explanation:
// f denotes initial cabinet size
// n denotes the total number of requests
// d denotes number of distinct requests
// You can use any of the above notations or define additional notation as you wish.
//
// appendIfMiss(): There is a for loop which loops through the elements of the array size f, there is also another for loop which implements sequential search of size n, when there
// are misses inside the list, the a node is created, containing the data of the missed element. O(nf) is the time complexity due to the nested loop.
//
// moveToFront(): There is a for loop with a nested while loop. The for loop loops through array size f and the while loop which traverses through the linked list of size n, for every
// element requested, that element is moved to the front of the list, the time complexity for this is O(nf).
//
// freqCount(): There is two for loops as part of this class, one which goes up to f and another which iterates upto n. In addition to this there is also another part of the class which
// uses an algorithm called bubblesort, the time complexity of this is f^2. The time complexity overall of this algorithm is O(nf + f^2).
//

class COMP108A2Cab {

	public COMP108A2Node head, tail;

	public COMP108A2Cab() {
		head = null;
		tail = null;
	}

	// append to end of list when miss
	public COMP108A2Output appendIfMiss(int rArray[], int rSize) {
		COMP108A2Output output = new COMP108A2Output(rSize);

		COMP108A2Node curr;
		boolean found;
		int i, key, count;


		for(i = 0; i < rSize; i++) {
			
			found = false;
			count = 1;
			curr = head;
			
			while (curr != null) {
				//If key is found, set to true then break out the loop
				if (curr.data == rArray[i]) {
					found = true;
					break;
					
				}
				//Else move curr to the next node along
				curr = curr.next;
				//Add one to the count
				count++;
			}
			
			if (found) {
				//Increase hit count, make count the i index
				output.compare[i] = count;
				output.hitCount++;
			} else {
				//Not found so count has to be total - 1
				output.compare[i] = count - 1;
				output.missCount++;
				//Insert tail
				insertTail(new COMP108A2Node(rArray[i]));
			}
		}
		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		return output;
	}

	// move the file requested to the beginning of the list
	public COMP108A2Output moveToFront(int rArray[], int rSize) {
		COMP108A2Output output = new COMP108A2Output(rSize);

		COMP108A2Node curr;
		boolean found;
		int i, count;
		
		


		for (i = 0; i < rSize; i++) {
			
			found = false;
			count = 1;
			curr = head;
			
			while (curr != null) {
				//No need to move if the current node is already the head
				if (head.data == rArray[i]) {
					found = true;
					break;

				//If current node is equal to the key
				} else if (curr.data == rArray[i]) {
					found = true;
					
					//Using lab 7 notes and solution 
					if (curr != head) { 
					curr.prev.next = curr.next;
						if (curr == tail) {
							tail = curr.prev;
						} else {
							curr.next.prev = curr.prev;
						}
					}	
					//Inserts current node into the head
					insertHead(curr);
					break;
				}
				curr = curr.next;
				count++;
			}
			
			if (found) {
				output.compare[i] = count;
				output.hitCount++;

			} else {
				output.compare[i] = count - 1;
				output.missCount++;
				insertHead(new COMP108A2Node(rArray[i]));
			}
		}
		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		return output;
	}

	// move the file requested so that order is by non-increasing frequency
	public COMP108A2Output freqCount(int rArray[], int rSize) {
		COMP108A2Output output = new COMP108A2Output(rSize);

		COMP108A2Node curr;
		boolean found;
		int i, count;

		//For loop to loop through the array
		for(i = 0; i < rSize; i++) {
			
			found = false;
			count = 1;
			curr = head;
			
			//Loops through the linked list
			while (curr != null) {
				if (curr.data == rArray[i]) {
					found = true;
					//Increases the frequency by 1 for every time the key is found
					curr.freq++;
					break;
				}
					curr = curr.next;
					count++;
				}
			
			if (found) {
				output.compare[i] = count;
				output.hitCount++;
				bubble();
			} else {
				output.compare[i] = count - 1;
				output.missCount++;
				insertTail(new COMP108A2Node(rArray[i]));
			}
		}
		
		bubble();
		//Bubble sort is used to arrange the frequency from highest to lowest, there are other algorithms such as
		//Merge sort and insertion search
		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		output.cabFromHeadFreq = headToTailFreq();
		return output;
	}


	//Helper methods

	public void swap(COMP108A2Node a, COMP108A2Node b) {
		//Swaps two nodes and their coresponding values
		int temp1, temp2;
		
		temp1 = a.data;
		temp2 = a.freq;
		a.data = b.data;
		a.freq = b.freq;
		b.data = temp1;
		b.freq = temp2;
	}

	//Using notes from lecture 14 
	public void bubble() {
		COMP108A2Node curr, last;

		//make sure the linked list isn't empty
		if (head != null) {
			curr = head;
			last = null;

		//Loops through the linked list
		while (curr.next != last) {
			while (curr.next != last) {
				//If the current frequency is smaller than the next, swap the nodes, this continues until tail has been reached
				if (curr.freq < curr.next.freq) {
					swap(curr, curr.next);
				}
				
				curr = curr.next;
			}
				last = curr;
				curr = head;
			}
		}
	}

	// DO NOT change this method
	// insert newNode to head of list
	public void insertHead(COMP108A2Node newNode) {

		newNode.next = head;
		newNode.prev = null;
		if (head == null)
			tail = newNode;
		else
			head.prev = newNode;
		head = newNode;
	}

	// DO NOT change this method
	// insert newNode to tail of list
	public void insertTail(COMP108A2Node newNode) {

		newNode.next = null;
		newNode.prev = tail;
		if (tail != null)
			tail.next = newNode;
		else head = newNode;
		tail = newNode;
	}

	// DO NOT change this method
	// delete the node at the head of the linked list
	public COMP108A2Node deleteHead() {
		COMP108A2Node curr;

		curr = head;
		if (curr != null) {
			head = head.next;
			if (head == null)
				tail = null;
			else
				head.prev = null;
		}
		return curr;
	}

	// DO NOT change this method
	// empty the cabinet by repeatedly removing head from the list
	public void emptyCab() {
		while (head != null)
			deleteHead();
	}


	// DO NOT change this method
	// this will turn the list into a String from head to tail
	// Only to be used for output, do not use it to manipulate the list
	public String headToTail() {
		COMP108A2Node curr;
		String outString="";

		curr = head;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.next;
		}
		return outString;
	}

	// DO NOT change this method
	// this will turn the list into a String from tail to head
	// Only to be used for output, do not use it to manipulate the list
	public String tailToHead() {
		COMP108A2Node curr;
		String outString="";

		curr = tail;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.prev;
		}
		return outString;
	}

	// DO NOT change this method
	// this will turn the frequency of the list nodes into a String from head to tail
	// Only to be used for output, do not use it to manipulate the list
	public String headToTailFreq() {
		COMP108A2Node curr;
		String outString="";

		curr = head;
		while (curr != null) {
			outString += curr.freq;
			outString += ",";
			curr = curr.next;
		}
		return outString;
	}

}
