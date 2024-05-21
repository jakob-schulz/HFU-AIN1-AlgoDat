public class Sortierung {
    public static void mergesort(Integer[] x) {
        if (x.length == 1) {
            return;
        }
        int m = x.length / 2;
        Integer[] l = new Integer[m];
        Integer[] r = new Integer[m];
        for (int pos = 0; pos < m; pos++) {
            l[pos] = x[pos];
            r[pos] = x[pos + m];
        }
        /*System.out.print("\n L:");
        for (int pos = 0; pos < m; pos++) {
            l[pos] = x[pos];
            System.out.print(l[pos] + ", ");
        }
        System.out.print("\n R:");
        for (int pos = 0; pos < m; pos++) {
            r[pos] = x[pos + m];
            System.out.print(r[pos] + ", ");
        }*/
        mergesort(l);
        mergesort(r);
        //Merge
        int lpos = 0; 
        int rpos = 0;
        for(int pos = 0; pos < 2 * l.length; pos++)
        {
            if(lpos == l.length)
            {
                for(; rpos < r.length; rpos++)
                {
                    x[pos]= r[rpos];
                    pos++;
                }
                break;
            }
            if(rpos == r.length)
            {
                for(; lpos < l.length; lpos++)
                {
                    x[pos]= l[lpos];
                    pos++;
                }
                break;
            }
            if(l[lpos] < r[rpos])
            {
                x[pos] = l[lpos];
                lpos++;
            }
            else
            {
                x[pos] = r[rpos];
                rpos++;
            }
        }
        /*System.out.print("\nX: ");
        for(int pos = 0; pos < x.length; pos++)
        {
            System.out.print(x[pos] + ", ");
        }*/
    }
}