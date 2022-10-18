// Version: 2017103101
public class Augment {
    public int minGap;
    public int minVal;
    public int maxVal;
    public int lLeft;
    public int lRight;

    public static Augment combine(Augment left, Augment right, int key) {
        Augment res = new Augment();
        res.minVal = Math.min(left.minVal,key);
        res.maxVal = Math.max(right.maxVal,key);
        if(left != null) {
            if(left.maxVal > 0) {
                res.lLeft = Math.min(left.minGap,key-left.maxVal);
            } else {
                res.lLeft = Math.min(left.minGap,Integer.MAX_VALUE);
            }
        }
        if(right != null) {
           res.lRight = Math.min(right.minGap,right.minVal-key);
        }
        res.minGap = Math.min(res.lLeft,res.lRight);
        return res;
    }

    public static Augment leaf() {
        Augment res = new Augment();
        res.minGap  = Integer.MAX_VALUE;
        res.minVal  = Integer.MAX_VALUE;
        res.maxVal  = 0;
        res.lLeft   = Integer.MAX_VALUE;
        res.lRight  = Integer.MAX_VALUE;
        return res;
    }
}
