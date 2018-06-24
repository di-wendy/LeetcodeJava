public class NestedIterator implements Iterator<Integer> {

    List<Integer> ls = new ArrayList<>();
    int index = 0;
    //[1,[4,[6]]]
    public NestedIterator(List<NestedInteger> nestedList) {
        Deque<NestedInteger> q = new LinkedList<>();
        
        for(NestedInteger nt : nestedList){
            q.offer(nt);
        }
        
        while(!q.isEmpty()){
            NestedInteger nt = q.poll();
            if(nt.isInteger()){
                ls.add(nt.getInteger());
            }
            else{
                List<NestedInteger> temp = nt.getList();
                for(int i = temp.size() - 1; i >= 0; i--){
                     q.addFirst(temp.get(i));
                }
            }
        }
    }

    @Override
    public Integer next() {
        int temp = ls.get(index);
        index ++;
        return temp;
        
    }

    @Override
    public boolean hasNext() {
        return (index < ls.size());
    }
}

//Update Stack
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> st = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--){
            st.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return st.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!st.isEmpty()){
            if (st.peek().isInteger()) return true;
            List<NestedInteger> cur = st.pop().getList();
            for (int i = cur.size() - 1; i >= 0; i--){
                st.push(cur.get(i));
            }
        }
        return false;
    }
}
