import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Gifs {

    ArrayList<String> gif = new ArrayList<>();

    public static String cringe(){
        ArrayList<String> gif = new ArrayList<>();
        String res = new String();
        gif.add("https://tenor.com/view/dies-of-cringe-cringe-gif-20747133");
        gif.add("https://tenor.com/view/cringe-youre-cringe-dies-of-cringe-cringe-af-gif-25319855");
        gif.add("https://tenor.com/view/cringe-gif-23594630");
        gif.add("https://i1.sndcdn.com/artworks-lFHmV922CalFXzTx-1BzOMg-t500x500.jpg");
        gif.add("https://ih1.redbubble.net/image.713481123.5957/flat,800x800,075,f.u2.jpg");
        return gif.get(getRandomNumberInRange(0,4));
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
