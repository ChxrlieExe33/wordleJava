
public class Main {

    public static void main(String[] args) {


        String[] words = WordleFileManager.readFileWords();

        WordleFeedBack feedback = new WordleFeedBack();

        String result = feedback.feedBackString("AAABB", "AAAAA");

        System.out.println(result);

        /*
        for (String word : words) {
            System.out.println(word);
        }

        */

    }

}