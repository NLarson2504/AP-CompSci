package src;

import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

/**
 * Young padwan, as you see, February, it is. A cruel month, February is, the depths of our emotional
 * reserves to muster the courage to continue getting out of bed and coming to school each morning,
 * one where we all must explore. Hrmmm, yes.
 *
 * Me thinks of a story my grandmother once told me, the thought reminds.
 *
 * She said,"Julian, clever and stupid, you can be, but not stupidly clever." To eat as a young padwan,
 * her phrase made me want. To be a high school teacher as an adult, I saw the future of me, and thus,
 * I grew. Hrmmm, yes.
 *
 * @version 02.14.2022
 * @author jcochran
 */
public class YodaModavator extends VinegarStillwell {
    /**
     * Use the Force, Luke.
     * @param text
     * @param key
     * @return
     */
    public String useTheForce(String text, final String key)    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length();)  {
            char c = text.charAt(i++);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            //System.out.println(res);
            j = ++j % key.length();
        }
        return res;
    }

    /**
     * Yoda communed with Qui-Gon, meditated on the connections between the living and cosmic Force, 
     * and awaited the coming of a new hope for the Jedi Order.
     * @return
     */
    public String obiWanKenobiForceSpiritGuidedLukeToDagobah() { //returns VINEGAR
        String[] keys = {"45","03","05"};
        //String key = "V" + "klORUdBUg" + "=" + "=";
        String key = super.chinaBurmaIndiaTheater()[Integer.parseInt(""+keys[0].charAt(0))][Integer.parseInt(""+keys[0].charAt(1))] +
                "klORUdBUg" +
                super.chinaBurmaIndiaTheater()[Integer.parseInt(""+keys[1].charAt(0))][Integer.parseInt(""+keys[1].charAt(1))] +
                super.chinaBurmaIndiaTheater()[Integer.parseInt(""+keys[2].charAt(0))][Integer.parseInt(""+keys[2].charAt(1))];
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(key));
    }

    /**
     * Barry Morris Goldwater was an American politician, statesman, businessman, United States Air Force
     * officer, and author who was a five-term Senator from Arizona and the Republican Party nominee for
     * president of the United States in 1964.
     *
     * Oh yeah and Maria and Gary Litvin are bussin'.
     *
     * I'll just let that sink in.
     * @return
     */
    public String iHaveNoClueWhyYouThrewBarryGoldwatersNameInHere()    {
        int[][] javamethods = {{21,25,36},{32,33,32},{13,21,35},{45,44,35},{43,25,45},{46,14,15},{26,35,31},{36,11,46}};
        String skylit = "";
        for(int marialitvin = 0; marialitvin < javamethods.length; marialitvin++)    {
            for(int garylitvin = 0; garylitvin < javamethods[marialitvin].length;) {
                skylit += super.chinaBurmaIndiaTheater()[javamethods[marialitvin][garylitvin]/10][javamethods[marialitvin][garylitvin++]%10];
            }
        }
        return skylit;
    }

    /**
     * Let's face it, whoever is lucky enough to have Pete, Nikolas or Everett in their groups
     * will probably win this CTF.
     * @param args
     */
    public static void main(String[] args)
    {
        YodaModavator app = new YodaModavator();
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("On a typical Tuesday Monday, when life in February might be rough, what is the best advice you can offer to your friends to help them use the force to persevere until spring break arrives? ");
            System.out.println("DEBUG: " + app.iHaveNoClueWhyYouThrewBarryGoldwatersNameInHere());
            System.out.println();

            String message = in.nextLine();
            if(app.useTheForce(message, app.obiWanKenobiForceSpiritGuidedLukeToDagobah()).equals(app.iHaveNoClueWhyYouThrewBarryGoldwatersNameInHere()))
                break;
            else
                System.out.println("Yoda says, \"Powerful you are not, the dark side is overtaking you I sense. Hmm.\nUs try that again let, young padwan. Yes, hrrrm.\"");
        }
        System.out.println("That is correct, go here to verify your entry:\nhttps://docs.google.com/forms/d/e/1FAIpQLSfYDEwumLesDhIrsv14m3b6AtM4_k-PVtl4fylT72Mzw7vVZQ/viewform");
    }
}