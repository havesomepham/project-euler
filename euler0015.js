var time = "";
console.time("time"); // start timer

var knownLatticePaths = [[0, 0, 1]]; // creates a catalog of the number of paths for some previous values of m and n in order to save on computation time

function latticePaths(m, n) {
    if (m == 0 || n == 0) {
        return 1;
    } else {
        for (let i = 0; i < knownLatticePaths.length; i++) {
            if (m === knownLatticePaths[i][0] && n === knownLatticePaths[i][1]) { // if the current m and n are in the catalog...
                return knownLatticePaths[i][2]; // return the known number of paths for that m and n
            }
        }
        knownLatticePaths.push([m, n, latticePaths(m, n - 1) + latticePaths(m - 1, n)]); // if the current m and n are not in the catalog, find the number of paths for that m and n and add it to the catalog...
        return knownLatticePaths[knownLatticePaths.length - 1][2]; // and return the number of paths for that m and n
    }
}

console.log(latticePaths(20, 20)); // 137846528820

console.timeEnd("time"); // end timer
