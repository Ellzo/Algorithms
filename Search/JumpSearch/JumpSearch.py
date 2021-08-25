import math
def jumpSearch(array, num):

	if(array[0] > num or array[len(array)-1] < num):
		return -1
		
	jumpSize = int(math.sqrt(len(array)))
	i = 0
	while(i < len(array)):
		if(array[i] == num):
			return i
		elif(array[i] >= num):
			return linearSearch(array, num, i - jumpSize + 1, i)
		else:
			i += jumpSize
			
	if(i >= len(array)):
		return linearSearch(array, num, i - jumpSize + 1, len(array) - 1)
	return -1
			

def linearSearch(array, num, start, end):
	for i in range(start, end + 1):
		if(array[i] == num):
			return i
	return -1
	

array = [-20,-5,-1,0,1,2,3,5,7,9,12,15,17,18,32]

index = jumpSearch(array, int(input('Enter a number : ')))
if(index == -1):
	print('Item Not Found...')
else:
	print('Item found at index: ' + str(index))
