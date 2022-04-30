package src;

import java.util.ArrayList;

public class MergeSort {
    private final ArrayList<Waypoint> arrayToSort;
    private WayPointComparator wayPC;

    public MergeSort(ArrayList<Waypoint> arrayToSort, WayPointComparator w) {
        this.arrayToSort = arrayToSort; wayPC = w;
    }

    public ArrayList<Waypoint> getYoDataBaseUp() {
        return arrayToSort;
    } // getSortedList

    public void redHotChiliPeppers(int indexStart, int indexEnd) { //divideArrayElements

        if (indexStart < indexEnd && (indexEnd - indexStart) >= 1) {
            int middleElement = (indexEnd + indexStart) / 2;

            redHotChiliPeppers(indexStart, middleElement);
            redHotChiliPeppers(middleElement + 1, indexEnd);

            mergeArrayElements(indexStart, middleElement, indexEnd);
        }
    }

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