class Solution {
    public int compareVersion(String v1, String v2) {
        String[] levels1 = v1.split("\\.");
        String[] levels2 = v2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer num1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer num2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = num1.compareTo(num2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
}
