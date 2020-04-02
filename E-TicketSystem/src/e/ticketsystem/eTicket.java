package e.ticketsystem;

import java.util.Date;
import java.util.Scanner;

public class eTicket {

    String name;
    int phoneNumber;
    Date dt;
    int sit;
    int tk;
    public static int taka=0;

    public static void display() {
        System.out.print("\n\n\n\n");
        System.out.print("\t\t\t\t***************************************************\n");
        System.out.print("\t\t\t\t***************************************************\n");
        System.out.print("\t\t\t\t||                  WELCOME                      ||\n");
        System.out.print("\t\t\t\t||        -----------------------------          ||\n");
        System.out.print("\t\t\t\t||           GREEN LINE PARIBAHAN                ||\n");
        System.out.print("\t\t\t\t||        -----------------------------          ||\n");
        System.out.print("\t\t\t\t||              E-Ticket System                  ||\n");
        System.out.print("\t\t\t\t||                                               ||\n");
        System.out.print("\t\t\t\t||                                               ||\n");
        System.out.print("\t\t\t\t||              $   MADE BY  $                   ||\n");
        System.out.print("\t\t\t\t||          |  INAM ULLAH KHAN  |                ||\n");
        System.out.print("\t\t\t\t||                                               ||\n");
        System.out.print("\t\t\t\t***************************************************\n");
        System.out.print("\t\t\t\t***************************************************\n\n\n");
    }

    public static void User(eTicket et[][]) {
        
        System.out.println("1:Sit Boking\n"
                + "2: Search\n"
                + "3:Cancel ticket\n"
                + "4: Exit");
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        s.nextLine();
        switch (n) {
            case 1: {
                eTicket.dsplyDestination(et);
                break;
            }
            case 2:
                eTicket.Search(et);
                break;
            case 3:
                 eTicket.cencel(et);
                break;
            case 4:
                System.exit(n);

            default:
                eTicket.User(et);
        }

    }

    public static void dsplyDestination(eTicket et[][]) {
        System.out.println("\t\tEnter Your Destination(1 or 2 or 3):\n"
                + " \t\t1.Dhaka to Sylhet\n "
                + "\t\t2.Dhaka to Cox's Bazar\n"
                + " \t\t3.Dhaka to Chittagong\n"
                + "\t\t4.Back\n");
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        s.nextLine();
        switch (n) {
            case 1: {
                taka = 1200;
                eTicket.DepartureTime(et);
                
                break;
            }
            case 2:
                taka = 1500;
                eTicket.DepartureTime(et);
                
                break;
            case 3:
                taka = 1400;
                eTicket.DepartureTime(et);
                
                break;
            case 4:
                eTicket.User(et);
                break;

            default:
                eTicket.dsplyDestination(et);
        }
    }

    public static void DepartureTime(eTicket et[][]) {
        System.out.print("\t\tSelect your Departure Time(1 or 2 or 3):\n "
                + "\t\t1.9 am\n "
                + "\t\t2.1 pm\n "
                + "\t\t3.6 pm\n"
                + "\t\t4.Back\n\n");

        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        s.nextLine();
        switch (n) {
            case 1: {
                eTicket.Category(et);
                break;
            }
            case 2:
                eTicket.Category(et);
                break;
            case 3:
                eTicket.Category(et);
                break;
            case 4:
                eTicket.dsplyDestination(et);
                break;

            default:
                eTicket.DepartureTime(et);
        }
    }

    public static void Category(eTicket et[][]) {
        System.out.print("\t\tSelect Your Bus Category(1 or 2):\n"
                + " \t\t1.AC\n "
                + "\t\t2.Non-AC\n"
                + "\t\t3.Back\n\n");
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        s.nextLine();
        switch (n) {
            case 1: {
                taka = taka + 500;
                eTicket.Boking(et);
                break;
            }
            case 2:
                
                eTicket.Boking(et);
                
                break;

            case 3:
                eTicket.DepartureTime(et);
                break;

            default:
                eTicket.Category(et);
        }
    }

    public static void Boking(eTicket et[][]) {
        int i, j, flag, check;

        Scanner s = new Scanner(System.in);
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 24; j++) {
                if (et[i][j].phoneNumber == 0) {
                    System.out.println("Enter Your name: ");
               
                    et[i][j].name = s.nextLine();
                    Date d=date();
                    et[i][j].dt=d;
                    System.out.println("Enter your phone number: ");
                    et[i][j].phoneNumber = s.nextInt();
                    System.out.print("\t\tEnter How Many Sits do you Want?\n\n ");
                    int n;
                    int temp = j;
                    n = s.nextInt();
                    int[] num = new int[n];
                    
                    flag = i;
                    check = j;
                    if (24 - j > n) {
                        for (int k = 0; k < n; k++) {
                            num[k] = j;
                            System.out.printf("%d,%d ", i+1, j+1);
                            et[i][j].sit=n;
                            if (k > 1) {
                                et[i][j].phoneNumber = et[i][temp].phoneNumber;
                            }
                            j++;

                        }
                        System.out.println("is ready for you***\n\n");

                        System.out.printf("\t\tYour Total Bill is: %d Tk\n\n", taka*n);
                        System.out.print("\t\tIf You Paid Your Bill:\n \t\t1.Yes\n \t\t2.No\n\n");
                        int f;
                        f = s.nextInt();
                        if (f == 1) {
                            System.out.println("pls pament by bkash XXXXXXXXX \n");
                            System.out.print(" \t\tYour Ticket is Confirmed\n \n\n\t\t\t\tThank You For Using Our Service\n\n");
                            eTicket.User(et);
                        } else if (f == 2) {
                            System.out.print(" \t\tDUE, Please pay your Bill Soon\n \n\n\t\t\t\tThank You For Using Our Service\n\n");
                            eTicket.User(et);
                        }
                        

                    }
                    
                   
                }
                else
                    System.out.println("\n\n\t\tSit are not avalavle\n");
            }
        }
    }

    public static void Search(eTicket et[][]) {
        int n;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter Your phone Number: ");
        int i,j;
        n=s.nextInt();
        for (i = 0; i < 2; i++) {
            for (j = 0; j < 24; j++) {
                if(et[i][j].phoneNumber==n)
                {
                    int f=j;
                    int g=j;
                    System.out.println("Dear "+ et[i][j].name+",\n\n\t\t");
                    System.out.println("Your Sits are ");
                    int l=et[i][j].sit;
                    for (int k = 0; k <l ; k++) {
                        System.out.printf("%d %d , ",i+1,g+1);
                        g++;
                    }
                    System.out.println("");
                    System.out.println(et[i][f].dt);
                }
                eTicket.User(et);
            }
        }
        
    }

    public static Date date() {
        Date d = new Date();
        return d;
    }
    public static void cencel(eTicket et[][])
    {
        System.out.println("Enter Your Phone Number ");
        int n;
        Scanner s =new Scanner(System.in);
        n=s.nextInt();
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 24; j++) {
                 if(et[i][j].phoneNumber==n)
                 {
                     et[i][j].phoneNumber=0;
                     System.out.println("your ticket canceled\n"
                             + "pls you ricived 50%% taka from our customer care");
                     eTicket.User(et);
                 }
            }
        }
    }
}
