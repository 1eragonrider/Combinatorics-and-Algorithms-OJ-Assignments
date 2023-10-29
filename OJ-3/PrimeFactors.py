import numpy as np
import math

# array to store prime numbers
primeArray = []

def CalcBinCoeff(nPar, kPar):
    table = np.zeros((nPar + 1,kPar + 1), np.int64)
    return bCoeffPopulate(nPar, kPar, table)

def bCoeffPopulate(nPar, kPar, tablePar):
    if ((nPar == kPar) or (kPar == 0)):
        return 1
    if (tablePar[nPar][kPar] > 0):
        return tablePar[nPar][kPar]
    
    tablePar[nPar][kPar] = bCoeffPopulate(nPar -1, kPar -1, tablePar) + bCoeffPopulate(nPar - 1, kPar, tablePar)

    return tablePar[nPar][kPar]

def SieveOfErr(limitPar):
    returnVal = 0
    # create a check array to check
    # for prime numbers and initilize
    # to true.
    check = [True for i in range(math.floor(limitPar / 2) + 1)]

    prime = 2
    while (prime*prime <= limitPar):

        # change from true to false 
        # all multiples.
        if (check[prime]):
            if (limitPar % prime == 0):
                returnVal +=1

            for i in range(prime*prime, len(check), prime):
                check[i] = False
        prime+=1
    
    # fill the prime array with
    # the primes we found
    #for prime in range(2, limitPar):
    #    if (check[prime]):
    #        primeArray.append(prime)
    return returnVal

#def CalculateNumOfDistinctFactors(inputPar):
#    returnNum = 0
#    SieveOfErr(inputPar)
#
#    for prime in range(0, math.floor(len(primeArray) / 2)):
#        if (inputPar % primeArray[prime] == 0):
#            returnNum+=1
#    
#    return returnNum



n, k = input().split()
n = int(n)
k = int(k)

print(SieveOfErr(CalcBinCoeff(n,k)))


