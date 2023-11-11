import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.Exception
import java.util.Stack
import kotlin.system.exitProcess

suspend fun main() = runBlocking<Unit>{

    val cloacks = arrayOf(Cloack(),Cloack(),Cloack())
    for (i in 0 ..2){
        print("Введите время для будильника ${i+1}: ")
        try{
            cloacks[i].time = readln().toInt()
        }
        catch (e:Exception){
            print("ошибка")
            exitProcess(1)
        }
        cloacks[i].sound = (i+1).toString()
    }
    launch { cloacks[0].Start() }
    launch { cloacks[1].Start() }
    launch { cloacks[2].Start() }
    launch {
        for (i in 0..10){
            delay(1001L)
            println()
        }
    }

}
suspend fun doWork(){
    for (i in 0..5) {
        delay(400L)
        print("$i\t")
    }
}
class  Cloack (var time:Int=0, var sound:String = "click"){
    suspend fun Start() /*= coroutineScope*/{
       // launch {
            for (i in 0 until time) {
                delay(1000L)
                print("${sound}\t")
            }
            print ("=TRRRR\t")
       // }

    }
}