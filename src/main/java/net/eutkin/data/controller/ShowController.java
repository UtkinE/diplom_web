package net.eutkin.data.controller;

import net.eutkin.data.entity.AbstractDataTS;
import net.eutkin.data.entity.DataTS1;
import net.eutkin.data.entity.DataTS2;
import net.eutkin.data.service.IDataMensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ShowController extends AbstractController {

    @Autowired
    private IDataMensService dataMensService;

    @RequestMapping(value="/show", method = RequestMethod.GET)
    public ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView("show");
        try {
            modelAndView.addObject("dataMensList", dataMensService.showAllData(new DataTS1()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

}