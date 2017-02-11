package Week3;

import java.util.Scanner;

/**
 * Created by zhouxuexuan on 11/2/17.
 */

public class SequentialElect {
    public void election(){
        int countA = 0;
        int countB = 0;
        System.out.print("Election start! \n \n");
        for (int i=0;i<=4;i++){
            Scanner sc = new Scanner(System.in);
            System.out.print("Numer " + i + " electorate Please Vote! (Input A or B)\n");
            String vote = sc.next();
            if (vote.equals("A")){
                countA++;
            }
            if (vote.equals("B")){
                countB++;
            }
        }
        if (countA>countB){
            System.out.print("\n \nA won!\n \n");
        }
        if (countA<countB){
            System.out.print("\n \nB won!\n \n");
        }
        if (countA==countB){
            System.out.print("\n \nDraw!\n \n");
        }

    }
}
