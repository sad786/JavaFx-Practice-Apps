package sample
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.scene.shape.Circle
import javafx.scene.paint.Color
import javafx.scene.layout.BorderPane
import javafx.beans.binding.Bindings
import javafx.scene.input.MouseEvent

class CircleApp :Application()
{
    override fun start(stage:Stage)
    {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA)
        val circle = Circle()
        circle.fill = Color.CYAN
        circle.stroke = Color.BLUE
        circle.strokeWidth = 3.0
        val root = BorderPane(circle)
        root.style = "-fx-background-color:pink;"
        val scene = Scene(root,300.0,200.0)
        stage.scene = scene
        scene.fill = Color.PINK
        stage.title ="Circle App"
        stage.show()
        circle.radiusProperty()
                .bind(Bindings.min(
                        scene.widthProperty()
                        ,scene.heightProperty())
                        .divide(2))
        circle.centerXProperty().bind(scene.widthProperty().divide(2))
        circle.centerYProperty().bind(scene.heightProperty().divide(2))


        circle.addEventHandler(MouseEvent.MOUSE_CLICKED,fun (_:MouseEvent)=println("I am Circle Event Handler"))
        scene.addEventHandler(MouseEvent.MOUSE_CLICKED,fun(_:MouseEvent)=println("I am Scene Event Handler"))
        stage.addEventHandler(MouseEvent.MOUSE_CLICKED,fun(_:MouseEvent)=println("I am Stage Event Handler"))

        circle.addEventFilter(MouseEvent.MOUSE_CLICKED,fun (_:MouseEvent)=println("I am Circle Event Filter"))
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED,fun(_:MouseEvent)=println("I am Scene Event Filter"))
        stage.addEventFilter(MouseEvent.MOUSE_CLICKED,fun(_:MouseEvent)=println("I am Stage Event Filter"))
    }
}

fun main()
{
    Application.launch(CircleApp::class.java)
}