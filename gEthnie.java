package packglad;

import java.util.ArrayList;

public class gEthnie {

    private static ArrayList<Ethnie> ttesLesEthnies = new ArrayList<Ethnie>();
    
    public static ArrayList<Gladiateur> listerGladiateursDEthnie(Integer ide) {
        int i=0;
        Boolean fin = false;//booléen vrai si on a trouvé l'ethnie qu'on veut parmi celles de la collection
        while (i< ttesLesEthnies.size() && !fin)
        {
            if(ttesLesEthnies.get(i).getIde()==ide)
            {
                fin=true;
            }
            else
                i++;
        }

        return ttesLesEthnies.get(i).listerGladiateurs();
    }

    public static ArrayList<Ethnie> listerEthnies() {
        return ttesLesEthnies;
    }

    public static Ethnie getEthnie(Integer ide) {
        int i=0;
        Boolean fin = false;
        while (i< ttesLesEthnies.size() && !fin)
        {
            if(ttesLesEthnies.get(i).getIde()==ide)
            {
                fin=true;
            }
            else
                i++;
        }

        return ttesLesEthnies.get(i);

    }

    public static Integer getScore(Integer ide) {
        int i=0;
        Boolean fin = false;
        while (i< ttesLesEthnies.size() && !fin)
        {
            if(ttesLesEthnies.get(i).getIde()==ide)
            {
                fin=true;
            }
            else
                i++;
        }

        return ttesLesEthnies.get(i).calculerScore();
    }
}
