/**
 * ����ͼ�ڽӾ����ж�����֮���Ƿ���ͨ��ͨ��warshall�㷨ʵ��.
 * �㷨������ͨ����ͼ�Ĵ��ݱհ�����Ϊ���ݱհ���
 * ������r[i,j]=0,����kʹ,r[i,k]=1,r[k,j]=1��r[i,j]��Rk�Ĵ��ݱհ��пɴr[i,j]��Ϊ1
 * ������rn�׵Ĵ��ݱհ��еļ�����������������r[i,j]=1��rn-1�ױհ���Ϊ1������Ϊ1.
 * ����k��������r[i,k]=1,r[k,j]=1,��r[i,j]=1��k�״��ݱհ���
 * α����
 * R(0) <- A
 * for k <- 1 to n do
 *  for j <- 1 to n do
 *   for i <- 1 to n do
 *    R(k)[i][j] = R(k-1)a[i][j] or (R(k-1)a[i][k] and R(k-1)a[k][j)
 *    
 * @author jason
 *
 */

public class Warshall{
	
	 public static void main(String[] args) {       
	        int[][] AdjMat = {
	                {0,1,0,0},
	                {0,0,0,1},
	                {0,0,0,0},
	                {1,0,1,0}
	        };
	        warShall(AdjMat);
	        System.out.println("�����ﴫ�ݱհ��ľ���\n");
	        for(int i = 0;i < AdjMat.length;i++)
	        {
	            for(int j = 0;j < AdjMat.length;j++)
	                System.out.print(AdjMat[i][j] + "  ");
	            System.out.println();
	        }    
	        
	 }

	private static int[][] warShall(int[][] adjMat) {
		int n = adjMat.length;
		for(int k=0;k<n;k++){
			for(int j=0;j<n;j++) {
				for(int i=0;i<n;i++) {
					adjMat[i][j] = adjMat[i][j]|(adjMat[i][k]&adjMat[k][j]);
				}
			}
		}
		return adjMat;
	}
	
}
/**
 * ��warshall���������Ƶ�������ͼ��(������Ϊ�����Ļ�·)��������֮�����·����Floyd�㷨,α������warshall������,
 * @author jason
 * FLoyd(w[1..n,1..n])
 * d = w
 * for k <- 1 to n
 * 	for i <- 1 to n
 * 	 for j <- 1  to n
 * 		d[i][j] = min(d[i][j],d[i,k]+d[k,j])
 * ʵ�ּ�����ȫ·���ĵ�floyd�㷨
 * ���룺ͼ��Ȩ�ؾ��� W
 * 
 * ������������·�����ȵľ������
 */
class Floyd{
	public static void floyd(int [][] matrix){
		int nWei =  matrix.length;
		for(int k=0;k<nWei;k++) {
			for(int j=0;j<nWei;j++) {
			  for(int i=0;i<nWei;i++) {	
				  matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
			  }
			}
		}
		
	}
}