package sample

import com.jfoenix.controls.JFXButton
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.stage.Stage

class MyApp : Application()
{
    override fun init()
    {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN)
    }
    override fun start(stage: Stage)
    {
        val btn = JFXButton("I am JFoenix Button")
        //  btn.buttonType = ButtonType.RAISED
        // btn.ripplerFill = Color.CYAN


        btn.pressedProperty().addListener(fun (_){
            // btn.style = "-fx-background-color:blue; -fx-text-fill:white"
            println("Button is Pressed")
        })
        val root = BorderPane()
        root.center = btn

        val scene = Scene(root,400.0,400.0)
        stage.scene = scene
        stage.title ="JFoenix App"
        stage.show()
    }

}

fun main()
{
    Application.launch(MyApp::class.java)
}