package sample
import javafx.application.Application
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.stage.Stage
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.control.Button
import javafx.scene.control.TableView
import javafx.scene.text.Font
import javafx.scene.layout.Pane
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.control.Label
import javafx.scene.control.TableColumn
import javafx.scene.paint.Color
import java.awt.BorderLayout
import java.io.*
fun main()
{
    Application.launch(VirtualStage::class.java)
}


class VirtualStage:Application()
{
    override fun start(stage:Stage)
    {
        var logoImage:Image? = null
        var createImage:Image? = null
        var refreshImage:Image? = null
        var questionImage:Image? = null
        try {
            logoImage = Image("file:///C://Users/Dell/Desktop/logo.png",60.0,60.0,true,true,true)
            createImage = Image("file:///C://Users/Dell/Desktop/plus.png",
                                15.0,15.0,
                            true,true,true)
            refreshImage = Image("file:///C://Users/Dell/Desktop/Refresh_icon.png",
                    20.0,15.0,
                    true,true,true)
            questionImage = Image("file:///C://Users/Dell/Desktop/question.png",
                    20.0,15.0,
                    true,true,true)

        }catch(ex:IOException){println(ex.message)}

        val imageView = ImageView(logoImage)
        imageView.layoutX = 10.0
        imageView.layoutY = 20.0

        val titleLabel1 = Label("Your Virtual Device")
        titleLabel1.font = Font.font(20.0)
        titleLabel1.textFill = Color.WHITE
        titleLabel1.layoutX = 65.0
        titleLabel1.layoutY = 25.0

        val titleLabel2 = Label("Android Studio")
        titleLabel2.textFill = Color.WHITE
        titleLabel2.layoutX = 65.0
        titleLabel2.layoutY = 50.0

        val pane = Pane(imageView,titleLabel1,titleLabel2)
        pane.minHeight = 100.0
        pane.prefWidth(Double.MAX_VALUE)
        pane.style = "-fx-background-color:#5C5858"

        val tableView = TableView<String>()
        tableView.columns.addAll(TableColumn<String,String>("Type"),
                                    TableColumn<String,String>("Name"),
                                    TableColumn<String,String>("Play Store"),
                                    TableColumn<String,String>("Resolution"),
                                    TableColumn<String,String>("API"),
                                    TableColumn<String,String>("Target"),
                                    TableColumn<String,String>("CPU/ABI"),
                                    TableColumn<String,String>("Size on disk"),
                                    TableColumn<String,String>("Actions"))


        tableView.maxHeight = Double.MAX_VALUE
        tableView.maxWidth = Double.MAX_VALUE

        val createButton = Button("Create New Virtual Device")
        createButton.graphic = ImageView(createImage)
        val reviewButton = Button("")
        reviewButton.graphic = ImageView(refreshImage)
        val question = Button("")
        question.graphic = ImageView(questionImage)

        val hbox = HBox(reviewButton,question)
        hbox.spacing = 10.0

        val bottomPane = BorderPane()
        bottomPane.padding = Insets(0.0,10.0,10.0,10.0)
        bottomPane.left = createButton
        bottomPane.right = hbox

        val root = BorderPane()
        BorderPane.setMargin(tableView,Insets(10.0,10.0,10.0,10.0))
        root.top = pane
        root.center = tableView
        root.bottom = bottomPane

        val scene = Scene(root,1200.0,400.0)
        stage.scene = scene
        stage.title = "Choose Your Device"
        stage.show()

    }
}

