package net.eutkin.data.service;

import net.eutkin.data.entity.*;
import net.eutkin.data.dao.IDataMeansDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DataMensServiceImpl implements IDataMensService {
    @Autowired
    private IDataMeansDAO dataMeansDAO;

    @Transactional
    public List<AbstractDataTS> showAllData(AbstractDataTS obj) {
        return dataMeansDAO.showAllData(obj);
    }
    @Transactional
    public List<EntityJoin> showBalanceOfPower(AbstractDataTS ts1, Date dateFrom, Date dateTill){
        return dataMeansDAO.showBalanceOfPower(ts1,dateFrom,dateTill);
    }
    @Transactional
    public List<FiderGraphEntity> showCurrentOfFiders(AbstractDataTS ts1, AbstractDataTS ts2, Date dateFrom, Date dateTill,String[] fider12, String[] fider34){
        return dataMeansDAO.showCurrentOfFiders(ts1,ts2,dateFrom,dateTill,fider12,fider34);
    }

}
