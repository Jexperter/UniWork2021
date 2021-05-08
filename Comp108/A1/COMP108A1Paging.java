//
// Note: You are allowed to add additional methods if you need.
// Coded by Prudence Wong 2020-12-15
//
// Name: Jonathan Ash
// Student ID: 201499939
//
// Time Complexity and explanation: You can use the following variables for easier reference.
// n denotes the number of requests, p denotes the size of the cache
// n and p can be different and there is no assumption which one is larger
//
// noEvict(): Two for loops, both adding 1 to the temporary variable thus making it O(n^2). If there is a match in the p then there
//is a hit. If there is a miss in p then there is a miss, We increment by both i++ and j++ which is why the time complexity is O(ij) or O(n^2)
//
// evictFIFO():Two while loops, i starts at 0 and j starts at 0. The time complexity is O(n^2) where O(ij) is the variables from the loops. Dequeue has time
//complexity of O(1). The time complexity overall is O(n^2)
//
//
// evictLFU(): Two while loops, i loops through n and, j loops through p, both increment by 1, time complexity is O(n^2).
//
// evictLFD():
//

class COMP108A1Paging {

	//Personal methods
	public static int head;

	static int isFound(int[] cArray, int cSize, int[] rArray, int i) {

		int j;//Checking for hit, miss patterns

		j = 0;

		while (j < cSize) {
			if (rArray[i] == cArray[j]) { //Searching for requests inside cache
				return j; //If there is a miss, it won't return j
			}
			j++;
		}
		return j;
	}

	static int findMin(int[] cArray, int cSize) {

		int i, min, index;

		i = 0;
		min = cArray[0];
		index = 0;

		while (i < cSize) {
			if (cArray[i] < min)
				//checks if there is a minimum smaller than the current minimum
				min = cArray[i];
			index = i;
			//return index of the array
			i++;

		}
		return index;
	}

	static int[] findFrequency(int cSize) {

		int i;
		int[] frequency;

		frequency = new int[cSize];
		i = 0;

		while (i < cSize) {
			frequency[i] = 1;
			i++;
		}
		return frequency;
		//Sets all frequencies of size csize, to 1
	}


	// no eviction
	// Aim:
	// do not evict any page
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output noEvict(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();

		int i;
		int found;

		i = 0;

		while (i < rSize) {
			found = isFound(cArray, cSize, rArray, i); //Uses helper method to search through the cache array for the requests
			//and returns if there is found
			if (found < cSize) {
				output.hitCount++;
				output.hitPattern += 'h';
			} else {
				output.missCount++;
				output.hitPattern += 'm';
			}
			i++;
		}
		return output;

	}

	// evict FIFO
	// Aim:
	// evict the number present in cache for longest time if next request is not in cache
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output evictFIFO(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();

		int i;
		int found;

		i = 0;
		head = 0;
		//index of the start of the array, to be used when replacing requests inside the cache array

		while (i < rSize) {
			found = isFound(cArray, cSize, rArray, i);
			if (found < cSize) {
				output.hitCount++;
				output.hitPattern += 'h';
			} else {
				//If not in the array, replace the cache with the hit then increment head by 1
				cArray[head] = rArray[i];
				head = (head + 1) % cSize;
				output.missCount++;
				output.hitPattern += 'm';
			}
			i++;
		}
		return output;
	}


	// evict LFU
	// Aim:
	// evict the number that is least frequently used so far if next request is not in cache
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the request sequence with rSize entries
	static COMP108A1Output evictLFU(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();

		int i, min;
		int found;
		int[] frequency;

		i = 0;

		while (i < rSize) {
			found = isFound(cArray, cSize, rArray, i);
			frequency = findFrequency(cSize);
			if (found < cSize) {
				//Increase frequency of index j by 1
				frequency[found]++;
				output.hitCount++;
				output.hitPattern += 'h';
			} else {
				//Find the min of frequency array, then replace that with the request[i], then set that frequency to 1
				min = findMin(frequency, cSize);
				cArray[min] = rArray[i];
				frequency[min] = 1;
				output.missCount++;
				output.hitPattern += 'm';
			}
			i++;
		}
		return output;
	}


	// evict LFD
	// Aim:
	// evict the number whose next request is the latest
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output evictLFD(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();

		return output;
	}
}

