package sample
import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.scene.text.Font
import javafx.scene.control.Button
import javafx.stage.Stage
import javafx.application.Platform
import javafx.concurrent.Task
import java.time.LocalTime
class DigitalWatch :Application()
{
    @Override
    override fun start(stage:Stage)
    {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN)
        val timeButton = Button("")
        timeButton.font = Font.font(30.0)
        val root = BorderPane()
        root.center = timeButton

        class MyTask:Task<Unit>()
        {
            override fun call()
            {
                while(true) {
                    val time = LocalTime.now()
                    var hour = time.hour
                    val minute = time.minute
                    val second = time.second
                    if (hour > 12) hour -= 12
                    Platform.runLater {  timeButton.text = "$hour : $minute : $second"}
                    Thread.sleep(1000)
                }
            }
        }
        val task = Thread(MyTask())
        task.isDaemon = true
        task.start()
        val scene = Scene(root,500.0,500.0)
        stage.scene = scene
        stage.title = "Time App"
        stage.show()
    }

}

fun main()
{
    Application.launch(DigitalWatch::class.java)
}