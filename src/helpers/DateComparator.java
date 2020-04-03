package helpers;

import model.Data;

import java.util.Comparator;

public class DateComparator implements Comparator<Data> {
    @Override
    public int compare(Data data1, Data data2) {
        if(data1.getZi() > data2.getZi()) {
            return 1;
        } else if(data1.getZi() < data2.getZi()){
            return -1;
        } else{
            return 0;
        }
    }
}
