package project.view
import scalafx.scene.input.MouseEvent
import scalafx.Includes._
import scalafxml.core.macros.sfxml
import scalafx.event.ActionEvent
import scalafx.scene.control.{Label, Alert, TextField, MenuItem, ButtonType}
import scalafx.scene.control.Alert.AlertType
import scala.math 
import scalafx.stage.Modality
import scalafx.application.Platform

@sfxml
class MouseController(
    private val ans: TextField,
    private var num1: Double,
    private var num2: Double,
    private var operationControl: Int,
    private var answer:Double,
    private var count:Int,   
    private val closed: MenuItem,
    private val info: MenuItem){
    
    
    def clickZero(){
        ans.appendText("0")
    }
    
    def clickOne(){
        ans.appendText("1")
    }

    def clickTwo(){
        ans.appendText("2")
    }
    
    def clickThree(){
        ans.appendText("3")
    }

    def clickFour(){
        ans.appendText("4")
    }
    
    def clickFive(){
        ans.appendText("5")
    }
    
    def clickSix(){
        ans.appendText("6")
    }
    
    def clickSeven(){
        ans.appendText("7")
    }
    
    def clickEight(){
        ans.appendText("8")
    }
    
    def clickNine(){
        ans.appendText("9")
    }
    
    def clickPoint(){
        ans.appendText(".")
    }

    def equals(){
        compute()
    }

    def compute(){
        operationControl match{
            case 1 => {
                // Addition
                if (count >= 1){
                    num1 = ans.getText.toDouble
                    answer = num1 + num2 
                    ans.setText(answer.toString)
                }
                else{
                    num2 = ans.getText.toDouble
                    answer = num1 + num2 
                    ans.setText(answer.toString)
                }
                count += 1
                } 
            case 2 => {
                //Subtraction
                if (count >= 1){
                    num1 = ans.getText.toDouble
                    answer = num1 - num2 
                    ans.setText(answer.toString)                    
                }
                else{
                    num2 = ans.getText.toDouble
                    answer = num1 - num2 
                    ans.setText(answer.toString)                    
                }
                count += 1
            }
            case 3 => {
                //Multiplication
                if (count >= 1){                     
                    num1 = ans.getText.toDouble
                    answer = num1 * num2 
                    ans.setText(answer.toString)     
                }
                else{
                    num2 = ans.getText.toDouble
                    answer = num1 * num2 
                    ans.setText(answer.toString)
                }
                count += 1
            } 
            case 4 => { //fix
                //Division
                if (count >= 1){//
                    num1 = ans.getText.toDouble
                    answer = num1 / num2 
                    ans.setText(answer.toString)
                }
                else{
                    num2 = ans.getText.toDouble
                    answer = num1 / num2 
                    ans.setText(answer.toString)
                    num1 = ans.getText.toDouble
                }
                count += 1
            }
        }
    }

    def plus(){
        num1 = ans.getText.toDouble
        ans.setText("")
        operationControl = 1
        count = 0
    }

    def minus(){
        num1 = ans.getText.toDouble
        ans.setText("")
        operationControl = 2
        count = 0
    }

    def multiply(){
        num1 = ans.getText.toDouble
        ans.setText("")
        operationControl = 3
        count = 0
    }

    def division(){
        num1 = ans.getText.toDouble
        ans.setText("")
        operationControl = 4
    }

    def clear(){
        ans.setText("")
        count = 0
    }

    def square(){
        num1 = ans.getText.toDouble
        answer = num1 * num1 
        ans.setText(answer.toString)
        count = 0
    }

    def percent(){
        num1 = ans.getText.toDouble
        answer = num1 / 100
        ans.setText(answer.toString)
        count = 0
    }

    def squareRoot(){
        num1 = ans.getText.toDouble
        answer = math.sqrt(num1)
        ans.setText(answer.toString)
        count = 0
    }

    def delete(){
        //Referred from Stack Overflow 
        ans.setText(ans.getText(0, ans.getLength()-1));
        count = 0
    }

    def plusMinus(){
        num1 = ans.getText.toDouble
        answer = num1 * (-1)
        ans.setText(answer.toString)
        count = 0
    }

    def close(){
        val confirm = new Alert(AlertType.Confirmation){
            initModality(Modality.ApplicationModal)
            title = "Confirm Exit"
            headerText = "Exit Program"
            contentText = "Please confirm exit."
        }
        val result = confirm.showAndWait
        result match{
            case Some(ButtonType.OK) => Platform.exit()
            case _                   => println("cancel")
        }
    }

    def about(){
        val information = new Alert(AlertType.Information){
            initModality(Modality.ApplicationModal)
            title = "Instructions"
            headerText = "Instructions"
            contentText = "Click on the buttons in the program to start calculating values."
        }.showAndWait
    }

}