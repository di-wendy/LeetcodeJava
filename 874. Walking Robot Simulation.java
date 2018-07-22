class Solution {
    int ans = 0;
    public int robotSim(int[] commands, int[][] obstacles) {
        int i = 0;
        int dir = 0;
        int[] pos = new int[]{0,0};
        Set<String> obs = new HashSet<>(); 
        for (int[] o : obstacles){
            obs.add("" + o[0] + " " + o[1]);
        }
        while (i < commands.length){
            if (commands[i] < 0){
                if (commands[i] == -2){
                    dir += 3;
                } else if (commands[i] == -1){
                    dir += 1;
                }
                dir %= 4;
                i += 1;
            } else {
                move(pos, dir, commands[i], obs, true);
                i++;
            }
        }
        return ans;
    }
    
    public void move(int[] pos, int dir, int step, Set<String> obs, boolean start){
        //System.out.println(pos[0] + " " + pos[1]);
        if (!start){
            if (obs.contains("" + pos[0] + " " + pos[1])){
                if (dir == 0) pos[1] -= 1; //moving up
                if (dir == 1) pos[0] -= 1; //Move right
                if (dir == 2) pos[1] += 1; //Move down
                if (dir == 3) pos[0] += 1; //Move left
                return;
            }
        }
        ans = Math.max(ans, (int)(Math.pow(pos[0], 2) + Math.pow(pos[1], 2)));
        if (step == 0) return;
        //Move up
        if (dir == 0){
            pos[1] += 1;
        }
        //Move right
        if (dir == 1){
            pos[0] += 1;
        } 
        //Move down
        if (dir == 2){
            pos[1] -= 1;
        }
        //Move left
        if (dir == 3){
            pos[0] -= 1;
        }
        move(pos, dir, step - 1, obs, false);
        //100
    }
}
