function bubbleSort(array){
	for(var i = 0; i < array.length; i++){
		var swapped = false;
		for(j = 0; j < array.length - 1 - i; j++){
			if(array[j] > array[j+1]){
				array[j] += array[j+1];
				array[j+1] = array[j] - array[j+1];
				array[j] -= array[j+1];
				swapped = true;
			}
		}
		if(!swapped){
			break;
		}
	}
	
	return array;
}

var num = parseInt(prompt("Enter number of elements"));

var array = [];
for(var j = 0; j < num; j++){
	array.push(parseInt(prompt("Enter element n°: " + (j+1) )));
}

var sortedArray = bubbleSort(array);

for(var i=0; i < sortedArray.length; i++){
	document.write(sortedArray[i] + "</br>");
}
