package com.skyScraper.client;
import java.util.*;

 

@SuppressWarnings("rawtypes")
class MyComparator implements Comparator

{

    public int compare(Object obj1,Object obj2)

    {

     Integer _1=(Integer)obj1;

     Integer _2=(Integer)obj2;

     return _2.compareTo(_1);

    }

}

public class SkyScarper 

{

    public static void main(String[] args)  

    {

     Scanner sc=new Scanner(System.in);
     System.out.println("Enter the total no of floors in the building:");

     int n=sc.nextInt();

     int max=n;

     @SuppressWarnings("unchecked")
	Queue<Integer> queue=new PriorityQueue<Integer>(new MyComparator());

     int floors[]=new int[n];
     

     for(int i=0;i<n;i++)

     { System.out.println("Enter the floor size given on day " + (i+1) + ":");

      floors[i]=sc.nextInt();

      queue.add(floors[i]);
      while(!queue.isEmpty() && queue.peek()==max)

        {
          System.out.print(queue.poll() + " ");

          max--;

        }
     
      System.out.println();
      
     }

      sc.close();

   }


 

}











