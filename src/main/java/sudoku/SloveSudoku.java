package sudoku;

public class SloveSudoku extends FileSu {
	Check c = null;
	static int iter=0;// to count how many iterations
	public static void main(String[] args) {
		SloveSudoku s = new SloveSudoku();
		s.c = new Check();
		s.c.print(su);
		boolean b = s.solve();
		System.out.println("\n" + b);
		s.c.print(su);
		System.out.println(iter);
	}

	private boolean solve() {
		iter++;
		int[] ij = c.findZero(su);
	//	System.out.println("checking");
		if (ij[0] == -1) {
			return true;
		}
		int itr=10;
	//	while (itr-->0) {
			for (int i = 1; i <= 9; i++) {
				// System.out.println("checking for "+ij[0]+" "+ij[1]+" with value"+i);
				boolean b = c.check(su, ij, i);
				//System.out.println("checking for " + ij[0] + " " + ij[1] + " with  value " + i + " is fites " + b);
				boolean bool=false;
				if (b) {
					su[ij[0]][ij[1]] = i;
					bool=solve();
					if (bool) {
						return true;
					}
				}
				if(bool==false) {
					su[ij[0]][ij[1]] = 0;
					continue;
				}
			}
	//	}

		return false;
	}

	
}
//schoool  n sutudets n tacher