package `Kotline exercises`

/*
Imagine that you need to create a music-player app.


Create a class that can represent the structure of a song. The Song class must include these code elements:

Properties for the title, artist, year published, and play count
A property that indicates whether the song is popular. If the play count is less than 1,000, consider it unpopular.
A method that prints a song description in this format:
"[Title], performed by [artist], was released in [year published]."

 */

open class Song(
    val title : String,
    val artist : String,
    val yearPublished : Int,
    val playCount: Int,
){
    var is_popular : String? = null
    init {
        if (playCount > 1_000)
            is_popular = "is popular"
        else
            is_popular = "is not popular"
    }

    fun printInfo(){
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}



fun main(){

    val song = Song("Someday", "The strokes", 2010, 1_000_000)

    println(song.is_popular)
    song.printInfo()

}
