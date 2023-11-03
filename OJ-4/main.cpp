#include <iostream>

// Global Constants
int const MOD = 1000000007;
int const MAXN = 2000;
int const MAXK = 2000;
int partitionTable[MAXN + 1][MAXK + 1];

// function declarations
int partitionNumbers(int nPar, int kPar);

int main(void) {
    // declare variable
    int n, k, out;

    // user input
    std::cin >> n >> k;
    // calculations
    out = partitionNumbers(n,k);

    // output
    std::cout << out << std::endl;

    return 0;
}

int partitionNumbers(int nPar, int kPar) {

    if(kPar == 0) {
        return 0;
    }
    if (nPar == 0) {
        return 1;
    }
    if (nPar < 0) {
        return 0;
    } 
    if (partitionTable[nPar][kPar] != 0) {
        return partitionTable[nPar][kPar];
    }

    return partitionTable[nPar][kPar] = (partitionNumbers(nPar, kPar - 1) +
                                            partitionNumbers(nPar - kPar, kPar)) % MOD;
}