import numpy as np
import math

# array to store prime numbers
primeArray = []

def RecCalcBinCoeff(nPar, kPar):
    table = np.zeros((nPar + 1,kPar + 1), np.int64)
    return RecBCoeffPopulate(nPar, kPar, table)

def RecBCoeffPopulate(nPar, kPar, tablePar):
    if ((nPar == kPar) or (kPar == 0)):
        return 1
    if (tablePar[nPar][kPar] > 0):
        return tablePar[nPar][kPar]
    
    tablePar[nPar][kPar] = RecBCoeffPopulate(nPar -1, kPar -1, tablePar) + RecBCoeffPopulate(nPar - 1, kPar, tablePar)

    return tablePar[nPar][kPar]

def CalcBinCoeff(nPar, kPar):
    result = 1
    # through some math fenagiling we can get a
    # solution of C(n,k) = [n*(n-1)*...*(n-k+1)] / [k*(k-1)*...*1]
    # where there are k terms
    for k in range(kPar):
        result = result * (nPar - k)
        result = result // (k + 1)
    return result

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

def ModifiedSieveOfErr(NPar):
    isPrime = [True for i in range(NPar + 1)]
    SPF = [None for i in range(NPar + 1)]
    isPrime[0] = isPrime[1] = False

    for i in range(2, NPar):
        if isPrime[i]:
            primeArray.append(i)
            SPF[i] = i
        j = 0
        while (j < len(primeArray) 
               and i * primeArray[j] < NPar 
               and primeArray[j] <= SPF[i]):
            
            isPrime[i * primeArray[j]] = False
            SPF[i * primeArray[j]] = primeArray[j]
            j+=1

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
nPF = 0

C = CalcBinCoeff(n,k)
ModifiedSieveOfErr(C)

i = 0
while (i < len(primeArray)):
    if ((C % primeArray[i]) == 0):
        nPF+=1
    i += 1
print(nPF)
