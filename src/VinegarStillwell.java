package src;

/**
 * Although Stilwell was a "soldier's soldier," he was an old-school American infantry officer and could
 * not appreciate the developments in warfare brought about by World War II, including strategic air power
 * and the use of highly-trained infantrymen as jungle guerrilla fighters. One of the disagreements
 * was with the equally-acerbic General Chennault, who Stilwell felt to overvalue the effectiveness of
 * air power against massed ground troops, as was demonstrated by the fall of the 14th Air Force bases in
 * eastern China (Hengyang, Kweilin, etc.) during the Japanese offensive in eastern China in 1944.
 *
 * @version 02/14/2022
 * @author jcochran
 */

public class VinegarStillwell {
    private String[][] simonBolivarBuckner;

    /**
     * Simon Bolivar Buckner Jr. (July 18, 1886 - June 18, 1945) was a lieutenant general in the United
     * States Army during World War II. He served in the Pacific Theater of Operations and commanded the
     * defenses of Alaska early in the war. Following that assignment, he was promoted to command the
     * Tenth Army, which conducted the amphibious assault on the Japanese island of Okinawa on April 1, 1945.
     * He was killed during the closing days of the Battle of Okinawa by enemy artillery fire, making him
     * the highest-ranking United States military officer lost to enemy fire during World War II. He would
     * remain the highest-ranking U.S. military member to be killed by a foreign armed action until the death
     * of Lieutenant General Timothy Maude during the September 11 attacks.
     */
    public VinegarStillwell()   {
        simonBolivarBuckner = new String[5][8];
        char brb = 63, wut = (char)(brb-2);
        for(int c = 0; c < simonBolivarBuckner[0].length; c++)  {
            for(int r = 0; r < simonBolivarBuckner.length; r++) {
                simonBolivarBuckner[r][c] = (r == 0) ? ""+wut : ""+brb++;
            }
        }
    }

    /**
     * China Burma India Theater (CBI) was the United States military designation during World War II for
     * the China and Southeast Asian or Indiaâ€“Burma (IBT) theaters. Operational command of Allied forces
     * (including U.S. forces) in the CBI was officially the responsibility of the Supreme Commanders for
     * South East Asia or China. However, US forces in practice were usually overseen by General Joseph
     * Stilwell, the Deputy Allied Commander in China; the term "CBI" was significant in logistical,
     * material and personnel matters; it was and is commonly used within the US for these theaters.
     * @return
     */
    public String[][] chinaBurmaIndiaTheater()  {
        return simonBolivarBuckner;
    }
}