package net.eutkin.data.controller;

import net.eutkin.data.service.IDataMensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FiderGraphController {
    @Autowired
    private IDataMensService dataMensService;

    @RequestMapping(value="/fider_graph", method = RequestMethod.POST)
    public ModelAndView filterPost(HttpServletRequest request,
                                   HttpServletResponse response)
            throws Exception {
    return new ModelAndView();
    }
}
