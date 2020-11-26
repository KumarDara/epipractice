package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

enum Color {
    RED, WHITE, BLUE
}
public class DutchFlagPartition {
    public static void dutchPartition(int pivot, List<Color> values) {
        Color pivotCol = values.get(pivot);
        for(int i=0; i<values.size() - 1; i++) {
            for(int j=i+1; j<values.size(); j++) {
                if(values.get(j).ordinal() < pivotCol.ordinal()) {
                    Collections.swap(values, i, j);
                    break;
                }
            }
        }
        for(int i=values.size() - 1; i >0;  i--) {
            for(int j=i-1; j>=0; j--) {
                if(values.get(j).ordinal() > pivotCol.ordinal()) {
                    Collections.swap(values, i, j);
                    break;
                }
            }
        }
    }

    public static void dutchPartitionEfficient(int pivot, List<Color> values) {
        int lesserInd = 0;
        Color pivotCol = values.get(pivot);
        for(int i=0; i<values.size(); i++) {
            if(values.get(i).ordinal() < pivotCol.ordinal()) {
                Collections.swap(values, i, lesserInd++);
            }
        }
        int greaterInd = values.size() - 1;
        for(int i=values.size()-1; i>=0; i--) {
            if(values.get(i).ordinal() > pivotCol.ordinal()) {
                Collections.swap(values, i, greaterInd--);
            }
        }
    }

    public static void dutchPartitionMoreEfficient(int pivotlndex , List<Color> A) {
        Color pivot = A.get(pivotlndex);
/*
* Keep the following invariants during partitioning:
* bottom group: A .subList (SI , smaller) .
                * middle group: A .subList (smaller , equal).
                * unclassified group: A .subList (equal , larger).
                * top group: A .subList (larger , A . size ()) .
                */
        int smaller = 0, equal = 0, larger = A.size();
// Keep iterating as long as there is an unclassified element.
        while (equal < larger) {
// A .get (equal) is the incoming unclassified element.
            if (A.get(equal).ordinal() < pivot.ordinal()){
                Collections.swap(A , smaller++, equal++);
            } else if (A.get(equal).ordinal() == pivot.ordinal()){
                ++equal ;
            } else { // A . get (equal) > pivot.
                Collections.swap(A , equal, --larger);
            }
        }
    }

    public static void main(String[] args) {
        List<Color> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.WHITE);
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.WHITE);
        colors.add(Color.BLUE);
        colors.add(Color.RED);

        System.out.println(colors);
        dutchPartitionMoreEfficient(1, colors);
        System.out.println(colors);
    }
}
