public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones stones = new JewelsAndStones();
        System.out.println(stones.numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(stones.numJewelsInStones("z", "ZZ"));
    }
    public int numJewelsInStones(String J, String S) {
        int cnt = 0;

        for (int i = 0; i < S.length(); ++i) {
            if (J.indexOf(S.charAt(i)) >= 0) {
                cnt ++;
            }
        }
        return cnt;

    }
}
