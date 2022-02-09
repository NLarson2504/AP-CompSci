import java.sql.SQLOutput;
import java.util.*;

public class Chapter11 {
    public static ArrayList<String> reverseArrayList(ArrayList<String> myList) {
        ArrayList<String> myListy = myList;
        Collections.reverse(myListy);
        return myListy;

    }
    public static ArrayList<String> removeConsecutiveDuplicates(ArrayList<String> lst){
        for(int i= lst.size()-2; i>=0; i--){
            if(Objects.equals(lst.get(i), lst.get(i + 1)))
                lst.remove(i);
        }
        return lst;
    }
    public static ArrayList<Integer> findMin(ArrayList<Integer> myList) {
        Collections.sort(myList);
        myList.remove(0);
        return myList;
    }
    public static ArrayList<String> removeListDuplicates(ArrayList<String> myList, ArrayList<String> mySecondList){
        for(int i = myList.size()-1; i >= 0; i--) {
            for(int k =mySecondList.size()-1; k>=0; k--){
                if (myList.get(i) == mySecondList.get(k))
                    myList.remove(i);
            }
        }
        return myList;
    }
    public static boolean isReversed(ArrayList<Integer> firstList,

                                     ArrayList<Integer> secondList)

    {

        for (int j = 0; j < firstList.size() / 2; j++)

        {

            if (firstList.get(j) != secondList.get(secondList.size() - 1 - j))

            {

                return false;

            }

        }

        return true;

    }
    public static void insertionSort(int[] elements)

    {

        for (int j = 1; j < elements.length; j++)

        {

            int temp = elements[j];

            int possibleIndex = j;
            int count = 0;

            while (possibleIndex > 0 && temp < elements[possibleIndex - 1])

            {

                elements[possibleIndex] = elements[possibleIndex - 1];

                possibleIndex--;   // line 10
            }

            elements[possibleIndex] = temp;
            System.out.println("BANG");
        }

    }
    public static void selectionSort(int[] elements)

    {

        for (int j = 0; j < elements.length - 1; j++)

        {

            int minIndex = j;

            for (int k = j + 1; k < elements.length; k++)

            {

                if (elements[k] < elements[minIndex])

                {

                    minIndex = k;

                }

            }

            if (j != minIndex)

            {

                int temp = elements[j];

                elements[j] = elements[minIndex];

                elements[minIndex] = temp;   // line 19
                System.out.println("BANG");
            }

        }

    }

    public static void main(String[] args) {



    }}
