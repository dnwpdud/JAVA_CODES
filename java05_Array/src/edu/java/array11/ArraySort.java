package edu.java.array11;
// 정열
public class ArraySort {

	   public static void main(String[] args) {
	      int[] arr = {1, 9, 6, 7, 3, 5, 1};
	      
	      for(int i = 0; i < arr.length - 1; i++) {// arr[7]가 출력이 안된다.
	         int min = arr[i];
	         int least = i;
	         int tmp = 0;
	         for(int j = i + 1; j < arr.length; j++) {// i + 1한 이유는 min = i 이기 때문에 비교하기 위해 +1을 했다.
	            if(arr[j] < min) {//최소값 비교 for
	               min = arr[j];//최소값 비교
	               least = j;
	            }
	         }
	         
	         tmp = arr[i];
	         arr[i] = arr[least];
	         arr[least] = tmp;
	         
	      }
	      
	      for(int i = 0; i < arr.length; i++) {// 출력
	         System.out.println(arr[i]);
	      }

	   } // end main()
	 
	} // end ArraySort()
