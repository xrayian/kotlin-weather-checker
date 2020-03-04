import com.google.gson.Gson
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException

fun main(){
    while (true) {
        print("Enter Location: ")
        val location: String = readLine().toString()
        if(location != "exit") sendGet(location) else break

    }
}

fun sendGet(city :String) {
    var jsonData :String? = null
    val apiKey = "ec2f120dbab4d09f4d7d32eb94ac092a"
    val url = URL("http://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey")
    try {
        with(url.openConnection() as HttpURLConnection) {
            when {
                responseCode == 404 -> {
                    println("\nLocation Not Found!\n")
                }
                responseCode != 200 -> {
                    println("\nURL : $url; Response Code : $responseCode\n")
                }
                else -> {
                    inputStream.bufferedReader().use { bufferedReader ->
                        bufferedReader.lines().forEach {
                            jsonData = it}
                    }
                }
            }
        }
    } catch (e: UnknownHostException) {println("\nYou're Currently Offline\n")}


    if (!jsonData.isNullOrEmpty()){
        val weatherReport = Gson().fromJson(jsonData, JsonParser::class.java)
        println("\nThe Weather in ${weatherReport.name} is ${weatherReport.main.temp_celcius}°C\nFeels like ${weatherReport.main.feels_like_celcius}°C\n")
    }
}

