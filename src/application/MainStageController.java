/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * Main stage (window) controller.
 */

package application;

/*---------- Our Classes ---------*/
import business.Preprocess;
import business.FileProcess;
import business.DatabaseProcess;
/*--------------------------------*/

import java.io.File;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainStageController
{
  @FXML private TextArea txttweet, txtoutput;
  @FXML private TextField txtread, txtwrite, txtusername, txtreaddb, txtwritedb;
  @FXML private PasswordField txtpassword;
  @FXML private CheckBox cbet01, cbet02, cbet03, cbet04, cbet05, cbet06, cbet07, cbet08, cbet09, cbet10, cbet11, cbet12, cbet13, cbet14, cbet15, cbet16, cbet17, cbet18, cbet19;
  @FXML private CheckBox cbrf01, cbrf02, cbrf03, cbrf04, cbrf05, cbrf06, cbrf07, cbrf08, cbrf09, cbrf10, cbrf11, cbrf12, cbrf13, cbrf14, cbrf15, cbrf16, cbrf17, cbrf18, cbrf19;
  @FXML private CheckBox cbrd01, cbrd02, cbrd03, cbrd04, cbrd05, cbrd06, cbrd07, cbrd08, cbrd09, cbrd10, cbrd11, cbrd12, cbrd13, cbrd14, cbrd15, cbrd16, cbrd17, cbrd18, cbrd19;
  @FXML private CheckBox cbetid, cbrfid, cbrdid;
  @FXML private CheckBox cbeten, cbrfen, cbrden;
  @FXML private RadioButton rbetml, rbetlx, rbrfml, rbrflx, rbrdml, rbrdlx;
  private Preprocess preprocess;
  
  public MainStageController()
  {
    try
    {
      this.preprocess = new Preprocess();
    }
    catch (Exception ex) 
    {
      ErrorStage.ShowError(ex);
    }
  }
  
//  @FXML public void CBEvents(ActionEvent ae)
//  {
//    if(((CheckBox)ae.getSource()).isSelected())
//      this.txtoutput.setText("YES!");
//    else
//      this.txtoutput.setText("NO!");
//  }
  
  @FXML public void BtnETStart(ActionEvent ae)
  {
    try
    {
      if(!rbetml.isSelected() && !rbetlx.isSelected())
      {
        ErrorStage.ShowInfo("Please select 'Machine Learning' or 'Lexicon'");
        
        return;
      }
      
      String tweet = txttweet.getText(), output = "";
      int[] tokens = new int[19];
      Arrays.fill(tokens, 0);
      int t = 0;
      String id = "";
      
      if(cbet01.isSelected())
      {
        id = cbet01.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet02.isSelected())
      {
        id = cbet02.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet03.isSelected())
      {
        id = cbet03.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet04.isSelected())
      {
        id = cbet04.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet05.isSelected())
      {
        id = cbet05.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet06.isSelected())
      {
        id = cbet06.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet07.isSelected())
      {
        id = cbet07.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet08.isSelected())
      {
        id = cbet08.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet09.isSelected())
      {
        id = cbet09.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet10.isSelected())
      {
        id = cbet10.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet11.isSelected())
      {
        id = cbet11.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet12.isSelected())
      {
        id = cbet12.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet13.isSelected())
      {
        id = cbet13.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet14.isSelected())
      {
        id = cbet14.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet15.isSelected())
      {
        id = cbet15.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet16.isSelected())
      {
        id = cbet16.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet17.isSelected())
      {
        id = cbet17.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet18.isSelected())
      {
        id = cbet18.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(cbet19.isSelected())
      {
        id = cbet19.getId();
        tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
        t++;
      }
      
      if(!this.cbetid.isSelected())
        output = this.preprocess.OutputWithoutLangID(tweet, tokens, this.cbeten.isSelected(), rbetml.isSelected() ? 'm' : 'l');
      else
        output = this.preprocess.OutputWithLangID(tweet, tokens, this.cbeten.isSelected(), rbetml.isSelected() ? 'm' : 'l');
      
      this.txtoutput.setText(output);
    }
    catch(Exception ex)
    {
      ErrorStage.ShowError(ex);
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
      if(!rbrfml.isSelected() && !rbrflx.isSelected())
      {
        ErrorStage.ShowInfo("Please select 'Machine Learning' or 'Lexicon'");
        
        return;
      }
      
      String readpath = this.txtread.getText().replace("\\", "\\\\");
      String writepath = this.txtwrite.getText().replace("\\", "\\\\");
      
      if(!readpath.equals("") && !writepath.equals(""))
      {
        int[] tokens = new int[19];
        Arrays.fill(tokens, 0);
        int t = 0;
        String id = "";
        
        if(cbrf01.isSelected())
        {
          id = cbrf01.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf02.isSelected())
        {
          id = cbrf02.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf03.isSelected())
        {
          id = cbrf03.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf04.isSelected())
        {
          id = cbrf04.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf05.isSelected())
        {
          id = cbrf05.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf06.isSelected())
        {
          id = cbrf06.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf07.isSelected())
        {
          id = cbrf07.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf08.isSelected())
        {
          id = cbrf08.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf09.isSelected())
        {
          id = cbrf09.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf10.isSelected())
        {
          id = cbrf10.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf11.isSelected())
        {
          id = cbrf11.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf12.isSelected())
        {
          id = cbrf12.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf13.isSelected())
        {
          id = cbrf13.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf14.isSelected())
        {
          id = cbrf14.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf15.isSelected())
        {
          id = cbrf15.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf16.isSelected())
        {
          id = cbrf16.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf17.isSelected())
        {
          id = cbrf17.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf18.isSelected())
        {
          id = cbrf18.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrf19.isSelected())
        {
          id = cbrf19.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        FileProcess fileprocess = new FileProcess(readpath, writepath, tokens, this.preprocess, this.cbrfid.isSelected(), this.cbrfen.isSelected(), rbrfml.isSelected() ? 'm' : 'l');
        fileprocess.StartProcess();
        
        ErrorStage.ShowInfo("File preprocessing successful!");
      }
    }
    catch(Exception ex)
    {
      ErrorStage.ShowError(ex);
    }
  }
  
  @FXML public void BtnRDStart(ActionEvent ae)
  {
    try
    {
      if(!rbrdml.isSelected() && !rbrdlx.isSelected())
      {
        ErrorStage.ShowInfo("Please select 'Machine Learning' or 'Lexicon'");
        
        return;
      }
      
      String username = this.txtusername.getText(), password = this.txtpassword.getText();
      String readdb = this.txtreaddb.getText(), writedb = this.txtwritedb.getText();
      
      if(!username.equals("") && !readdb.equals("") && !writedb.equals(""))
      {
        int[] tokens = new int[19];
        Arrays.fill(tokens, 0);
        int t = 0;
        String id = "";
        
        if(cbrd01.isSelected())
        {
          id = cbrd01.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd02.isSelected())
        {
          id = cbrd02.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd03.isSelected())
        {
          id = cbrd03.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd04.isSelected())
        {
          id = cbrd04.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd05.isSelected())
        {
          id = cbrd05.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd06.isSelected())
        {
          id = cbrd06.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd07.isSelected())
        {
          id = cbrd07.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd08.isSelected())
        {
          id = cbrd08.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd09.isSelected())
        {
          id = cbrd09.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd10.isSelected())
        {
          id = cbrd10.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd11.isSelected())
        {
          id = cbrd11.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd12.isSelected())
        {
          id = cbrd12.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd13.isSelected())
        {
          id = cbrd13.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd14.isSelected())
        {
          id = cbrd14.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd15.isSelected())
        {
          id = cbrd15.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd16.isSelected())
        {
          id = cbrd16.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd17.isSelected())
        {
          id = cbrd17.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd18.isSelected())
        {
          id = cbrd18.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        if(cbrd19.isSelected())
        {
          id = cbrd19.getId();
          tokens[t] = Integer.parseInt(id.substring(id.length() - 2, id.length()));
          t++;
        }
        
        DatabaseProcess dbprocess = new DatabaseProcess(username, password, readdb, writedb, this.preprocess, tokens, this.cbrdid.isSelected(), this.cbrden.isSelected(), rbrdml.isSelected() ? 'm' : 'l');
        dbprocess.StartProcess();
        
        ErrorStage.ShowInfo("Database preprocessing successful!");
      }
    }
    catch(Exception ex)
    {
      ErrorStage.ShowError(ex);
    }
  }
}

























