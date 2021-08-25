//Function to perform the linear search
function linearSearch(array, item){
  for(var i = 0; i < array.length ;i++){
    if(array[i] == item)
      return i;
  }
  
  return -1;
}

//The array to be searched
var array = [4, 20, -9, 5, 7];

//Call " linearSearch " function to perform the search
var index = linearSearch(array, 0);

//Print the index if the item is found
if(index == -1){
  document.write("Nothing found...");
}else{
  document.write(index);
}
