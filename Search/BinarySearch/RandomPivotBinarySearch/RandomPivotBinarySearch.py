import random
def binarySearch(array, num):
	high = len(array) - 1
	low = 0
	
	while(low <= high):
		pivot = random.randint(low, high)
		if(array[pivot] == num):
			return pivot
		elif(array[pivot] < num):
			low = pivot + 1
		else:
			high = pivot - 1
	return -1

index = binarySearch([0, 1, 5, 4], int(input('Enter a number: ')))

if(index == -1):
	print('Item not found...')
else:
	print('Found at: ' + str(index))
