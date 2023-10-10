import java.io.BufferedInputStream;
import java.util.*;

class SJTArray {
  private List<Integer> arrayToPermutate = new ArrayList<>(20);
  private long k;
  private int n;

  // setters and getters
  public int getK() { return k;}
  public void setK(long kPar){k = kPar;}
  public int getN() { return n;}
  public void setN(int nPar){n = nPar;}

  // constructors
  public SJTArray(int nPar, long kPar) {
    n = nPar;
    k = kPar - 1;
    for (int i = 1; i <= nPar; i++) {
      arrayToPermutate.add(i);
    }
  }

  // private methods
  

  // public methods
  public void printArray() {
    for (int i = 0; i<arrayToPermutate.size(); i++) {
      if (i == (arrayToPermutate.size() - 1)) {
        System.out.print(arrayToPermutate.get(i));
        continue;
      }
      System.out.print(arrayToPermutate.get(i) + " ");
    }
  }

  public int[] calculateSJTArray(int nPar, long kPar) {
    if (nPar == 1) {
      return 1;
    }
    long quotient = kPar / nPar;
    int remainder = kPar % nPar;

    return calculateSJTArray(nPar - 1, quotient);

    if (quotient%2 != 0 ) {
      // This case is when the quotient is odd
      // place the nPar value in index = remainder and shift all the values to its right to the right 1
    } else {
      // This case is when the quotient is even
      // place the nPar value in index = nPar - remainder and shift all the values to its right to the right 1;
    }
  }
}


