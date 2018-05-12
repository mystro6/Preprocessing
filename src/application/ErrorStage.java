/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * Shows error messages.
 */

package application;

import java.io.PrintWriter;
import java.io.StringWriter;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ErrorStage
{
  public static void ShowError(Exception ex)
  {
    Alert msg_box = new Alert(AlertType.ERROR);
    msg_box.setTitle("Zemberek GUI - Error");
    msg_box.setHeaderText("Sorry, error(s) occured!");
    
    StringWriter stringwriter = new StringWriter();
    PrintWriter printwriter = new PrintWriter(stringwriter);
    ex.printStackTrace(printwriter);
    String exception = stringwriter.toString();
    
    Label lbl = new Label("The error(s):");
    
    TextArea txt = new TextArea(exception);
    txt.setEditable(false);
    txt.setWrapText(true);
    txt.setMaxWidth(Double.MAX_VALUE);
    txt.setMaxHeight(Double.MAX_VALUE);
    
    GridPane.setVgrow(txt, Priority.ALWAYS);
    GridPane.setHgrow(txt, Priority.ALWAYS);
    GridPane gp = new GridPane();
    gp.setMaxWidth(Double.MAX_VALUE);
    gp.add(lbl, 0, 0);
    gp.add(txt, 0, 1);
    
    msg_box.getDialogPane().setExpandableContent(gp);
    msg_box.showAndWait();
  }
  
  public static void ShowInfo(String msg)
  {
    Alert msg_box = new Alert(AlertType.INFORMATION);
    msg_box.setTitle("Zemberek GUI - Information");
    msg_box.setHeaderText(msg);
    msg_box.showAndWait();
  }
}



















