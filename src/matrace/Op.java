package matrace;

import static java.lang.Integer.parseInt;

/**
 *
 * @author Reda ben
 */
public class Op {
    public static String getOp(){
       int a = (int) (Math.random()*10)+1;
       if(a == 10 ) a--;
       int b = (int) (Math.random()*10)+1;
       if(b == 10 ) b--;      
       int c = (int) (Math.random()*2)+1;
       String d = "";
       if(c==3) d= "-";
       if(c==2) d= "+";
       if(c==1) d= "*";
       return a + d + b;
    }
    public static int getRes(String s){
        int a =  parseInt(s.substring(0,1));
        int c =  parseInt(s.substring(2));
        String o = s.substring(1,2);
        switch(o){
            case "+" : return a+c;
            case "-" : return a-c;
            case "*" : return a*c;
            default: return 1;
        }
    }
}
