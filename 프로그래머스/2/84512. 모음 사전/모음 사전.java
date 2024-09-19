class Solution {
    static char[] ch = {'A', 'E', 'I', 'O', 'U'};
    static char[] chArr = new char[5];
    static int answer = 0;
    static int count = 0;  
    
    public int solution(String word) {
        makeWord(word, 0);
        return answer-1;
    }

    public static void makeWord(String word, int depth) {
        String currentWord = new String(chArr, 0, depth);  
        count++;
        
        if (word.equals(currentWord)) {
            answer = count;
            return;
        }

        if (depth == 5) {
            return;
        }


        for (int i = 0; i < 5; i++) {
            chArr[depth] = ch[i];  
            makeWord(word, depth + 1);
        }
    }
}