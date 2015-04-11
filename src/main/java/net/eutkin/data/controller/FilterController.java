package net.eutkin.data.controller;

import net.eutkin.data.entity.DataTS1;
import net.eutkin.data.entity.EntityJoin;
import net.eutkin.data.entity.TsMeters;
import net.eutkin.data.service.IDataMensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class FilterController extends HttpServlet{

    @Autowired
    private IDataMensService dataMensService;

    @RequestMapping(value="/filter_post", method = RequestMethod.POST)
    public ModelAndView filterPost(HttpServletRequest request,
                                              HttpServletResponse response)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("join_show");
        String sDateInput = request.getParameter("date");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        Date date = sdf.parse(sDateInput);
        List<EntityJoin> entities = dataMensService.showBalanceOfPower(new DataTS1(),date);
        try{
            modelAndView.addObject("entities",entities);
        } catch (Exception e){
            e.printStackTrace();
        }
        return modelAndView;
    }
}

