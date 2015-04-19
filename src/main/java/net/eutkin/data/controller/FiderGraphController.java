package net.eutkin.data.controller;

import net.eutkin.data.entity.*;
import net.eutkin.data.factory.DataTSFactory;
import net.eutkin.data.service.IDataMensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class FiderGraphController {
    @Autowired
    private IDataMensService dataMensService;

    private static StringBuilder createSb(List<FiderGraphEntity> entities){
        StringBuilder sb = new StringBuilder();
        sb.append("\"Time,Fider1,Fider2,Fider3,Fider4\\n\"+\n");
        DecimalFormat df = new DecimalFormat("#.##");
        int i = 0,n = 1;
        for(int j=0;j<entities.size()-4;j+=4){
            sb.append("\"");
            sb.append(i / n);
            sb.append(",");
            sb.append(df.format(entities.get(j).getCurrent_fider()).replace(",", "."));
            sb.append(",");
            sb.append(df.format(entities.get(j+1).getCurrent_fider()).replace(",", "."));
            sb.append(",");
            sb.append(df.format(entities.get(j+2).getCurrent_fider()).replace(",", "."));
            sb.append(",");
            sb.append(df.format(entities.get(j+3).getCurrent_fider()).replace(",", "."));
            sb.append("\\n\"+\n");
            i += 3;
        }
        sb.setLength(sb.length()-2);


        return sb;
    }
    @RequestMapping(value="/fider", method = RequestMethod.POST)
    public ModelAndView fiderPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("fider");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Map<String,String[]> paramsValues = request.getParameterMap();
        String[] buf = paramsValues.get("dateFrom");
        Date dateFrom = sdf.parse(buf[0]);
        buf = paramsValues.get("dateTill");
        Date dateTill = sdf.parse(buf[0]);
        buf = paramsValues.get("ts_select1");
        Integer numberTS = Integer.parseInt(buf[0]);
        AbstractDataTS dataTS1 = new DataTSFactory(numberTS).getDataTS();
        buf = paramsValues.get("ts_select2");
        numberTS = Integer.parseInt(buf[0]);
        AbstractDataTS dataTS2 = new DataTSFactory(numberTS).getDataTS();
        String[] fider12 = paramsValues.get("fider12_select");
        String[] fider34 = paramsValues.get("fider34_select");
        List<FiderGraphEntity> entities = dataMensService.showCurrentOfFiders(dataTS1,dataTS2,dateFrom,dateTill,fider12,fider34);
        StringBuilder sb = createSb(entities);
        try {
            modelAndView.addObject("entities",sb);
            modelAndView.addObject("dateFrom", dateFrom);
            modelAndView.addObject("dateTill",dateTill);
        } catch (Exception e) {
            e.printStackTrace();
        }
    return modelAndView;
    }

    @RequestMapping(value="/fider", method = RequestMethod.GET)
    public ModelAndView fiderGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("fider");
        StringBuilder sb = new StringBuilder(" ");
        try {
            modelAndView.addObject("entities",sb);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }
}
