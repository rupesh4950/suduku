package sudoku;

public class Check  {

	public int[] findZero(int[][] su) {
		int a[]= {-1,-1};
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(su[i][j]==0) {
					a[1]=j;a[0]=i;
					return a;
				}
			}
		}
		return a;	
	}
	int ij[]=null, val=0 ,su[][]=null;;
	public boolean check(int[][] su, int[] ij, int i) {
		this.ij=ij;
		this.su=su;
		this.val=i;
		if (!checkRow())
			return false;
		if(!checkCol())
			return false;
		if (!checksqure())
			return false;
		return true;
	}

	private boolean checkCol() {
		// check col wether the number is present
		int col=ij[1];
		for(int i=0;i<9;i++) {
			if(su[i][col]==val) {
				return false;
			}
		}
		return true;
	}

	private boolean checksqure() {
		// check squre wether the number is present
		int is=-1 ,ie=-1, js=-1,je=-1; 
		int ii=ij[0];
		int jj=ij[1];
		//for finding the row start and end
		if(ii<3) {
			is=0;
			ie=3;
		}
		else if(ii<6) {
			is=3;
			ie=6;
		}
		else {
			is=6;
			ie=9;
		}
		//for finding the squre start and end
		if(jj<3) {
			js=0;
			je=3;
		}
		else if(jj<6) {
			js=3;
			je=6;
		}
		else {
			js=6;
			je=9;
		}
		//checking the valau is present in the squre
		for(int i=is;i<ie;i++) {
			for(int j=js;j<je;j++) {
				if(su[i][j]==val)
					return false;// return s false if the value is present in the squre
			}
		}
		
		return true;//returns true if value is not present int  the squre
	}

	private boolean checkRow() {
		// check row wether the number is present
		int row=ij[0];
		for(int i=0;i<9;i++) {
			if(su[row][i]==val) {
				return false;// return s false if the value is present in the row
			}
			
		}
		return true;//returns true if value is not present int  the row
		
	}
	
	
	
	void print(int[][] su) {
		for (int i = 0; i < su.length; i++) {
			System.out.println();
			if (i % 3 == 0) {
				for (int k = 0; k < 7; k++) {
					System.out.print("====");
				}
				System.out.println();
			}

			for (int j = 0; j < su.length; j++) {
				if (j % 3 == 0) {
					System.out.print(" | ");
				}
				System.out.print(su[i][j] + " ");
			}
			System.out.print("|");
		}
		System.out.println();
		for (int k = 0; k < 7; k++) {
			System.out.print("====");
		}
		System.out.println();
	}


	
}
