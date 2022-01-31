package com.company.greatLearning;

import java.util.HashSet;
import java.util.Scanner;

public class TicTacToe {

//  Hashset is used to store the all entered values
    static HashSet<Integer> u_set=new HashSet<>();        // User set
    static HashSet<Integer> c_set=new HashSet<>();        // Comp set
    public static void main(String[] args) {
        char[][] g_board = {
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},                // Structure of Tic Tac Toe
                {' ', '|', ' ', '|', ' '},
                {'-', '|', '-', '|', '-'},
                {' ', '|', ' ', '|', ' '},
        };
        print_board(g_board);                             // Printing the board

//        User input method
        Scanner in=new Scanner(System.in);

//        Run the loop till user or computer win
        while(true)
        {
            System.out.println("Enter the values from 1-9");
            int u_pos=in.nextInt();


//          Check whether the entered no. position is already filled or not in TTT board if it is filled then entered the other no.
            while(u_set.contains(u_pos) || c_set.contains(u_pos))
            {
                System.out.println("Position is already taken.TryAgain");
                System.out.println("Retry, Enter the value: ");
                u_pos=in.nextInt();
            }
            p_holder(g_board,u_pos,"You");

//          Checking who is the winner
            String res=check_result();
            if(res.length()>0)
            {
                System.out.println(res);
                break;
            }
//          CPU Method for random input

            int c_pos=gen_random();
            while(u_set.contains(c_pos) || c_set.contains(c_pos))
            {
                c_pos=gen_random();
            }
            p_holder(g_board,c_pos,"Comp");

//          Checking who is the winner
            res=check_result();
            if(res.length()>0)
            {
                System.out.println(res);
                break;
            }
        }

    }

    //Printing the board
    static void print_board(char[][] g_board) {
        for (int i = 0; i < g_board.length; i++) {
            for (int j = 0; j < g_board[i].length; j++) {
                System.out.print(g_board[i][j]);
            }
            System.out.println();
        }
    }
   //Logic for (Filling O and X)
    static void p_holder(char[][] g_board,int pos,String user)
    {
        char syb='X';
        if(user.equals("You"))
        {
            syb='X';
            u_set.add(pos);
        }
        else if(user.equals("Comp"))
        {
            syb='O';
            c_set.add(pos);
        }

        switch (pos)
        {
            case 1:
                g_board[0][0]=syb;
                break;
            case 2:
                g_board[0][2]=syb;
                break;
            case 3:
                g_board[0][4]=syb;
                break;
            case 4:
                g_board[2][0]=syb;
                break;
            case 5:
                g_board[2][2]=syb;
                break;
            case 6:
                g_board[2][4]=syb;
                break;
            case 7:
                g_board[4][0]=syb;
                break;
            case 8:
                g_board[4][2]=syb;
                break;
            case 9:
                g_board[4][4]=syb;
                break;
            default:
                System.out.println("Invalid number! Please Enter the number between 1-9");
        }
        print_board(g_board);
    }

//    Check the winner
    static String check_result()
    {

        HashSet<Integer> r1=new HashSet<>();
        r1.add(1);r1.add(2);r1.add(3);
        HashSet<Integer> r2=new HashSet<>();
        r2.add(4);r2.add(5);r2.add(6);
        HashSet<Integer> r3=new HashSet<>();
        r3.add(7);r3.add(8);r3.add(9);
        HashSet<Integer> c1=new HashSet<>();
        c1.add(1);c1.add(4);c1.add(7);
        HashSet<Integer> c2=new HashSet<>();
        c2.add(2);c2.add(5);c2.add(8);
        HashSet<Integer> c3=new HashSet<>();
        c3.add(3);c3.add(6);c3.add(9);
        HashSet<Integer> d1=new HashSet<>();
        d1.add(1);d1.add(5);d1.add(9);
        HashSet<Integer> d2=new HashSet<>();
        d2.add(3); d2.add(5);d2.add(7);

        HashSet<HashSet> check=new HashSet<HashSet>();
        check.add(r1);check.add(r2);check.add(r3);
        check.add(c1);check.add(c2);check.add(c3);

        for(HashSet i:check)
        {
            if(u_set.containsAll(i))
            {
                return "Hooray! You Won";
            }
            else if(c_set.containsAll(i))
            {
                return ":( You Lost! Try again.";
            }
            if (u_set.size()+c_set.size()==9)
            {
                return "OOPs, It's a Draw. Give it one more try.";
            }
    }
        return "";
    }
//    Generate random method by Comp
    static int gen_random()
    {
        int max=9;
        int min=1;
        int range=max-min+1;
        int res=(int) (Math.random()*range)+min;

        return res;
    }


}