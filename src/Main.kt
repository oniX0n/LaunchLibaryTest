import information.Launch

fun main(args: Array<String>) {
    val launch = Launch(1518)
    println(launch.getName())
    println(launch.getTimeNet())
    println(launch.getTimeWindowStart())
    println(launch.getTimeWindowEnd())
    println(launch.getTimeUntilString())
}