public class Q1 {
	public int solution(String s) { // 1 이상 1,000 이하

		int min = 1001;
		
		int ii = (s.length()/2 < 1) ? 1 : s.length()/2; // 만약 input 이 1글자일 경우
		for (int i = 1; i <= ii; i++) { // 압축 개수

			boolean last = false; 
			int cnt = 1; //중복 횟수
			StringBuilder candi = new StringBuilder();
			
			for (int j = 0; j < s.length(); j = j + i) { //j = 0
				
				String str = ""; //현재값
				String next = ""; //다음값
				if (j + i >= s.length()) { // 나머지 문자열
					str = s.substring(j); 
					last = true;
				} else {
					str = s.substring(j, j + i); 
				}
				
				if (!last) {
					if(j+i+i >= s.length())
						next = s.substring(j+i); 
					else
						next = s.substring(j + i, j + i + i); 
				}
					
				if (str.equals(next)) { // 압축이 된다면
					if (last && cnt > 1) {
						candi.append(String.valueOf(cnt)); //중복개수가 10개 이상. 즉 2자리일 수도 있음 ***
						candi.append(String.valueOf(next));
					}else if (last && cnt == 1) {
						candi.append(String.valueOf(next)); 
					}
					cnt++; 
				} else { 
					if (cnt > 1) {
						candi.append(String.valueOf(cnt)); 
						candi.append(String.valueOf(str)); 
					} else {
						candi.append(String.valueOf(str));
					}

					cnt = 1;
				}
			}//for j

			min = Math.min(candi.length(), min);
		}

		int answer = min;
		return answer;
	}
}
