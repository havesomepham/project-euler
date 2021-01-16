function triangle(n) {
    let sum = n * (n + 1) / 2;
    return sum;
}

function primeFactors(n) {
    var num = n;
    var factors = []

    if (num == 0) {
        console.log('The input number has no prime factors.');
        return null;
    }

    // p = 2
    while (num % 2 == 0) {
        factors.push(2);
        num = num / 2;
    }

    // p is odd
    for (let i = 3; i < Math.sqrt(num); i += 2) {
        while (num % i == 0) {
            factors.push(i);
            num = num / i;
        }
    }

    // num is now either prime or 1
    if (num != 1) {
        factors.push(num);
    }

    console.log(factors);
    return factors;
}

for (let i = 0; i < 50; i++) {
    primeFactors(i);
}