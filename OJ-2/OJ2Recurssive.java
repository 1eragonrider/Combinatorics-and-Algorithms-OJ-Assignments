import java.io.BufferedInputStream;
import java.util.*;


class SJTArray {

  // Attributes
  private List<Integer> arrayToReturn = new ArrayList<>(20);

  // constructor
  public SJTArray() {
  }
  
  // public methods
  public void printArray() {
    for (int i = 0; i<arrayToReturn.size(); i++) {
      if (i == (arrayToReturn.size() - 1)) {
        System.out.print(arrayToReturn.get(i));
        continue;
      }
      System.out.print(arrayToReturn.get(i) + " ");
    }
  }

  public List<Integer> calculateSJTArray(int nPar, long kPar) {
    if (nPar == 1) {
      arrayToReturn.add(0, 1);
      return arrayToReturn;
    }
    long quotient = kPar / nPar;
    int remainder = (int) (kPar % nPar);

    calculateSJTArray(nPar - 1, quotient);

    if (quotient%2 != 0 ) {
      // This case is when the quotient is odd
      // place the nPar value in index = remainder and shift all the values to its right to the right 1
      arrayToReturn.add(remainder, nPar);
      return arrayToReturn;
    } else {
      // This case is when the quotient is even
      // place the nPar value in index = (nPar - 1) - remainder and shift all the values to its right to the right 1;
      arrayToReturn.add((nPar - 1) - remainder, nPar);
      return arrayToReturn;
    }
  }

  public boolean clearSJTArray() {
    arrayToReturn.clear();
    return true;
  }
}

class Main {

    public static void main(String[] args) {

        // Declarations
        int n;
        long k;
        
        // Input
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        n = in.nextInt();
        k = in.nextLong();

        // Calculations
        SJTArray sjtArray = new SJTArray();
        k = k - 1;
        sjtArray.calculateSJTArray(n, k);

        // Output
        sjtArray.printArray();
        sjtArray.clearSJTArray();
    }
}
