/**
 * 无相图邻接矩阵，判断亮点之间是否相通，通过warshall算法实现.
 * 算法核心是通过求图的传递闭包，何为传递闭包。
 * 假设有r[i,j]=0,存在k使,r[i,k]=1,r[k,j]=1则r[i,j]在Rk的传递闭包中可达。r[i,j]置为1
 * 所有在rn阶的传递闭包中的计算中有两点规则，如果r[i,j]=1在rn-1阶闭包中为1，则仍为1.
 * 加入k后，若存在r[i,k]=1,r[k,j]=1,则r[i,j]=1在k阶传递闭包中
 * 伪代码
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
	        System.out.println("输出表达传递闭包的矩阵：\n");
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
 * 与warshall方法相类似的在无向图中(不存在为负数的回路)计算亮点之间最短路径的Floyd算法,伪代码与warshall相类似,
 * @author jason
 * FLoyd(w[1..n,1..n])
 * d = w
 * for k <- 1 to n
 * 	for i <- 1 to n
 * 	 for j <- 1  to n
 * 		d[i][j] = min(d[i][j],d[i,k]+d[k,j])
 * 实现计算完全路径的的floyd算法
 * 输入：图的权重矩阵 W
 * 
 * 输出：包含最短路径长度的距离矩阵
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