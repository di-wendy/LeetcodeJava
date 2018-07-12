class Solution {
    public String simplifyPath(String path) {
        Deque<String> dq = new LinkedList<>();
        String[] store = path.split("/");
        for (int i = 0; i < store.length; i++){
            if (store[i].equals("..")){
                if (!dq.isEmpty()) dq.pollLast();
            } else {
                if (!store[i].equals(".") && store[i].length() != 0){
                    dq.offerLast(store[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()){
            sb.append("/");
            sb.append(dq.pollFirst());
        }
        return (sb.length() == 0) ? "/" : sb.toString();
    }
}
