package org.lightfw.tutorial.web;


import lombok.extern.log4j.Log4j2;
import org.lightfw.utilx.dynamic.JavassitUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 通用的监听器,一个项目可以只配置一个监听器，在一个监听器中完成初始化工作
 */
@Log4j2
public class JavassitContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("容器初始化................");
        String className = "org.lightfw.tutorial.helper.Javassitee";
        System.out.println(className);
        JavassitUtil.replaceMethodBody(className, "execute", "System.out.println(\"Javassitee's execute() is changed dynamically!\");");
        System.out.println("容器初始化完成");
    }

    public void contextDestroyed(ServletContextEvent sc) {
        System.out.println("容器安全关闭");
    }
}
