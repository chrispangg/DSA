//Create a function that reserves a string

function reverse(str) {

	let charArray = str.split('');
	let reverseArray = [];
	for (let i = 0; i < charArray.length; i++) {
		reverseArray.splice(0,0, charArray[i]);
	}

	return reverseArray.join('');
}

function reverseRecursion(str) {
	if(str.length == 1) {
		return str[0];
	}
	let charArray = str.split('');
	let endChar = charArray[charArray.length-1];
	charArray.pop();
	let st = charArray.join('');

	return endChar + reverseRecursion(st);

}


let s = "Hello this is Chris";
console.log(reverse(s));
console.log(reverseRecursion(s));