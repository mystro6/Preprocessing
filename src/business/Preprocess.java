/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * Preprocessing and other workflows of business layer.
 */

package business;

import java.util.List;
import java.util.stream.IntStream;

import org.antlr.v4.runtime.Token;
import com.detectlanguage.DetectLanguage;
import zemberek.langid.LanguageIdentifier;
import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.normalization.TurkishSpellChecker;
import zemberek.tokenization.TurkishTokenizer;
import zemberek.tokenization.antlr.TurkishLexer;

public class Preprocess
{
  private TurkishTokenizer tokenizer;
  private TurkishMorphology morphology;
  private TurkishSpellChecker spellchecker;
  private LanguageIdentifier languageidendificaiton;
  
  public Preprocess() throws Exception
  {
    try
    {
      DetectLanguage.apiKey = "9bfd594c4e183f585df9a7af194c7ed3";
      
      this.morphology = TurkishMorphology.createWithDefaults();
      this.spellchecker = new TurkishSpellChecker(this.morphology);
      this.languageidendificaiton = LanguageIdentifier.fromInternalModels();
    }
    catch(Exception ex)
    {
      throw(ex);
    }
  }
  
  // Fix the tweet without language identification
  public String OutputWithoutLangID(String tweet, int[] tokens, Boolean encodechar, char ml_or_lx) throws Exception
  {
    String output = "";
    
    try
    {
      if(encodechar)
        tweet = Encoding.EncodeTRChar(tweet, IntStream.of(tokens).anyMatch(x -> x == 12));
      else
        tweet = Encoding.FixURLs(tweet);
      
      this.tokenizer = TurkishTokenizer.builder().ignoreTypes(tokens).build();
      List<Token> alltokens = this.tokenizer.tokenize(tweet);
      
      for(Token toks: alltokens)
      {
        if(toks.getType() == TurkishLexer.Word)
        {
          if(!this.spellchecker.check(toks.getText()))
          {
            List<String> suggestions = this.spellchecker.suggestForWord(toks.getText());
            
            if(!suggestions.isEmpty())
              output += suggestions.get(0);
            else
              output += toks.getText();
          }
          else
            output += toks.getText();
        }
        else if(toks.getType() == TurkishLexer.WordWithApostrophe)
          output += toks.getText().replace("'", "");
        else if(ml_or_lx == 'm' && !toks.getText().equals("\""))
          output += toks.getText();
        else if(ml_or_lx == 'l')
          output += toks.getText();
      }
    }
    catch(Exception ex)
    {
      throw(ex);
    }
    
    return(output);
  }
  
  // Fix the tweet with language identification using zemberek and another language identification API
  public String OutputWithLangID(String tweet, int[] tokens, Boolean encodechar, char ml_or_lx) throws Exception
  {
    String output = "";
    
    try
    {
      if(encodechar)
        tweet = Encoding.EncodeTRChar(tweet, IntStream.of(tokens).anyMatch(x -> x == 12));
      else
        tweet = Encoding.FixURLs(tweet);
      
      this.tokenizer = TurkishTokenizer.builder().ignoreTypes(tokens).build();
      List<Token> alltokens = this.tokenizer.tokenize(tweet);
      
      for(Token toks: alltokens)
      {
        if(toks.getType() == TurkishLexer.Word && this.languageidendificaiton.identify(toks.getText()).equals("tr"))
        {
          if(!this.spellchecker.check(toks.getText()))
          {
            List<String> suggestions = this.spellchecker.suggestForWord(toks.getText());
            
            if(!suggestions.isEmpty())
              output += suggestions.get(0);
            else
              output += toks.getText();
          }
          else
            output += toks.getText();
        }
        else if(toks.getType() == TurkishLexer.Word && DetectLanguage.detect(toks.getText()).get(0).language.equals("tr"))
        {
          if(!this.spellchecker.check(toks.getText()))
          {
            List<String> suggestions = this.spellchecker.suggestForWord(toks.getText());
            
            if(!suggestions.isEmpty())
              output += suggestions.get(0);
            else
              output += toks.getText();
          }
          else
            output += toks.getText();
        }
        else if(toks.getType() == TurkishLexer.WordWithApostrophe)
          output += toks.getText().replace("'", "");
        else if(!toks.getText().equals("\"") && ml_or_lx == 'm')
          output += toks.getText();
        else if(ml_or_lx == 'l')
          output += toks.getText();
      }
    }
    catch(Exception ex)
    {
      throw(ex);
    }
    
    return(output);
  }
}























