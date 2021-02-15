var time = "";
console.time("time"); // start timer

var bestLength = 1;
var bestNum;

var tempLength = 0; // used by collatz() in order to have a counter that survives after each recursion

function getCollatzLength(n) {
    if (n == 1) { // end case n = 1: add 1 to length count and return it 
        tempLength++;
        return tempLength;
    } else if (n % 2 == 0) { // n is even
        tempLength++;
        return getCollatzLength(n / 2);
    } else if (n % 2 != 0) { // n is odd 
        tempLength++;
        return getCollatzLength(3 * n + 1);
    }
}

for (let i = 1; i < 1000000; i++) {
    tempLength = 0;
    let currentLength = getCollatzLength(i);
    if (bestLength < currentLength) {
        bestNum = i;
        bestLength = currentLength;
    }
}

console.log(bestNum); // 837799

console.timeEnd("time"); // end timer
