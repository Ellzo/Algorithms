#Function to perform classic (iterative) binary search
def iterativeBinarySearch(array, num):
	#Initial value of low is 0 (Index of first element)
	low = 0
	#Initial value of high is array's length - 1 (Last element index)
	high = len(array)-1
	
	while low <= high:
		#Mid gets the middle value between low and high
		mid= int(high/2 + low/2)
		
		#If element at mid equals num, return mid
		if array[mid] == num:
			return mid

		#If element at mid is less than num, elemenate the left part
		elif array[mid] < num:
			low = mid + 1
			
		#If element at mid is larger than num, elemenate the right part
		else:
			high = mid - 1
		
	#Return -1 if num not found
	return -1


#Sample array
array= [-20, -15, 1, 6, 35]

#Get the returned value from iterativeBinarySearch function and store it in a variable
index= iterativeBinarySearch(array, int(input('Enter a number: ')))

#If index equals -1, nothing found
if index == -1:
	print('Number not found')
	
#If index is not equal -1, number found
else:
	#Print number to the user
	print('Number found at index: ' + str(index))
