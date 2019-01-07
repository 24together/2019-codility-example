//1. 10진수를 2진수로 변환
//2. 2진수 변환시 1과 1사이의 0의 숫자 세기, 1과 1사이 갭이 2개 이상이면, 둘 중 0의 숫자가 더 많은 수를 반환.
// ex) 1041(10000010001) -> 5, 15(1111)->0 
class Solution {
    public int solution(int n) {
        //변수 선언
        int  dapCount = 0;
        int  zeroCount = 0;
        int  maxCount =0;
        int firstCount =0;
        //2진수 생성을 위한 배열 생성 
        int [] b;
        b = new int[32];
        
        int k = 0;
        while(n !=1){
            b[k++] = n%2;
            n = n/2;
        }
        b[k] =n;
        //2진수 배열을 확인하며 1과 1사이의 숫자세기
        for(int j = k; j >0; --j){
            //첫번째 1 제외
            if(b[j]==1 && firstCount ==0){
                firstCount =1;
            }
            //1일 경우 사이의 0 갯수 비교하여 저장
            if(firstCount==1 && zeroCount > 0 && b[j]==1){
                if(maxCount < zeroCount){
                    maxCount = zeroCount;
                }
            //0 갯수 카운트 초기화
                zeroCount=0;
                
            //0일 경의 0의 갯수 카운트    
            }else if(b[j]==0){
                zeroCount = zeroCount+1;
            }
        }
       //가장 많은 값 반환
            return maxCount;
    }
}