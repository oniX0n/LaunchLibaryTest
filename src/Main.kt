import information.Launch

fun main(args: Array<String>) {
    val launch = Launch(1494)
    println(launch.getName())
    println(launch.getTimeNet())
    println(launch.getTimeUntilString())
}