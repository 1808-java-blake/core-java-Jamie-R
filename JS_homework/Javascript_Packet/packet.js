// 1. Fibonacci
// Define function: fib(n) 
// Return the nth number in the fibonacci sequence.

function getNthFibonacci(target) {
    first = 0;
    second = 1;
    result = 0;
    counter = 1;

    while (counter < target - 1) {
    result = first + second;
    first = second;
    second = result;
    counter++;
    }

    return result;
}

// 2. Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array.
// Return the sorted array.

function bubbleSort(numArray) {
    let numNumbers = numArray.length;

    for (cycle = 0; cycle < numNumbers; cycle++) {
        for (current = 0; current < numNumbers - cycle - 1; current++) {
            if (numArray[current] > numArray[current + 1]) {
                let temp = numArray[current];
                numArray[current] = numArray[current + 1];
                numArray[current + 1] = temp;
            }
        }
    }
    return numArray;
}

// 3. Reverse String
// Define function: reverseStr(someStr)
// Reverse and return the String. reverseString("JamieRees");

function reverseString(original) {
    let numChars = original.length;
    let origArray = original.split("");
    let reverArray = new Array();

    for (current = 0; current <= numChars; current++) {
        reverArray[current] = origArray[numChars - current];
    }
    return reverArray.join("");
}

// 4. Factorial
// Define function: factorial(someNum)
// Use recursion to compute and return the factorial of someNum.

function getFactorial(someNum) {
    let total = someNum;

    for (counter = someNum - 1; counter > 0; counter--) {
        someNum = someNum - 1;
        total = total * someNum;
    }
    return total;
}

// 5. Substring
// Define function substring(someStr, length, offset)
// Return the substring contained between offset and (offset + length) inclusively.
// If incorrect input is entered, use the alert function and describe why the input was incorrect.

function substring(input, desLength, offset) {
    let inputArray = input.split("");
    let substrArray = new Array();
    let charIndex = offset;

    if ( (offset + desLength) > (inputArray.length - offset) ) {
        window.alert("substring is not within the bounds of the string!");
        return input;
    }

    for (counter = 0; counter < desLength; counter++) {
        substrArray[charIndex] = inputArray[charIndex];
        charIndex++;
    }
    return substrArray.join("");
}

// 6. Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.

function isEven(someNum) {
    let half = someNum / 2;
    let rounded = Math.round(half);

    if (rounded === half) {
        return true; 
    }
    else {
        return false;
    }
}

// 7. Palindrome
// Define function isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false

function isPalindrome(original) {
    let numChars = original.length;
    let origArray = original.split("");
    let reverArray = new Array();

    for (current = 0; current <= numChars; current++) {
        reverArray[current] = origArray[numChars - current];
    }
    let reversed = reverArray.join("");
    if (reversed === original) {
        return true;
    }
    else {
        return false;
    }
}

// 8. Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape. Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *

function printShape(shape, height, character) {
    let rows = 1;
    let chars = 1;

    switch (shape){
        case "Triangle":
            while (rows <= height) {
                let rowArray = new Array();
                while (chars <= rows) {
                    rowArray[chars] = character;
                    chars++;
                }
                console.log(rowArray.join("") );
                rows++;
            }
            break;

        case "Square":
        let rowArray = new Array();
        while (chars <= height) {
            rowArray[chars] = character;
            chars++;
        }
        while (rows <= height) {
            console.log(rowArray.join("") );
            rows++;
        }
        break;

        case "Diamond":
        let i = 0;
        let j = 0;
        half = (height - 1) / 2;
        let result = new Array();

        for (i = -half; i <= half; i++) {
            for (j = -half; j <= half; j++) {
                if ( (Math.abs(i) + Math.abs(j) ) <= half ) {
                    result.push(character);
                } else {
                    result.push(" ");
                }
            }
            result.push("\n");
        }
        return console.log(result.join("") );
    } 
}

// 9. Object literal
// Define function traverseObject(someObj)
// Print every property and it's value.

function traverseObject(someObj) {
    Object.getOwnPropertyNames(someObj).forEach(val => {
          console.log(val + ': ' + someObj[val]);
        } );
}

// 10. Delete Element
// Define function deleteElement(someArr)
// Print length
// Delete the third element in the array.
// Print length
// The lengths should be the same.

function deleteElement(someArr) {
    console.log(someArr.length);
    delete someArr[2];
    console.log(someArr.length);
}

// 11. Splice Element
// Define function spliceElement(someArr)
// Print length
// Splice the third element in the array.
// Print length
// The lengths should be one less than the original length.

function spliceElement(someArr) {
    console.log(someArr.length);
    someArr.splice(2, 1);
    console.log(someArr.length);
}

// 12. Defining an object using a constructor
// Define a function Person(name, age)
// The following line should set a Person object to the variable john:
//     var john = new Person("John", 30);
    
function Person(name, age) {
    this.name = name;
    this.age = age;
}

// 13. Defining an object using an object literal
// Define function getPerson(name, age)
// The following line should set a Person object to the variable john:
//     var john = getPerson("John", 30);

function makePerson(name, age) {
    return { "name": name, "age": age };
}