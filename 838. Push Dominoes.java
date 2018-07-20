class Solution {
    public String pushDominoes(String dominoes) {
        if (dominoes.length() == 0) return dominoes;
        String s = update(dominoes);
        while (!s.equals(dominoes)) {
            System.out.println(s);
            dominoes = s;
            s = update(dominoes);
        }
        return s;
    }
    
    public String update(String d){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length(); i++){
            if (i > 0 && d.charAt(i - 1) == 'R'){
                if ((i + 1 == d.length() || d.charAt(i + 1) == '.' || d.charAt(i + 1) == 'R') && d.charAt(i) != 'L'){
                    sb.append('R');
                } else {
                    sb.append(d.charAt(i));
                }
            } else {
                if (i + 1 < d.length() && d.charAt(i + 1) == 'L' && d.charAt(i) != 'R'){
                    sb.append('L');
                } else {
                    sb.append(d.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}
