package fr.purplegiraffe.slideshow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SlideshowActivity : AppCompatActivity() {
    val photoList = arrayOf(R.drawable.sushi, R.drawable.chat1, R.drawable.chien1, R.drawable.chat2, R.drawable.chien2, R.drawable.chat3)
    var currentPhotoIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slideshow)
    }
}
