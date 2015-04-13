package net.eutkin.data.controller;

import net.eutkin.data.entity.*;
import net.eutkin.data.service.IDataMensService;
import org.apache.commons.collections.map.LinkedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class ShowController extends AbstractController {

    @Autowired
    private IDataMensService dataMensService;

    @RequestMapping(value="/filter", method = RequestMethod.GET)
    public ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("filter");
        Map<Integer, String> map = new LinkedMap();
        map.put(1, "Подволошная");map.put(2, "Бойцы");map.put(3, "Кузино");map.put(4, "Сабик");map.put(5, "Сарга");map.put(6, "Шаля");
        StringBuilder sb = new StringBuilder(" ");
        try {
            modelAndView.addObject("entities",sb);
            modelAndView.addObject("ts", map);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

}