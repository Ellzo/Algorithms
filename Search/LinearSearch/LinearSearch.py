#Function to perform linear search
def linearSearch(array, item):
	"""i initial value is 0, to start from index 0"""
	i=0

	"""While i didn't scan the whole array yet
	i.e i is less than the length of the array,
	keep searching for item"""
	while i < len(array):
		"""return item index when it is found"""
		if(array[i] == item):
			return i
  		
		"""Add 1 to i"""
		i += 1

	"""Return -1 when nothing found"""
	return -1


#Array to search
array= [0,1,5,3,-220]

#result gets the returned value from linearSearch function
result= linearSearch(array , int(input('Enter number: ')))


#If result equals -1 nothing found
if result == -1:
	print('Number not found')

#If result isn't equal -1, then item is found at index result
else:
	print('Number found at index: '+ str(result))

