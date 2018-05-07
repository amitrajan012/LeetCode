/* package whatever; // don't place package name! */

import java.io.*;
import java.util.Scanner;

class ReverseWord {
  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner scan = new Scanner(System.in);
    int t= Integer.valueOf(scan.nextLine());
    while(t>0){
      String line = scan.nextLine();
      String[] a = line.split(" ");
      for(int i=0; i<a.length;i++){
        String temp = a[i];
        for(int j=temp.length()-1;j>=0;j--){
          System.out.print(temp.charAt(j));
        }
        System.out.print(" ");
      }
      System.out.print("\n");
      t--;
    }
    scan.close();
   }
  }
