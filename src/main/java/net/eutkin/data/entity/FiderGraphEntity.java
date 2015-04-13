package net.eutkin.data.entity;

import java.util.Date;


public class FiderGraphEntity {

    private Date time_line;

    private Double current_fider1;

    private Double current_fider2;

    private Double current_fider3;

    private Double current_fider4;

    private int numTS;

    public Date getTime_line() {
        return time_line;
    }

    public void setTime_line(Date time_line) {
        this.time_line = time_line;
    }

    public Double getCurrent_fider1() {
        return current_fider1;
    }

    public void setCurrent_fider1(Double current_fider1) {
        this.current_fider1 = current_fider1;
    }

    public Double getCurrent_fider2() {
        return current_fider2;
    }

    public void setCurrent_fider2(Double current_fider2) {
        this.current_fider2 = current_fider2;
    }

    public Double getCurrent_fider3() {
        return current_fider3;
    }

    public void setCurrent_fider3(Double current_fider3) {
        this.current_fider3 = current_fider3;
    }

    public Double getCurrent_fider4() {
        return current_fider4;
    }

    public void setCurrent_fider4(Double current_fider4) {
        this.current_fider4 = current_fider4;
    }

    public int getNumTS() {
        return numTS;
    }

    public void setNumTS(int numTS) {
        this.numTS = numTS;
    }
}
