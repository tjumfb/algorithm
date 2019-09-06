package leetcode;

import edu.princeton.cs.algs4.StdOut;

public class Euclid {
    static int euclid(int p, int q){
        StdOut.print(p + " " +q);
        StdOut.println();
        if(q == 0) return p;
        int r = p%q;
        return  euclid(q,r);
    }

    public static void main(String[] args) {
        euclid(1111111,1234567);
    }
}
