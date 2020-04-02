package e.ticketsystem;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
          eTicket.display();
        Scanner s = new Scanner(System.in);
        Login ss = new Login();
        ss.setPassword("InamKhan");
        ss.setUsername("InamKhan");
        String a = ss.getUsername();
        String b = ss.getUsername();
        int count = 1;
        int c = ss.Login(a, b, count);
        if (5 >= c) {
            eTicket[][] et = new eTicket[2][24];
            int i, j;
            for (i = 0; i < 2; i++) {
                for (j = 0; j < 24; j++) {
                    et[i][j] = new eTicket();
                    et[i][j].phoneNumber = 0;
                }
            }
          
            eTicket.User(et);
        } else {
            System.out.println("you are Blocked");

        }

    }

}
