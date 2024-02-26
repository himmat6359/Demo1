import java.math.*;
import java.io.*;
class Circular{
    public static Boolean isPrime(long no){
        if(no==0||no==2){
            return false;
        }
        else if(no==2){
            return true;
        }
        else if(no%2==0){
            return false;
        }
        else{
            for(long i=3;i<no/2;i++){
                if(no%i==0){
                    return false;
                }
            }
            return true;
        }
    }

    public static Boolean isCircular(long no){
        if(isPrime(no)==false){
            return false;
        }
        long first,div,temp,count=0;
        temp = no;
        while(temp>0){
            temp = temp/10;
            count++;
        }
        double div1;

        for(long i=0;i<count;i++){
            div1 = Math.pow(10.0,count-1);
            div = (int)div1;
            first = no/div;
            no = no%div;
            no = no*10+first;
            if(isPrime(no)==false){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args)throws IOException{
        File f = new File("Circular.txt");
        PrintWriter p = new PrintWriter(new FileWriter(f));
        for(long i = 0;i<9999;i++){
            if(isCircular(i)==true){
                System.out.println(i);
                p.println(i);
            }
        }

        p.close();
    }
}