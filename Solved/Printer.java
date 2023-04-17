import java.util.*;
public class Printer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ns = sc.nextInt(); //num of statues
        int np = 0; //num of printers needed to print
        int minNum = days(ns,np);
        int temp = 0;
        while(np < ns){
            temp = days(ns, np);
            if(minNum > temp)
                minNum = temp; 
            np++;
        }
        System.out.println(minNum);
    }

public static int days(int ns, int np)
  {
    int days = 0, pp = 0;//pp=number of printers printed by you
    while(ns > 0)
    {
      if(np >= pp + 1)//only print printers
      {
        days++;
        np -= pp+1;
        pp += pp+1;        
      }
      else if(np > 0)//print remaining printers and others print statues
      {
        days++;
        ns -= (pp+1-np);
        pp += np;
        np = 0;
      }
      else//done printing printers. all priters print statues
      {
        if(ns%(pp+1) == 0){
            days += ns/(pp+1);
        }
        else{
            days+=(ns/(pp+1))+1;
        }
        ns =  0;  
      }

    }
    return days;
}
}

