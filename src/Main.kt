import information.Launch
import information.lists.NextLaunches

fun main(args: Array<String>) {
    val list = NextLaunches(5)
    println(list.launchArray[3].name)
}

