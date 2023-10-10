import java.io.BufferedInputStream;
import java.util.*;

class SJTArray {
  private List<Integer> arrayToReturn = new ArrayList<>(20);
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
  }

  // private methods
  

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

    return calculateSJTArray(nPar - 1, quotient);

    if (quotient%2 != 0 ) {
      // This case is when the quotient is odd
      // place the nPar value in index = remainder and shift all the values to its right to the right 1
      arrayToReturn.add(remainder, nPar);
      return arrayToReturn;
    } else {
      // This case is when the quotient is even
      // place the nPar value in index = nPar - remainder and shift all the values to its right to the right 1;
      arrayToReturn.add(nPar - remainder, nPar);
      return arrayToReturn;
    }
  }
}


