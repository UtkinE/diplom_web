package net.eutkin.data.dao;

import net.eutkin.data.entity.*;

import java.util.Date;
import java.util.List;

public interface IDataMeansDAO {
    public List<AbstractDataTS> showAllData(AbstractDataTS obj);
    public List<EntityJoin> showBalanceOfPower(AbstractDataTS ts1,
                                               Date dateFrom,
                                               Date dateTill
                                              );
    public List<FiderGraphEntity> showCurrentOfFiders(AbstractDataTS ts1,
                                                      AbstractDataTS ts2,
                                                      Date dateFrom,
                                                      Date dateTill,
                                                      String[] fider12,
                                                      String[] fider34
                                                     );
}
