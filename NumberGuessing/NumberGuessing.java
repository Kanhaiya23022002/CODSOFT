import java.util.Scanner;
public class NumberGuessing{
    public static void guessNoGame(){
        Scanner sc=new Scanner(System.in);
        
        int number=1+(int)(100*Math.random());
        
        int K=5;
        int i;
        
        System.out.println(" You have to guess a Number between 1 to 100 "+ " within 5 trials .");
        
        for(i=0;i<K;i++){
            System.out.println("Guess the Number!");
            
            int guess=sc.nextInt();
            
            if(number==guess){
                System.out.println("Congratulations ! Your guess is right ");
                break;
            }
            else if(number>guess && i!=K-1){
                System.out.println("The number is " + "greater than " + guess);
            }
            else if(number<guess && i!=K-1){
                System.out.println("The number is "+ "less than " + guess);
            }
        }
         
        if(i==K){
            System.out.println("You have exhausted"+K+"trials");
            
            System.out.println("The number was "+ number);
        }
        
        
    }
    public static void main(String[]args){
        guessNoGame();
    }
}