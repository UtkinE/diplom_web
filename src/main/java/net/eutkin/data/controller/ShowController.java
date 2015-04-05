package net.eutkin.data.controller;

import net.eutkin.data.service.IDataMensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ShowController extends AbstractController {

    @Autowired
    private IDataMensService dataMensService;

    @RequestMapping("/show")
    protected ModelAndView handleRequestInternal(HttpServletRequest request,
                                                 HttpServletResponse response)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject("dataMensList", dataMensService.showAllData());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return modelAndView;
    }

}