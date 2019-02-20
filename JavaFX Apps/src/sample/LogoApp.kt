package sample
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.scene.layout.BorderPane
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.scene.control.Label
import javafx.stage.StageStyle
import javafx.scene.shape.Line
import javafx.beans.property.DoubleProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.geometry.Pos
import javafx.scene.Group
import javafx.scene.layout.AnchorPane

class LogoApp:Application()
{
    var counter:DoubleProperty = SimpleDoubleProperty(0.0)
    override fun start(stage:Stage)
    {
        val and = Label("android")
        and.font = Font.font(null,FontWeight.EXTRA_BOLD,40.0)
        and.textFill = Color.web("#008000")
        and.layoutX = 50.0
        and.layoutY = 100.0

        val studio = Label("studio")
        studio.font = Font.font(null,FontWeight.NORMAL,40.0)
        studio.textFill = Color.WHITESMOKE
        studio.layoutX = 200.0
        studio.layoutY = 100.0

        val intel = Label("Powered by IntelliJ Platform")
        intel.font = Font.font(null,FontWeight.LIGHT,9.0)
        intel.textFill = Color.WHITESMOKE
        intel.layoutX = 200.0
        intel.layoutY = 145.0

        val vbox = VBox(intel)
        vbox.layoutX = 80.0
        vbox.layoutY = 170.0
        vbox.alignment = Pos.BOTTOM_RIGHT

        val line = Line(0.0,0.0,0.0,0.0)
        line.endXProperty().bind(counter)
        line.strokeWidth = 2.0
        line.stroke = Color.WHITESMOKE
        line.layoutX = 0.0
        line.layoutY = 230.0

        val root = Group(and,studio,vbox,line)
        root.style= "-fx-background-color:#3D3C3A;"

        val pane = BorderPane()
        pane.style = "-fx-background-color:#3D3C3A;"
        pane.center = and
        pane.bottom = line

        val anchorPane = AnchorPane(and,studio,intel,line)
        anchorPane.style = "-fx-background-color:#3D3C3A;"
        val scene = Scene(anchorPane,350.0,250.0)
        stage.scene = scene
        scene.fill = Color.DIMGRAY
        stage.initStyle(StageStyle.TRANSPARENT)
        stage.isIconified = false
        stage.show()

        val run = fun(){
            var i = 0.0
            while(i<=350.0)
            {
                i+=1
                counter.set(i)
                Thread.sleep(100)
            }
        }

        val thread = Thread(run)
        thread.isDaemon = true
        thread.start()
    }
}

fun main()
{
    Application.launch(LogoApp::class.java)
}