def recursiveBinarySearch(array, num, low, high):
	if(low <= high):
		mid = int(low/2 + high/2)
		if(array[mid] == num):
			return mid
		elif(array[mid] < num):
			return recursiveBinarySearch(array, num, low, mid-1)
		else:
			return recursiveBinarySearch(array, num, mid+1, high)
	else:
		return -1


array = [20,15,5]

index = recursiveBinarySearch(array, int(input('Enter a number : ')), 0, len(array)-1)

if(index == -1):
	print('Nothing found')
else:
	print('Number found at index : ' + str(index))

