package src;

import java.util.ArrayList;

/**
 * @version April 29th 2022
 * @author Nikolas Larson
 * MY MERGESORT ALGORITHM YAY
 */
public class MergeSort {
    private final ArrayList<Waypoint> arrayToSort;
    private WayPointComparator wayPC;

    /**
     * Constructor for a mergesort object
     * @param arrayToSort arraylist that needs to be sorted
     * @param w the comparator that will be used to sort the arraylist
     */
    public MergeSort(ArrayList<Waypoint> arrayToSort, WayPointComparator w) {
        this.arrayToSort = arrayToSort; wayPC = w;
    }

    /**
     * method for data retrieval
     * @return returns the sorted arrayList
     */
    public ArrayList<Waypoint> getYoDataBaseUp() {
        return arrayToSort;
    } // getSortedList

    /**
     * AKA divideArrayElements is a method that divides the arrayList into two parts which will get MERGED
     * @param indexStart beginning index of list
     * @param indexEnd end index of list
     */
    public void redHotChiliPeppers(int indexStart, int indexEnd) { //divideArrayElements

        if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) {
            int middleElement = (indexEnd + indexStart) / 2;

            redHotChiliPeppers(indexStart, middleElement);
            redHotChiliPeppers(middleElement + 1, indexEnd);

            mergeArrayElements(indexStart, middleElement, indexEnd);
        }
    }

    /**
     * MERGES THE ARRAYLISTS
     * @param indexStart starting index to merge
     * @param indexMiddle middle element of the arrayList
     * @param indexEnd end index to merge
     */
    public void mergeArrayElements(int indexStart, int indexMiddle, int indexEnd) {

        ArrayList<Waypoint> tempArray = new ArrayList<>();

        int getLeftIndex = indexStart;
        int getRightIndex = indexMiddle + 1;

        while (getLeftIndex <= indexMiddle && getRightIndex <= indexEnd) {

            if (wayPC.compare(arrayToSort.get(getLeftIndex), (arrayToSort.get(getRightIndex))) <= 1) {

                tempArray.add(arrayToSort.get(getLeftIndex));
                getLeftIndex++;

            } else {

                tempArray.add(arrayToSort.get(getRightIndex));
                getRightIndex++;

            }
        }

        while (getLeftIndex <= indexMiddle) {
            tempArray.add(arrayToSort.get(getLeftIndex));
            getLeftIndex++;
        }

        while (getRightIndex <= indexEnd) {
            tempArray.add(arrayToSort.get(getRightIndex));
            getRightIndex++;
        }


        for (int i = 0; i < tempArray.size(); indexStart++) {
            arrayToSort.set(indexStart, tempArray.get(i++));

        }

    }
}