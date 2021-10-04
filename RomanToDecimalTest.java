import static org.junit.Assert.*;

/**
 * AYY WELCOME TO THE *TEST* FOR THE ROMAN TO DECIMAL METHOD
 * PRETTY MUCH CHECKS TO MAKE SURE MR "ROMAN TO DECIMAL" IS DOING HIS JOB CORRECTLY
 * (checks romanToDecimal method and makes sure it works under all types of input).
 */
public class RomanToDecimalTest {

    @org.junit.Test
    public void romanToDecimal() {
        assertEquals(RomanToDecimal.romanToDecimal("XI"), 11);
        assertEquals(RomanToDecimal.romanToDecimal("IV"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("XC"), 90);
        assertEquals(RomanToDecimal.romanToDecimal("V"), 5);
        assertEquals(RomanToDecimal.romanToDecimal("IXIX"), 20);
        assertEquals(RomanToDecimal.romanToDecimal("MCMI"), 1901);
        assertEquals(RomanToDecimal.romanToDecimal("MCXI"), 1111);
        assertEquals(RomanToDecimal.romanToDecimal("Rawr"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("XLI"), 41);
        assertEquals(RomanToDecimal.romanToDecimal("CLB"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("CLM"), 1150);
        assertEquals(RomanToDecimal.romanToDecimal("IIIIIIIIII"), 10);
        assertEquals(RomanToDecimal.romanToDecimal("IXLCDMDCLXI"), 2100);
        assertEquals(RomanToDecimal.romanToDecimal("IXL"), 39);
        assertEquals(RomanToDecimal.romanToDecimal("Membean"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("LILOP"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("XIII"), 13);
        assertEquals(RomanToDecimal.romanToDecimal("You know what, I'm done, done, done\n" +
                "Yeah, I'm gonna take my horse\n" +
                "To the old town road\n" +
                "I'm gonna ride 'til I can't no more\n" +
                "I'm gonna take my horse to the old town road\n" +
                "I'm gonna ride (Kio, Kio) 'til I can't no more\n" +
                "I got the horses in the back\n" +
                "Horse tack is attached\n" +
                "Hat is matte black\n" +
                "Got the boots that's black to match\n" +
                "Riding on a horse, ha\n" +
                "You can whip your Porsche\n" +
                "I been in the valley\n" +
                "You ain't been up off the porch, now\n" +
                "Can't nobody tell me nothing\n" +
                "You can't tell me nothing\n" +
                "Can't nobody tell me nothing\n" +
                "You can't tell me nothing\n" +
                "Riding on a tractor\n" +
                "Lean all in my bladder\n" +
                "Cheated on my baby\n" +
                "You can go and ask her\n" +
                "My life is a movie\n" +
                "Bull riding and boobies\n" +
                "Cowboy hat from Gucci\n" +
                "Wrangler on my booty\n" +
                "Can't nobody tell me nothing\n" +
                "You can't tell me nothing\n" +
                "Can't nobody tell me nothing\n" +
                "You can't tell me nothing\n" +
                "Yeah, I'm gonna take my horse\n" +
                "To the old town road\n" +
                "I'm gonna ride 'til I can't no more\n" +
                "I'm gonna take my horse to the old town road\n" +
                "I'm gonna ride 'til I can't no more\n" +
                "I got the"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"), 50000);
        assertEquals(RomanToDecimal.romanToDecimal("MMMMMMMMMMM_CHICKY_NUGGIEZ"), -1);

        assertNotEquals(RomanToDecimal.romanToDecimal("Joe"), 20);
        assertNotEquals(RomanToDecimal.romanToDecimal("MUMA"), 2000);

    }
}