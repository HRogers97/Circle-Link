package com.company;

import java.util.Scanner;

public class Main {

    private static class DoubleLink<T> {
        public T element;
        public DoubleLink<T> next;
        public DoubleLink<T> prev;
        public DoubleLink() {}
        public DoubleLink(T element) {
            this.element = element;
        }
    }

    public static void main(String[] args) {
        int n; //Number of people in the circle
        int m; //Number of clockwise movements
        int o; //Number of counter-clockwise movements

        //Get above variables from user
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter n: ");
        n = scanner.nextInt();
        while(n <= 0){
            System.out.println("Error: n must be greater than 0");
            System.out.print("Please enter n: ");
            n = scanner.nextInt();
        }

        System.out.print("Please enter m: ");
        m = scanner.nextInt();
        while(m < 0){
            System.out.println("Error: m must be at least 0");
            System.out.print("Please enter m: ");
            m = scanner.nextInt();
        }

        System.out.print("Please enter o: ");
        o = scanner.nextInt();
        while(o < 0 || (o == 0 && m == 0)){
            System.out.println("Error: o must be at least 0, and m and o cannot both be set to 0");
            System.out.print("Please enter o: ");
            o = scanner.nextInt();
        }

        //Create the circle
        DoubleLink<Integer> current = new DoubleLink<>(1);
        DoubleLink<Integer> head = current; //Used to reset position after the circle

        for(int i = 2; i <= n; i++){
            //Create new link with current person
            DoubleLink<Integer> tmp = new DoubleLink<>(i);

            //Link current person to rest of circle
            current.next = tmp;
            tmp.prev = current;

            //Continue moving forward in circle
            current = tmp;
        }

        //Link last and first elements of the circle
        head.prev = current;
        current.next = head;

        //Reset position of current
        current = head;

        //Execute movements and remove people from the circle
        int turn = 1; //Used to check which direction to move

        //If current is only linked to current, then we are at the last person
        while(current.next != current && current.prev != current){
            //Move counter-clockwise on even turns if 0 is not 0
            //or if m is 0
            if(m == 0 || (o > 0 && turn % 2 == 0)){
                //Counter-clockwise
                for(int i = 0; i < o - 1; i++){
                    //Move back
                    current = current.prev;
                }
            }
            else{
                //Clockwise
                for(int i = 0; i < m - 1; i++){
                    //Move forward
                    current = current.next;
                }
            }

            //Print person being removed to console
            System.out.print(current.element + " ");

            //Keep track of next person to start at
            DoubleLink tmp = current.next;

            //Remove current person
            current.prev.next = current.next;
            current.next.prev = current.prev;

            //We continue after the next person from who was removed
            current = tmp;

            turn++;
        }

        //Print last person
        System.out.print(current.element);
    }
}
