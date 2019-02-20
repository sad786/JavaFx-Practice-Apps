package sample
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.stage.Modality
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.control.Button
import javafx.scene.shape.Line
import javafx.scene.paint.Color
import javafx.scene.layout.BorderPane
import javafx.scene.control.Label
import javafx.scene.text.TextAlignment
import javafx.scene.layout.StackPane
import javafx.beans.property.DoubleProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.geometry.Pos
import javafx.scene.layout.Priority
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.stage.StageStyle
import javafx.geometry.Insets

class MyLogo:Application()
{
    private var endX:DoubleProperty = SimpleDoubleProperty(0.0)
    override fun start(stage:Stage)
    {
        val title = Label("Application of MyLogo")
        title.textFill = Color.GRAY
        title.font = Font.font(15.0)
        title.textAlignment = TextAlignment.CENTER
        title.alignment = Pos.CENTER

        val cancel = Button("Cancel        ")
        val background = Button("Background")
        cancel.prefHeightProperty().bind(cancel.prefWidthProperty())


        val hbox = VBox(5.0,cancel,background)
        hbox.padding = Insets(5.0)

        val vbox = HBox(title)
        vbox.style ="-fx-background-color:lightgray;"
        vbox.alignment = Pos.CENTER
        HBox.setHgrow(hbox,Priority.ALWAYS)


        val line1 = Line(0.0,0.0,500.0,0.0)
        line1.strokeWidth = 4.0
        line1.stroke = Color.DARKGREY


        val line2 = Line(0.0,0.0,0.0,0.0)
        line2.strokeWidth =4.0
        line2.stroke = Color.web("#1585FF")
        line2.endXProperty().bind(endX)


        val stackPane = StackPane()
        stackPane.children.addAll(line1,line2)
        stackPane.alignment = Pos.CENTER_LEFT

        val label = Label("Downloading Path File ")

        val box = VBox(5.0,label,stackPane)
        box.padding = Insets(5.0)
        val root = BorderPane()
        root.top = vbox
        root.right = hbox
        root.center = box

        val newStage = Stage()
        val scene = Scene(root,600.0,100.0)

        newStage.scene = scene
        newStage.initStyle(StageStyle.TRANSPARENT)
        newStage.show()

        cancel.setOnAction{newStage.close()}
        background.setOnAction{newStage.close()}

       val runnable = fun () {
           var i = 0.0
           while (i <= 500.0) {
               i += 1
               endX.set(i)
               Thread.sleep(100)
           }
       }
        val thread = Thread(runnable)
        thread.isDaemon = true
        thread.start()
    }
}

fun main(args:Array<String>)
{
    Application.launch(MyLogo::class.java)
}