var time = "";
console.time("time"); // start timer

var bestLength = 1;
var bestNum;

var tempLength = 0; // used by collatz() in order to have a counter that survives after each recursion

function collatz(n) {
    let num = n;
    if (num == 1) { // end case n = 1: add 1 to length count and return it 
        tempLength++;
        return tempLength;
    } else if (num % 2 == 0) { // n is even
        tempLength++;
        return collatz(num / 2);
    } else if (n % 2 != 0) { // n is odd 
        tempLength++;
        return collatz(3 * num + 1);
    }
}

for (let i = 1; i < 1000000; i++) {
    tempLength = 0;
    let newLength = collatz(i);
    if (bestLength < newLength) {
        bestNum = i;
        bestLength = newLength;
    }
}

console.log(bestNum); // 837799

console.timeEnd("time"); // end timer
