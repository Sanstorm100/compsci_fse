import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.print.attribute.IntegerSyntax;

class Main {
    public static void main(String[] args) {
        ArrayList <Integer> fx = new ArrayList <Integer>();;
        ArrayList <Integer> fy = new ArrayList <Integer>();
        ArrayList <Integer> output= new ArrayList <Integer>();
        for(int i=1; i<4;i++){
        fy.add(i);
        fx.add(i);
        }
        Collections.reverse(fy);
int num=0;
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
            num+= fx.get(i) *fy.get(j);
            }
            output.add(num);
            System.out.print(Arrays.toString(output.toArray()));
        }
        

    }
}