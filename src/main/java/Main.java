import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.ArrayList;
import java.util.Random;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {

        JDA bot = JDABuilder.createDefault("")
                .setActivity(Activity.watching( "ta mère se faire baiser"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();
        bot.addEventListener(new Main());

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        if(event.getMessage().getContentRaw().contains("twitter.com") && !event.getAuthor().isBot()){
            String[] args = event.getMessage().getContentRaw().split("//twitter.com");
            event.getChannel().sendMessage("https://fxtwitter.com" + args[1]).queue();
            event.getMessage().delete().queue();
        }
        else if (event.getMessage().getContentRaw().contains("feur") && !event.getAuthor().isBot() || event.getMessage().getContentRaw().contains("Feur") && !event.getAuthor().isBot()){
            int a = getRandomNumberInRange(1, 2);
            if(a==1){
                int b = getRandomNumberInRange(1, 2);
                if(b==1) {
                    event.getChannel().sendMessage("T'es génant").queue();
                }
                else{
                    event.getChannel().sendMessage(cringe()).queue();
                }
            }
        }
        else if(event.getMessage().getContentRaw().toLowerCase().contains("qui ?") && !event.getAuthor().isBot() || event.getMessage().getContentRaw().toLowerCase().equals("qui") && !event.getAuthor().isBot()){
            int a = getRandomNumberInRange(1, 2);
            if(a==1){
                event.getChannel().sendMessage("J'avoue qui à demandé ?").queue();
            }
            else {
                event.getChannel().sendMessage("Tu es cringe à dire ''qui ?''").queue();
            }
        }
        else if(event.getMessage().getContentRaw().toLowerCase().contains("!ratio") && !event.getAuthor().isBot()){
            int a = getRandomNumberInRange(1, 2);
            if(a==1){
                event.getChannel().sendMessage("Nan ta gueule").queue();
            }
            else {
                String[] args = event.getMessage().getContentRaw().split(" ");
                event.getChannel().sendMessage(event.getMessage().getAuthor().getName() + " ratio " + args[1] + ratio()).queue();
                event.getMessage().delete().queue();
            }
        }
        else if(event.getMessage().getContentRaw().toLowerCase().contains("!chad") && !event.getAuthor().isBot()){
            String[] args = event.getMessage().getContentRaw().split(" ");
            event.getChannel().sendMessage(args[1] + " " + event.getMessage().getAuthor().getName() + " te considère comme un chad et il à raison car tu en est vraiment un").queue();
            event.getChannel().sendMessage(chad()).queue();
        }
        else if(event.getMessage().getContentRaw().toLowerCase().equals("!fonction")){
            event.getChannel().sendMessage(
                    "Commandes :\n" +
                            "`!ratio` nomDePersonneARatio : a une chance sur deux de ratio la personne nommée ou de ratio la persone qui a écrit la commande\n" +
                            "`!chad` nomDuChad : envoie un message disant que la personne nommée est considérée comme un chad par l'auteur du message\n" +
                            "`!fonction` : affiche la liste des commandes et fonctions\n" +
                            "\n" +
                            "Fonctions Autonomes :\n" +
                            "`feur` : 1 chance sur 2 d'insulter une personne ayant répondu \"feur\" a un message \"quoi ?\" soit en lui disant de la fermer sois en envoyant un gif/image disant cringe\n" +
                            "`qui ?` : 1 chance sur 2 de répondre \"j'avoue qui a demandé\", 1 chance sur 2 de dire \"t'es cringe a dire \"qui ?\"\"\n" +
                            "`twitter` : change automatiquement les liens twitter en liens optimisés et non bugés\n"
            ).queue();
        }
        else if(event.getMessage().getContentRaw().equals("!balleperdue")){
            event.getChannel().sendMessage(nomBalle() + insulteBalle()).queue();
        }
    }

    public String ratio(){
        ArrayList<String> ratio = new ArrayList<>();
        ratio.add(" la salope");
        ratio.add(" la petite pute");
        ratio.add(" la merde");
        ratio.add(" le sous humain");
        return ratio.get(getRandomNumberInRange(0,3));
    }

    public String chad(){
        ArrayList<String> chad = new ArrayList<>();
        chad.add("https://tenor.com/view/chad-music-music-sigma-chad-listening-music-chad-headphones-gif-25379685");
        chad.add("https://tenor.com/view/doctor-david-livesey-david-livesey-doctor-livesey-chad-rom-and-skull-gif-26497072");
        chad.add("https://www.netcost-security.fr/wp-content/uploads/2021/04/Giga-Chad.jpg");
        return chad.get(getRandomNumberInRange(0,2));
    }

    public String cringe(){
        ArrayList<String> gif = new ArrayList<>();
        gif.add("https://tenor.com/view/dies-of-cringe-cringe-gif-20747133");
        gif.add("https://tenor.com/view/cringe-youre-cringe-dies-of-cringe-cringe-af-gif-25319855");
        gif.add("https://tenor.com/view/cringe-gif-23594630");
        gif.add("https://i1.sndcdn.com/artworks-lFHmV922CalFXzTx-1BzOMg-t500x500.jpg");
        gif.add("https://ih1.redbubble.net/image.713481123.5957/flat,800x800,075,f.u2.jpg");
        return gif.get(getRandomNumberInRange(0,4));
    }

    private String nomBalle(){
        ArrayList<String> nom = new ArrayList<>();
        nom.add("Félix");
        nom.add("Flavian");
        nom.add("Benjamin");
        nom.add("Théo");
        nom.add("Nathan");
        nom.add("Lucas");
        return nom.get(getRandomNumberInRange(0,5));
    }

    private String insulteBalle(){
        ArrayList<String> insulte = new ArrayList<>();
        insulte.add(" sale pute");
        insulte.add(" va te faire foutre");
        insulte.add(" chien");
        insulte.add(" t'es une merde");
        insulte.add(" j'éspère que tu va te cogner le petit orteil très très fort");
        return insulte.get(getRandomNumberInRange(0,4));
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
