data class JsonParser (val coord : Coord, val weather : List<Weather>, val base : String, val main : Main, val visibility : Int, val wind : Wind, val clouds : Clouds, val dt : Int, val sys : Sys, val timezone : Int, val id : Int, val name : String, val cod : Int)

data class Main (

	val temp : Double,
	val feels_like : Double,
	val temp_min : Double,
	val temp_max : Double,
	val pressure : Int,
	val humidity : Int
){
	val temp_celcius: Double
		get() = "%2f".format(temp - 273.15).toDouble()
	val temp_min_celcius: Double
		get() = "%2f".format(temp_min - 273.15).toDouble()
	val temp_max_celcius: Double
		get() = "%2f".format(temp_max - 273.15).toDouble()
	val feels_like_celcius: Double
		get() = "%2f".format(feels_like - 273.15).toDouble()
	init {
		this.temp_celcius
	}
}

data class Sys (

	val type : Int,
	val id : Int,
	val country : String,
	val sunrise : Int,
	val sunset : Int
)

data class Weather (

	val id : Int,
	val main : String,
	val description : String,
	val icon : String
)
data class Coord (

	val lon : Double,
	val lat : Double
)
data class Clouds (

	val all : Int
)
data class Wind (

	val speed : Double,
	val deg : Int
)