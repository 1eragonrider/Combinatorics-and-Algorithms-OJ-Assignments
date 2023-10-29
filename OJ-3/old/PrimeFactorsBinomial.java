package old;
import java.util.Vector;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math.*;

class countPrimeFactorsOfBionomial{
    
    private int n;
    private int k;
    private ArrayList<Long> primesList = new ArrayList<Long>();

    // Constructors
    countPrimeFactorsOfBionomial(int nPar, int kPar){
        n = nPar;
        k = kPar;
    }

    // public class members

    public void segmentedSieve(int inputPar) {
        int limit = (int) (floor(sqrt( (double)CalcBinCoeff(n, k) ) ) + 1);
    }


    // Private class members
    private void SieveOfErr(int limitPar) {

        // create a boolean array of true values
        boolean checkArray[] = new boolean[limitPar + 1];
        for (boolean b : checkArray) {
            b = true;
        }

        // if the index of checkArray is not a prime, 
        // it will be switched to false
        for (int i = 0; i<= checkArray.length; i++) {
            if (checkArray[i]) {
                for (int j = i*i; j<limitPar; j+=i) {
                    checkArray[j] = false;
                }
            }
        }

        // now add the primes to the primesList
        for (int i = 2; i<limitPar; i++) {
            if (checkArray[i]){
                primesList.add((long) i);
            }
        }
    }

    // Generate a table of Binomial Coeefficients to store
    // the values in a dynamic programming approach
    private long CalcBinCoeff(int nPar, int kPar) {
        long[][] table = new long[nPar + 1][kPar + 1];
        return bCoeffPopulate(nPar, kPar, table);
    }

    // Calculate the binomial coefficients recur. and 
    // populate the table.
    private long bCoeffPopulate(int nPar, int kPar, long[][] tablePar) {
        if ((nPar == kPar) || (kPar == 0)) {
            return 1;
        }
        if (tablePar[nPar][kPar] > 0) {
            return tablePar[nPar][kPar];
        }
        
        return tablePar[nPar][kPar] = bCoeffPopulate(nPar - 1, kPar - 1, tablePar) +
                                        bCoeffPopulate(nPar - 1, kPar, tablePar);

    }

}

class PrimeFactorsBinomial {
    public static void main(String[] args){
        // Declarations
        int n;
        int k;
        // User input
        Scanner reader = new Scanner(new BufferedInputStream(System.in));
        n = reader.nextInt();
        k = reader.nextInt();

        // Initialization
        countPrimeFactorsOfBionomial someVariable = new countPrimeFactorsOfBionomial(n, k);

        // Output
        System.out.println(someVariable.calcNumOfPrimes());
    }
}
