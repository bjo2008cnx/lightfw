package org.lightfw.tutorial.helper;

import javassist.*;

/**
 * @author Michael.Wang
 * @date 2016/12/7
 */
public class ChangeDemo {
    public static void main(String[] args) throws NotFoundException, CannotCompileException {
        //String className = Javassitee.class.getName();  //error if uncomment this line.
        String className="org.lightfw.tutorial.helper.Javassitee";
        System.out.println(className);
        replaceMethodBody(className, "execute", "System.out.println(\"this method is changed dynamically!\");");
        Javassitee student = new Javassitee();
        student.execute();
    }

    public static void replaceMethodBody(String className, String methodName, String newMethodBody) {
        try {
            CtClass e = ClassPool.getDefault().get(className);
            CtMethod method = e.getDeclaredMethod(methodName);
            method.setBody(newMethodBody);
            e.toClass();
        } catch (CannotCompileException | NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
