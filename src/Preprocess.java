import com.detectlanguage.DetectLanguage;
import com.detectlanguage.Result;
import com.detectlanguage.errors.APIError;
import zemberek.langid.LanguageIdentifier;
import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.normalization.TurkishSpellChecker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tunc on 21.12.2017.
 */
public class Preprocess {

    private TurkishMorphology morphology;
    private LanguageIdentifier lid;
    private TurkishSpellChecker spellChecker;

    Preprocess(){
        DetectLanguage.apiKey = "9bfd594c4e183f585df9a7af194c7ed3";
        try {
            morphology = TurkishMorphology.createWithDefaults();
            lid = LanguageIdentifier.fromInternalModels();
            spellChecker = new TurkishSpellChecker(morphology);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String fixSentenceLangs(String[] input){
        HashMap<String,String> languages = detectLanguages(input);
        String fixedSentence = fixWords(input,languages);

        return fixedSentence;
    }

    public String fixSentence(String[] input){
        String fixedSentence = fixWords(input,null);

        return fixedSentence;
    }

    private HashMap<String,String> detectLanguages(String[] words){

        HashMap<String,String> languages = new HashMap<String, String>();

        //Identify languages using zemberek's language identifier
        for(int i = 0; i < words.length;i++){
            String lang = lid.identify(words[i]);

            if(!(lang.equalsIgnoreCase("tr"))){
                try {
                    List<Result> result = DetectLanguage.detect(words[i]);
                    languages.put(words[i],result.get(0).language);

                } catch (APIError apıError) {
                    apıError.printStackTrace();
                }
            }
            else{
                languages.put(words[i],lang);
            }
        }

        System.out.println("LANGUAGES");
        for(int i = 0;i<languages.size();i++){
            System.out.println(words[i] + " -> " + languages.get(words[i]));
        }
        return languages;
    }

    private String fixWords(String[] words,HashMap<String,String> languages){

        ArrayList<String> wrongWords = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        String[] fixedWords = words;

        if(languages!=null){
            for(String word:words){
                System.out.println(word + " -> " + languages.get(word));
            }
            for(int i = 0; i < words.length;i++){

                if((languages.get(words[i]).equalsIgnoreCase("tr"))){
               /* Boolean check = spellChecker.check(words[i]);
                System.out.println(words[i] + " -> " + check);*/

                    if(!spellChecker.check(words[i])){
                        wrongWords.add(words[i]);
                    }
                }
            }
            for (int i = 0;i<words.length;i++){

                //System.out.println(s + " -> " + spellChecker.suggestForWord(s));
                if(wrongWords.contains(words[i])){
                    fixedWords[i] = spellChecker.suggestForWord(fixedWords[i]).get(0);
                }
                builder.append(fixedWords[i]);
                builder.append(" ");
            }
        }
        else{
            for(int i = 0; i < words.length;i++){
                if(!spellChecker.check(words[i])){
                    fixedWords[i] = spellChecker.suggestForWord(words[i]).get(0);
                }
                builder.append(fixedWords[i]);
                builder.append(" ");
            }

        }



        String fixedString = builder.toString();

        return fixedString;
    }

}
