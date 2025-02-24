package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    private IDao dao;
    @Override
    public double calcul() {
        double t = dao.getData();
        double res = t*23;
        return 0;
    }
    //injecter dans la variable un objet d'une classe qui implément l'interface Idao
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
