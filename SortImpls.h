//----------------------------------------------------------------------------
//Developer:	Odiscious Dozier
//Instructor:	Prof. Bob Dimpsey
//Course:		CSS 342
//Date:			NOV 12, 2014
//Assumptions:
//all input data is of correct format

#include <vector>
#include <string>
#include <iostream>
#include <fstream>
#include <stdio.h>
#include <ctype.h>
#include <conio.h>

using namespace std;

//----------------------------------------------------------------------------
//BubbleSort
//Sorts the items in an array into ascending order
//params: ref to a vector, starting index, and ending index
void BubbleSort(vector<int> &items, const int start, const int end)
{
	bool sorted = false;

	int pass = 1;
	while(!sorted && (pass < end))
	{
		sorted = true;
		for(int index = start; index < end; index++)
		{
			int nextIndex = index + 1;
			if(items[index] > items[nextIndex])
			{
				std::swap(items[index], items[nextIndex]);
				sorted = false;
			}
		}
		pass++;
	}
}

//----------------------------------------------------------------------------
//InsertSort
//Sorts the items in an array into ascending order
//params: ref to a vector, starting index, and ending index
void InsertSort(vector<int> items, const int start, const int end)
{
	for(int unsorted = start; unsorted < end; unsorted++)
	{
		int nextItem = items[unsorted];
		int loc = unsorted;
		while((loc > 0) && (items[loc-1] > nextItem))
		{
			swap(items[loc], items[loc-1]);
			loc--;
		}
		items[loc] = nextItem;
		//moved loc-- inside the while loop.  This is a flaw in the book.
	}
}

//----------------------------------------------------------------------------
//merge
//Merges two sorted array segments, into one sorted array
//params: ref to a vector, starting index, middle index, ending index
void merge(vector<int> &items, const int start, const int mid, const int end)
{
	vector<int> tempVector(items.size(), 0); //max size of array
	int first1 = start;
	int last1 = mid;
	int first2 = mid + 1;
	int last2 = end;

	int index = first1;
	while((first1 <= last1) && (first2 <= last2))
	{
		if(items[first1] <= items[first2])
		{
			tempVector[index] = items[first1];
			first1++;
		}
		else
		{
			tempVector[index] = items[first2];
			first2++;
		}
		index++;
	}
	while(first1 <= last1)
	{
			tempVector[index] = items[first1];
			first1++;
			index++;
	}
	while(first2 <= last2)
	{
			tempVector[index] = items[first2];
			first2++;
			index++;
	}
	for(index = start; index <= end; index++)
	{
		items[index] = tempVector[index];
	}
}

//----------------------------------------------------------------------------
//median3
//Calculates the center index
//Compares and assigns the correct value to be swapped into the center
//params: ref to a vector, starting index, ending index
int median3(vector<int> &arIntegers,int left,int right)
{
 	int center = (left+right)/2;

   if(arIntegers[center] < arIntegers[left])
   	swap(arIntegers[left],arIntegers[center]);
   if(arIntegers[right] < arIntegers[left])
   	swap(arIntegers[left],arIntegers[right]);
   if(arIntegers[right] < arIntegers[center])
   	swap(arIntegers[center],arIntegers[right]);

   swap(arIntegers[center],arIntegers[right-1]);

   return center;
}

//----------------------------------------------------------------------------
//partition
// This function takes an array (or one half an array) and sorts it.
// It then returns a new pivot index number back to quicksort.
//params: ref to a vector, starting index, ending index, pivot index number
int partition(vector<int> &arIntegers, int left, int right, int pivot)
{
     int pivotValue = arIntegers[pivot];

     // Swap it out all the way to the end of the array
     // So we know where it always is.
     swap(arIntegers[pivot], arIntegers[right]);
     int storeIndex = left;

     // Move through the array from start to finish comparing each to our
     // pivot value (not index, the value that was located at the pivot index)
     for (int i = left; i < right; i++)
     {
         if (arIntegers[i] <= pivotValue)
         {
             swap(arIntegers[i], arIntegers[storeIndex]);
             storeIndex++;
         }
     }
     swap(arIntegers[storeIndex], arIntegers[right]);
     return storeIndex;
}

//swap
// Simple swap function for our in place swapping.
//params: two values to compare, passed by ref
void swap(int &val1, int &val2)
{
    int temp = val1;
    val1 = val2;
    val2 = temp;
}
void MergeSort(vector<int> &items, const int start, const int end)
{
	if(start < end)
	{
		int mid = start + (end - start)/2;

		MergeSort(items, start, mid);

		MergeSort(items, (mid + 1), end);

		merge(items, start, mid, end);
	}
}

//----------------------------------------------------------------------------
//QuickSort
// Quicksort controller function, it partitions the different pieces of our array.
//params: ref to a vector, starting index, ending index
void QuickSort(vector<int> &arIntegers, int left, int right)
{
    if (right > left)
    {
         int pivotIndex = median3(arIntegers,left,right);
         int pivotNewIndex = partition(arIntegers, left, right, pivotIndex);

         // Recursive call to quicksort to sort each half.
         QuickSort(arIntegers, left, pivotNewIndex-1);
         QuickSort(arIntegers, pivotNewIndex+1, right);
    }
}

//----------------------------------------------------------------------------
//IterativeMergeSort
//Improved version of MergeSort
//a non-recursive method and 
//using only one additional array (instead of one array on each recursive call). In this improved
//version of MergeSort, IterativeMergeSort, one would merge data from the original array into 
//the additional array and alternatively copy back and forth between the original and the 
//additional temporary array. 
//params: ref to a vector, starting index, ending index
void IterativeMergeSort(vector<int> &arIntegers, int start, int finish)
{
	int N = arIntegers.size();
	for(int size = 1; size < N; size += size)
	{
		for(int low = 0; low < N-size; low += size + size)
		{
			merge(arIntegers, low, low + size - 1, min(low + size + size - 1, N - 1));
		}
	}
}

