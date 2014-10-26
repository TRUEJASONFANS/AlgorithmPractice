
public class MergeSortTest {

	private final int M = 5;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {23,52,12,9,2,32,25};
		int[] temp = new int[a.length];
		MergeSort(a,0,a.length-1,temp);
		temp = null;
		for(int i:a)
		System.out.println(i);
	}
	private static void MergeSort(int[] a, int s, int e, int[] temp) {
		// TODO Auto-generated method stub
		if(s<e) {
			int mid = (s+e)/2;
			MergeSort(a,s,mid,temp);
			MergeSort(a,mid+1,e,temp);
			MergeArray(a,s,e,mid,temp);
		}
	}
	/**
	 * ºÏ²¢ a[s--mid],a[mid+1--e]
	 * @param a
	 * @param s
	 * @param e
	 * @param mid
	 * @param temp
	 */
	private static void MergeArray(int[] a, int s, int e, int mid, int[] temp) {
		// TODO Auto-generated method stub
		int i = s, j = mid + 1, k = 0;
		while(i<=mid&&j<=e) {
			if(a[i]<a[j])			
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
			
		}
		while(i<=mid) 
			temp[k++] = a[i++];
		while(j<=e)
			temp[k++] = a[j++];
		for( i=0;i<k;i++)
			a[s+i] = temp[i];
	}

}
