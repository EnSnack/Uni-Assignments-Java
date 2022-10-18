// Version: 2017103101
public class Augment {
    int size;
    public int minVal;
    public int maxVal;
    public int lLeft;
    public int lRight;

    public static Augment combine(Augment left, Augment right, int key) {
        Augment res = new Augment();
        res.minVal = Math.min(left.minVal,key);
        res.maxVal = Math.max(right.maxVal,key);
        return res;
    }

    public static Augment leaf() {
        Augment res = new Augment();
        res.minVal  = Integer.MAX_VALUE;
        res.maxVal  = 0;
        res.lLeft   = Integer.MAX_VALUE;
        res.lRight  = Integer.MAX_VALUE;
        return res;
    }
}
