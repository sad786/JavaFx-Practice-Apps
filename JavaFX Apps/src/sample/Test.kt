package sample
import java.util.Optional
import kotlin.reflect.KClass
fun main(args:Array<String>)
{
   val myFun = fun(opt:Optional<String>) = opt.get()

    val k  = Class.forName("java.lang.String")

    println(k)
}

class MyClass(name:String) {
    private var name = name
    fun setName(value:String){name = value}
}

