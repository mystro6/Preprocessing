package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import org.antlr.v4.runtime.Token;
import com.detectlanguage.DetectLanguage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import zemberek.langid.LanguageIdentifier;
import zemberek.morphology.analysis.tr.TurkishMorphology;
import zemberek.normalization.TurkishSpellChecker;
import zemberek.tokenization.TurkishTokenizer;
import zemberek.tokenization.antlr.TurkishLexer;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainStageController
{
  @FXML private TextArea txttweet, txtoutput;
  @FXML private TextField txtread, txtwrite;
  @FXML private CheckBox cbet01, cbet02, cbet03, cbet04, cbet05, cbet06, cbet07, cbet08, cbet09, cbet10, cbet11, cbet12, cbet13, cbet14, cbet15, cbet16, cbet17, cbet18, cbet19;
  @FXML private CheckBox cbrf01, cbrf02, cbrf03, cbrf04, cbrf05, cbrf06, cbrf07, cbrf08, cbrf09, cbrf10, cbrf11, cbrf12, cbrf13, cbrf14, cbrf15, cbrf16, cbrf17, cbrf18, cbrf19;
  private String tweet = "", output = "", readpath = "", writepath = "";
  private TurkishTokenizer tokenizer;
  private TurkishMorphology morphology;
  private TurkishSpellChecker spellchecker;
  private LanguageIdentifier languageidentifier;
  private int[] tokens = new int[19];
  
  public MainStageController()
  {
    try
    {
      DetectLanguage.apiKey = "9bfd594c4e183f585df9a7af194c7ed3";
      this.morphology = TurkishMorphology.createWithDefaults();
      this.spellchecker = new TurkishSpellChecker(this.morphology);
      this.languageidentifier = LanguageIdentifier.fromInternalModels();
    }
    catch (Exception ex) 
    {
      System.err.println(ex);
    }
  }
  
  private void Output()
  {
    try
    {
      this.tokenizer = TurkishTokenizer.builder().ignoreTypes(this.tokens).build();
      List<Token> alltokens = this.tokenizer.tokenize(this.tweet);
      
      for(Token toks: alltokens)
      {
        if(toks.getType() == TurkishLexer.Word)
        {
          if(this.languageidentifier.identify(toks.getText()).equals("tr"))
          {
            if(!this.spellchecker.check(toks.getText()))
            {
              List<String> suggestions = this.spellchecker.suggestForWord(toks.getText());
              
              if(!suggestions.isEmpty())
                this.output += suggestions.get(0);
              else
                this.output += toks.getText();
            }
            else
              this.output += toks.getText();
          }
          else
          {
            if(DetectLanguage.detect(toks.getText()).get(0).language.equals("tr"))
            {
              if(!this.spellchecker.check(toks.getText()))
              {
                List<String> suggestions = this.spellchecker.suggestForWord(toks.getText());
                
                if(!suggestions.isEmpty())
                  this.output += suggestions.get(0);
                else
                  this.output += toks.getText();
              }
              else
                this.output += toks.getText();
            }
            else
              this.output += toks.getText();
          }
        }
        else
          this.output += toks.getText();
      }
    }
    catch(Exception ex)
    {
      System.err.println(ex);
    }
  }
  
  @FXML public void BtnETStart(ActionEvent ae) throws Exception
  {
    try
    {
      this.tweet = txttweet.getText();
      this.output = "";
      
      int t = 0;
      String id = "";
      
      if(cbet01.isSelected())
      {
        id = cbet01.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet02.isSelected())
      {
        id = cbet02.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet03.isSelected())
      {
        id = cbet03.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet04.isSelected())
      {
        id = cbet04.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet05.isSelected())
      {
        id = cbet05.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet06.isSelected())
      {
        id = cbet06.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet07.isSelected())
      {
        id = cbet07.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet08.isSelected())
      {
        id = cbet08.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet09.isSelected())
      {
        id = cbet09.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet10.isSelected())
      {
        id = cbet10.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet11.isSelected())
      {
        id = cbet11.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet12.isSelected())
      {
        id = cbet12.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet13.isSelected())
      {
        id = cbet13.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet14.isSelected())
      {
        id = cbet14.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet15.isSelected())
      {
        id = cbet15.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet16.isSelected())
      {
        id = cbet16.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet17.isSelected())
      {
        id = cbet17.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet18.isSelected())
      {
        id = cbet18.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet19.isSelected())
      {
        id = cbet19.getId();
        this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      this.Output();
      
      this.txtoutput.setText(this.output);
      
      Arrays.fill(this.tokens, 0);
    }
    catch(Exception ex)
    {
      System.err.println(ex);
    }
  }
  
  @FXML public void BtnOpen(ActionEvent ae)
  {
    FileChooser filechooser = new FileChooser();
    filechooser.getExtensionFilters().addAll(
      new ExtensionFilter("Text File", "*.txt"), new ExtensionFilter("JavaScript Object Notation", "*.json")
    );
    
    File file = filechooser.showOpenDialog(((Node)ae.getSource()).getScene().getWindow());
    
    if(file != null)
      this.txtread.setText(file.getAbsolutePath());
  }
  
  @FXML public void BtnSave(ActionEvent ae)
  {
    FileChooser filechooser = new FileChooser();
    filechooser.getExtensionFilters().addAll(
      new ExtensionFilter("Text File", "*.txt"), new ExtensionFilter("JavaScript Object Notation", "*.json")
    );
    
    File file = filechooser.showSaveDialog(((Node)ae.getSource()).getScene().getWindow());
    
    if(file != null)
      this.txtwrite.setText(file.getAbsolutePath());
  }
  
  @FXML public void BtnRFStart(ActionEvent ae)
  {
    try
    {
      this.tweet = "";
      this.readpath = this.txtread.getText().replace("\\", "\\\\");
      this.writepath = this.txtwrite.getText().replace("\\", "\\\\");
      
      if(!this.readpath.equals("") && !this.writepath.equals(""))
      {
        int t = 0;
        String id = "";
        
        if(cbrf01.isSelected())
        {
          id = cbrf01.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf02.isSelected())
        {
          id = cbrf02.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf03.isSelected())
        {
          id = cbrf03.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf04.isSelected())
        {
          id = cbrf04.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf05.isSelected())
        {
          id = cbrf05.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf06.isSelected())
        {
          id = cbrf06.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf07.isSelected())
        {
          id = cbrf07.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf08.isSelected())
        {
          id = cbrf08.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf09.isSelected())
        {
          id = cbrf09.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf10.isSelected())
        {
          id = cbrf10.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf11.isSelected())
        {
          id = cbrf11.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf12.isSelected())
        {
          id = cbrf12.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf13.isSelected())
        {
          id = cbrf13.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf14.isSelected())
        {
          id = cbrf14.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf15.isSelected())
        {
          id = cbrf15.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf16.isSelected())
        {
          id = cbrf16.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf17.isSelected())
        {
          id = cbrf17.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf18.isSelected())
        {
          id = cbrf18.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf19.isSelected())
        {
          id = cbrf19.getId();
          this.tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        BufferedReader bufferedreader = new BufferedReader(
          new InputStreamReader(
            new  FileInputStream(this.readpath), "UTF8"
          )
        );
        
        FileWriter filereader = new FileWriter(this.writepath);
        BufferedWriter bufferedwriter = new BufferedWriter(filereader);
        
        String reading = "";
          
        while((reading = bufferedreader.readLine()) != null)
        {
          if(!reading.equals("---"))
          {
            this.tweet += reading;
            this.tweet += "\n";
          }
          else
          {
            this.Output();
            
            reading  = "";
            this.tweet = "";
            
            bufferedwriter.write(this.output + "---\n");
            
            this.output = "";
          }
        }
        
        bufferedreader.close();
        bufferedwriter.close();
        
        Arrays.fill(this.tokens, 0);
      }
    }
    catch(FileNotFoundException ex)
    {
      System.err.println(ex);
    }
    catch(IOException ex)
    {
      System.err.println(ex);
    }
  }
}

























