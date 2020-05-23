
import java.util.Random;


public class PasswordGenerator {

    //ovdje će biti pobrojani karakteri od kojih mogu formirati lozinku
    private static final String MOGUCA_KARAKTERI ="abcdefghijklmnoprskslfmkdfdkfmdk123456789!*%&#";
    //minimalna dužina lozinke
    private static final int MINIMUM_PASSWORD_LENGTH = 5;
    
    //1 stvar :  + SADRŽAJ lozinke je uvijek drugačiji
    //Random random = new Random();
    //int slucajniBroj = random.nextInt(20);//0-19
    public String generatePassword() {
        Random random = new Random();
        //5+
        int slucajniBroj = random.nextInt(11);// 0-10 3
        int duzinaLozinke = MINIMUM_PASSWORD_LENGTH + slucajniBroj;//5+slucajniBroj=8
        StringBuilder sb = new StringBuilder();
        //0 - 7
        for(int i = 0; i<duzinaLozinke; i++){
            //0 
            int slucajnaPozicija = random.nextInt(MOGUCA_KARAKTERI.length());//0-29
            char slucajniKarakter = MOGUCA_KARAKTERI.charAt(slucajnaPozicija);
            sb.append(slucajniKarakter);
        }
        return sb.toString();
    }
}
