package net.eutkin.data.entity;

import java.util.Date;


public class FiderGraphEntity {

    private Date time_line;

    private Double current_fider;

    private int meter_id;

    private int numTS;

    public Date getTime_line() {
        return time_line;
    }

    public void setTime_line(Date time_line) {
        this.time_line = time_line;
    }

    public Double getCurrent_fider() {
        return current_fider;
    }

    public void setCurrent_fider(Double current_fider) {
        this.current_fider = current_fider;
    }

    public int getMeter_id() {
        return meter_id;
    }

    public void setMeter_id(int meter_id) {
        this.meter_id = meter_id;
    }

    public int getNumTS() {
        return numTS;
    }

    public void setNumTS(int numTS) {
        this.numTS = numTS;
    }
}
