import information.Launch

fun main(args: Array<String>) {
    val launch = Launch(1518)
    println(launch.name)
    println(launch.timeNet)
    println(launch.countdown.string())
}