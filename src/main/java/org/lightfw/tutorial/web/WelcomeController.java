package org.lightfw.tutorial.web;

import org.lightfw.tutorial.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    private final Logger logger = LoggerFactory.getLogger(WelcomeController.class);
    private final HelloWorldService helloWorldService;

    @Autowired
    public WelcomeController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Map<String, Object> model) {
        logger.debug("index() is executed!");
        model.put("title", helloWorldService.getTitle(""));
        model.put("msg", helloWorldService.getDesc());

        return "index";
    }

    @RequestMapping(value = "/hello/{name:.+}", method = RequestMethod.GET)
    public ModelAndView hello(@PathVariable("name") String name) {
        logger.debug("hello() is executed - $name {}", name);
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("title", helloWorldService.getTitle(name));
        model.addObject("msg", helloWorldService.getDesc());
        return model;
    }

    @RequestMapping(value = "/user/saveUsers", method = {RequestMethod.POST})
    @ResponseBody
    public void saveUsers(@RequestBody List<User> users) {  //这边如果是通过表单提交的则不能加RequestBody
        logger.debug("saveUser() is executed!");
        for (User u : users) {
            System.out.println(u.getUserName() + ":" + u.getAddress());
        }
    }

    @RequestMapping(value = "/user/saveUser", method = {RequestMethod.POST})
    @ResponseBody
    public void saveUser(@RequestBody User u) {  //这边如果是通过表单提交的则不能加RequestBody
        logger.debug("saveUser() is executed!");
        System.out.println(u.getUserName() + ":" + u.getAddress());
    }
}