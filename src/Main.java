
public class Main {
    public static void main(String[] args) {

        Preprocess pre = new Preprocess();
        String input = "Dün ODTÜ de verilan kursta Design Patternler hakkında bir çok şey öğrendim :)";

        input = input.replaceAll("\\p{P}", "");         //REMOVE ALL PUNCTION
        String[] words = input.split(" ");
        System.out.println(input);
        System.out.println(pre.fixSentence(words));
    }
}