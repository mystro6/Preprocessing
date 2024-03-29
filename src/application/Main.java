/*
 * Ercan Tunç Güçlü & Ömer Aydın
 * GUI application for preprocessing
 */

package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application 
{
	@Override public void start(Stage primaryStage) 
	{
		try 
		{
			Parent parent = FXMLLoader.load(getClass().getResource("MainStage.fxml"));
			Scene scene = new Scene(parent);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Zemberek GUI");
			primaryStage.setResizable(false);
			primaryStage.show();
		}
		catch(Exception ex)
		{
			ErrorStage.ShowError(ex);
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
