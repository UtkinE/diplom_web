package net.eutkin.data.service;

import net.eutkin.data.entity.AbstractDataTS;
import net.eutkin.data.entity.EntityJoin;
import net.eutkin.data.entity.FiderGraphEntity;

import java.util.Date;
import java.util.List;

public interface IDataMensService {
    public List<AbstractDataTS> showAllData(AbstractDataTS obj);
    public List<EntityJoin> showBalanceOfPower(AbstractDataTS ts1, Date dateFrom, Date dateTill);
    public List<FiderGraphEntity> showCurrentOfFiders(AbstractDataTS ts1, AbstractDataTS ts2, Date dateFrom, Date dateTill,String[] fider12, String[] fider34);
}
