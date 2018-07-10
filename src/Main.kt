import information.Launch

fun main(args: Array<String>) {
    val launch = Launch(1391)
    println(launch.name)
    println(launch.timeNet)
    println(launch.countdown.string())
}