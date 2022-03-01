package learn.comparableimpl;

import java.util.Comparator;

/*
*   Comparator is used for comparing two different Objects comparable properties
*       eg: Let's assume Class01 have a string feild and
*       Class02 also have string feild
*       in that case to compare object01 string feild with
*       object02 string feild
* */
public class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1 == o2) return 0;
        if(o1 == null) return -1;
        if(o2 == null) return -1;

        /*
        * String class implements Comparable interface
        *   custom implementation of compareTo() method
        * */
        return o1.compareTo(o2);
    }
}
