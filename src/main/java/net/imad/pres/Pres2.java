package net.imad.pres;

import net.imad.dao.IDao;
import net.imad.metier.IMetier;


import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("config.txt"));

        String daoClassName = scanner.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao d =(IDao) cDao.newInstance(); // constrcuteur sans paramètres

        String metierClassName = scanner.nextLine();
        Class cMetier = Class.forName(metierClassName);
        //IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(d);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(d); // constrcuteur sans paramètres


        System.out.println("RES = "+metier.calcul());
    }
}

