package net.eutkin.data.entity;


import java.util.Date;
import java.sql.Time;

public class EntityJoin {
    private Date date_mens;
    private double power;

    public Date getDate_mens() {
        return date_mens;
    }

    public void setDate_mens(Date date_mens) {
        this.date_mens = date_mens;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}
