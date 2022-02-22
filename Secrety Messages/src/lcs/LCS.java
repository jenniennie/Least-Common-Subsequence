/* Name: Jennifer Nguyen
 * Dr. Andrew Steinberg
 * COP3503 Fall 2021
 * Programming Assignment 3
 */

package lcs;

public class LCS {
	private String one;
	private String two;
	private String LCS = "";
	
	public LCS(String first, String sec)
	{
		this.one = first;
		this.two = sec;
	}
	
	public String getLCS()
	{
		return LCS;
	}
	
	public String message(char letter)
	{
		LCS += letter;
		return LCS;
	}

	public void lcsPrint(int[][] b, int i, int j)
	{
		if (i == 0 || j == 0)
			return;
		
		if (b[i][j] == 'd')		// if NW
		{	
			lcsPrint(b, i-1, j-1);
			LCS = message(one.charAt(i-1));
		}
		else if (b[i][j] == 'u')		// if not diagonal and check up
			lcsPrint(b, i-1, j);
		else 
			lcsPrint(b, i, j-1);			// otherwise go left	
	}
	
	public void lcsDynamicSol()
	{

		int m = one.length();
		int n = two.length();
		int c [][] = new int[m+1][n+1];
		int b [][] = new int[m+1][n+1];
		
		// set first of table to zeros
		for (int i = 0; i < m; i++)
			c[i][0] = 0;
		for (int j = 1; j < n; j++)
			c[0][j] = 0;
		
		for (int i = 1; i <= m; i++)	
		{
			for (int j = 1; j <= n; j++)
			{
				if (one.charAt(i-1) == two.charAt(j-1))
				{
					c[i][j] = (c[i-1][j-1])+1;		// if matches, add one to diagonal
					b[i][j] = 'd';
					
				}
				else if (c[i-1][j] >= c[i][j-1])
				{
					c[i][j] = c[i-1][j];		// go the the greater, take value of top
					b[i][j] = 'u';
				}
				else 
				{
					c[i][j] =c[i][j-1];		
					b[i][j] = 'l';
					
				}
			}
		}
		lcsPrint(b, m, n);
	}

}
