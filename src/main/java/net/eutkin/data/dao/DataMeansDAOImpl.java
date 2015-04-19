package net.eutkin.data.dao;

import net.eutkin.data.entity.AbstractDataTS;
import net.eutkin.data.entity.EntityJoin;
import net.eutkin.data.entity.FiderGraphEntity;
import org.hibernate.Hibernate;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;

import javax.persistence.Table;
import java.util.*;
import java.util.Date;

@Repository
public class DataMeansDAOImpl implements IDataMeansDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<AbstractDataTS> showAllData(AbstractDataTS obj) {
        String str = "from "+ obj.getClass().getName();
        return sessionFactory.getCurrentSession().createQuery(str).list();
    }

    public List<EntityJoin> showBalanceOfPower(AbstractDataTS ts1, Date dateFrom, Date dateTill){
        String table1 = ts1.getClass().getAnnotation(Table.class).name();
        String query = "SELECT ts1.date_mensuration + ts1.time_mensuration  as date_mens" +
                                 ",SUM(ts1.power) as power" +
                          " FROM "   + table1 + " as ts1" +
                          " WHERE (ts1.date_mensuration + ts1.time_mensuration BETWEEN ? AND ?)" +
                          " GROUP BY date_mens" +
                          " ORDER BY date_mens";
            return  sessionFactory.getCurrentSession().createSQLQuery(query)
                    .addScalar("date_mens", Hibernate.DATE)
                    .addScalar("power", Hibernate.DOUBLE)
                    .setParameter(0, dateFrom)
                    .setParameter(1, dateTill)
                    .setResultTransformer(Transformers.aliasToBean(EntityJoin.class)).list();
    }

    public List<FiderGraphEntity> showCurrentOfFiders(AbstractDataTS ts1, AbstractDataTS ts2, Date dateFrom, Date dateTill,String[] fider12, String[] fider34){
        String table1 = ts1.getClass().getAnnotation(Table.class).name();
        String table2 = ts2.getClass().getAnnotation(Table.class).name();
        String query = "SELECT	date_mensuration + time_mensuration as time_line" +
                               ",the_current as current_fider" +
                               ",meter_id" +
                               ",1 as numTS" +
                     " FROM " + table1 +
                     " WHERE	(date_mensuration + time_mensuration BETWEEN ? AND ?)" +
                               " AND (meter_id=? OR meter_id=?)" +
                     " UNION ALL" +
                    " SELECT	date_mensuration + time_mensuration as time_line" +
                               ",the_current as current_fider" +
                               ",meter_id" +
                               ",2 as numTS" +
                    " FROM	" + table2 +
                    " WHERE     (date_mensuration + time_mensuration BETWEEN ? AND ?)" +
                              " AND (meter_id=? OR meter_id=?)" +
                    " ORDER BY time_line,numTS,meter_id";
        return  sessionFactory.getCurrentSession().createSQLQuery(query)
                .addScalar("time_line", Hibernate.DATE)
                .addScalar("current_fider", Hibernate.DOUBLE)
                .addScalar("meter_id", Hibernate.INTEGER)
                .addScalar("numTS", Hibernate.INTEGER)
                .setParameter(0, dateFrom)
                .setParameter(1, dateTill)
                .setParameter(2, Integer.parseInt(fider12[0]))
                .setParameter(3, Integer.parseInt(fider12[1]))
                .setParameter(4, dateFrom)
                .setParameter(5, dateTill)
                .setParameter(6, Integer.parseInt(fider34[0]))
                .setParameter(7, Integer.parseInt(fider34[1]))
                .setResultTransformer(Transformers.aliasToBean(FiderGraphEntity.class)).list();
    }

}

