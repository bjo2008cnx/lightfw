package org.lightfw.tutorial.helper;

/**
 * 被Javassit 改写的目标类
 */
public class Javassitee {

    private String name = "default";

    public Javassitee() {
        name = "me";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void execute() {
        System.out.println(name);
        System.out.println("execute ok");
    }
}