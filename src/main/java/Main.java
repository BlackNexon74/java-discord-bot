import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class Main {

    public static void main(String[] args){

        JDA bot = JDABuilder.createDefault("token")
                .setActivity(Activity.watching("ur mom get banged"))
                .build();
    }
}
