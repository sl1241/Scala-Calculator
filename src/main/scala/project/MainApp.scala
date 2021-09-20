package project
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafxml.core.{NoDependencyResolver, FXMLView, FXMLLoader}
import scalafx.Includes._
import javafx.{scene => jfxs}   
import scalafx.scene.image.Image

object MainApp extends JFXApp{ 
   def load(){
    val rootResource = getClass.getResourceAsStream("/project/view/Root.fxml")
    val loader = new FXMLLoader(null, NoDependencyResolver)
    loader.load(rootResource)
    val roots = loader.getRoot[jfxs.layout.AnchorPane]

    //Used to make a new window
    stage = new PrimaryStage(){
        title = "ScalaFxCalculator"
        scene = new Scene(){
            root = roots
            stylesheets += getClass.getResource("view/Theme.css").toString
        }
        icons += new Image(getClass.getResourceAsStream("/images/calculator.png"))
    }
   }

   load()
    
}