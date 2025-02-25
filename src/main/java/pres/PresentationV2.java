package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PresentationV2 {
    //dynamic version
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("config.txt"));
            String daoClassName = scanner.nextLine();
            System.out.println("Class: " + daoClassName);

            //DaoImpl d = new DaoImpl();
            Class cDao=Class.forName(daoClassName);
            IDao dao = (IDao) cDao.getConstructor().newInstance();
            System.out.println("Dao: " + dao.getData());

            //MetierImpl metier = new MetierImpl(d);
            String metierClassName = scanner.nextLine();
            System.out.println("Metier: " + metierClassName);
            Class cMetier=Class.forName(metierClassName);
            //using constructor
            //IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

            //using setter
            IMetier metier = (IMetier) cMetier.getConstructor().newInstance();

            //metier.setDao(d);
            Method setDao=cMetier.getDeclaredMethod("setDao", IDao.class);
            setDao.invoke(metier,dao);

            System.out.println("Resultat "+metier.calcul());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
