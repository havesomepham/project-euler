function triangle(n) {
    let sum = n * (n + 1) / 2;
    return sum;
}

for (let i = 1; i < 10; i++) {
    console.log(triangle(i));
}