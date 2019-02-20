package sample
import javafx.application.Application
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.Group
import javafx.scene.paint.Color
import javafx.stage.StageStyle
import javafx.stage.Screen
import javafx.scene.Cursor
import javafx.scene.layout.VBox
import javafx.stage.Modality
import javafx.scene.control.Button
import java.net.URL
import javafx.application.ConditionalFeature
import javafx.application.Platform

class App :Application() {
    override fun start(stage: Stage) {
        val b1 = Button("Stage s1")
        val children = b1.childrenUnmodifiable
        children.forEach {println(it)}
        val b2 = Button("Stage s2")
        val b3 = Button("Stage s3")
        val b4 = Button("Stage s4")

        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN)

        val root = VBox(10.0,b1,b2,b3,b4)
        root.childrenUnmodifiable.forEach({})
        val scene = Scene(root,200.0,200.0)
        stage.scene = scene
        stage.maxHeight = 300.0
        stage.maxWidth  = 200.0
       // stage.isResizable = false
        val url = URL("file:///C://Users/Dell/Desktop/boy.png")

        val cursor  = Cursor.cursor(url.toExternalForm())
        scene.cursor = cursor
        stage.show()
        /*
        println("Scene 3D supported ${Platform.isSupported(ConditionalFeature.SCENE3D)}")
        println("Media supported ${Platform.isSupported(ConditionalFeature.MEDIA)}")
        println("Controls supported ${Platform.isSupported(ConditionalFeature.CONTROLS)}")
        println("Effect supported ${Platform.isSupported(ConditionalFeature.EFFECT)}")
        println("FXML supported ${Platform.isSupported(ConditionalFeature.FXML)}")
        println("Graphics supported ${Platform.isSupported(ConditionalFeature.GRAPHICS)}")
        println("Input Multitouch supported ${Platform.isSupported(ConditionalFeature.INPUT_MULTITOUCH)}")
        println("Transparent Window supported ${Platform.isSupported(ConditionalFeature.TRANSPARENT_WINDOW)}")
        println("Virtual Keyboard supported ${Platform.isSupported(ConditionalFeature.VIRTUAL_KEYBOARD)}")
        //println("I am Executing Now")
        */
    }
}

fun main() {
    Application.launch(App::class.java)
}