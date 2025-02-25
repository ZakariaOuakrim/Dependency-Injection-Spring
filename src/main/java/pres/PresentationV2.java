package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
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
            IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);

            System.out.println("Resultat "+metier.calcul());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
