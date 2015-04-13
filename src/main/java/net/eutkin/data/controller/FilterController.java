package net.eutkin.data.controller;

import net.eutkin.data.entity.*;
import net.eutkin.data.service.IDataMensService;
import org.apache.commons.collections.map.LinkedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class FilterController extends HttpServlet{

    @Autowired
    private IDataMensService dataMensService;

    @RequestMapping(value="/filter_post", method = RequestMethod.POST)
    public ModelAndView filterPost(HttpServletRequest request,
                                              HttpServletResponse response)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("filter");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        String sDateInput = request.getParameter("dateFrom");
        Date dateFrom = sdf.parse(sDateInput);
        sDateInput = request.getParameter("dateTill");
        Date dateTill = sdf.parse(sDateInput);
        Map<Integer,String> map = new LinkedMap();
        map.put(1,"Подволошная");map.put(2,"Бойцы");map.put(3,"Кузино");map.put(4,"Сабик");map.put(5,"Сарга");map.put(6,"Шаля");
        Integer tsId = Integer.parseInt(request.getParameter("ts_select"));
        AbstractDataTS dataTS = new DataTS1();
        switch (tsId){
            case 1: {dataTS = new DataTS1();break;}
            case 2: {dataTS = new DataTS2();break;}
            case 3: {dataTS = new DataTS3();break;}
            case 4: {dataTS = new DataTS4();break;}
            case 5: {dataTS = new DataTS5();break;}
            case 6: {dataTS = new DataTS6();break;}
        }
        List<EntityJoin> entities = dataMensService.showBalanceOfPower(dataTS,dateFrom,dateTill);

        StringBuilder sb = new StringBuilder();
        sb.append("\"Time,Balance of power\\n\"+\n");
        DecimalFormat df = new DecimalFormat("#");
        int i = 0,n=120;
        //Double power = 0.0;
        for(EntityJoin entity : entities){
            if(i%n != 0){
                //power += entity.getPower();
            } else {
                sb.append("\"");
                sb.append(i/n);
                sb.append(",");
                sb.append(df.format(entity.getPower()).replace(",", "."));
                sb.append("\\n\"+\n");
                //power = 0.0;
            }
            i += 3;
        }
        sb.setLength(sb.length()-2);
        System.out.println(sb.toString());

        try{
            modelAndView.addObject("entities", sb);
            //modelAndView.addObject("entities",entities);
            modelAndView.addObject("dateFrom", dateFrom);
            modelAndView.addObject("dateTill",dateTill);
            modelAndView.addObject("select_ts",tsId);
            modelAndView.addObject("ts",map);
            System.out.println(entities);
        } catch (Exception e){
            e.printStackTrace();
        }
        return modelAndView;
    }
}

