import java.io.FileNotFoundException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String> pancakes_arranged = new LinkedList<>();
        System.out.println("enter number of test cases");
        int number_of_flips = 0;
        Scanner scanner = new Scanner(System.in);
        int number_of_testcases = scanner.nextInt();
        flips_needed(number_of_testcases, pancakes_arranged, number_of_flips, scanner);
    }

    public static void flips_needed(int number_of_testcases, LinkedList<String> pancakes_arranged
            , int number_of_flips, Scanner scanner) {
        int j, count = 0, no_of_flips[]=new int[1000];
        System.out.println("enter the pancakes and number of flips");
        for (int i = number_of_testcases; i > 0; i--) {
            scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String n[] = input.split("");
            for (String l : n) {
                if (l.equals("+") || l.equals("-"))
                    pancakes_arranged.add(l);
                else if (l.equals(" "))
                    continue;
                else if (Integer.parseInt(l) != 0)
                    number_of_flips = Integer.parseInt(l);


            }
            ListIterator<String> listIterator = pancakes_arranged.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.next().equals("-")) {
                    j = listIterator.nextIndex() - 1;
                    int k = 0;
                    while (k < number_of_flips) {
                        try {
                            if (pancakes_arranged.get(j).equals("-"))
                                pancakes_arranged.set(j++, "+");

                            else
                                pancakes_arranged.set(j++, "-");
                        } catch (IndexOutOfBoundsException e) {
                            no_of_flips[i]=Integer.MAX_VALUE;
                        }
                        k++;
                    }
                    if(no_of_flips[i]!=Integer.MAX_VALUE){
                        count++;
                        no_of_flips[i] = count;}
                }

            }
            count=0;
            pancakes_arranged.clear();

        }
        int m=1;
        for(int i=number_of_testcases; i>0; i--) {
            System.out.print("Case#" + m + " ");
            if (no_of_flips[i] == Integer.MAX_VALUE)
                System.out.println("Not Possible");
            else
                System.out.println(no_of_flips[i]);
            m++;
        }
    }

}






            



