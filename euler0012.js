// returns the nth triangle number
function triangle(n) { 
    let sum = n * (n + 1) / 2;
    return sum;
}

// returns each of the prime factors of n in an array
function primeFactors(n) {
    let num = n;
    let factors = [];

    if (num == 0) {
        console.log('The input number has no prime factors.');
        return null;
    } else if (num == 1) {
        return [1];
    }

    // p = 2
    while (num % 2 == 0) {
        factors.push(2);
        num = num / 2;
    }

    // p is odd
    for (let i = 3; i <= num; i += 2) {
        while (num % i == 0) {
            factors.push(i);
            num = num / i;
        }
    }
    return factors;
}

// returns the amount of numbers up to n that are divisible by n
function divisors(n) {
    let factors = primeFactors(n);
    let prime = 2;
    let q = 0;
    let exponents = [0];
    let divCount = 1;

    for (let i = 0; i < factors.length; i++) { // tally up each instance of each distinct prime factor
        if (factors[i] == prime) { // if the prime factor is not unique, add 1 to the existing value in exponents
            exponents[q] += 1;
        } else if (factors[i] != prime) { // if the prime factor is unique
            if (exponents[q] == 0) { // if this is the first prime factor ever
                prime = factors[i]; // update to the next unique prime factor (which is the one at factors[i])
                exponents[0] += 1; 
            } else {
                prime = factors[i]; // update to the next unique prime factor (which is the one at factors[i])
                q += 1; // update the index of exponents by 1
                exponents[q] = 1;
            }

        }
    }

    for (let i = 0; i < exponents.length; i++) {
        divCount *= (exponents[i] + 1); // the number of divisors is equal to the product of the exponents of each unique prime factor plus 1 (ex. 108 = 2^2 + 3^3. It therefore has (2 + 1) * (3 + 1) = 12 divisors)
    }

    return divCount;
}


var nthCand = 1;

while (divisors(triangle(nthCand)) < 500) {
    divisors(triangle(nthCand));
    nthCand += 1;
}

console.log(triangle(nthCand)); // 76576500
