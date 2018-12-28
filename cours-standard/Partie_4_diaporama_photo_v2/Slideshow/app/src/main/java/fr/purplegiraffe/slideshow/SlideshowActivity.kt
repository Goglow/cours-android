package fr.purplegiraffe.slideshow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import kotlinx.android.synthetic.main.activity_slideshow.*

class SlideshowActivity : AppCompatActivity() {
    val photoList = arrayOf(R.drawable.sushi, R.drawable.chat1, R.drawable.chien1, R.drawable.chat2, R.drawable.chien2, R.drawable.chat3)
    var currentPhotoIndex = 0
    var countDownTimer:CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slideshow)
    }

    override fun onResume() {
        super.onResume()
        startSlideshow()
    }

    fun previousButtonTouched(button:View) {
        currentPhotoIndex = currentPhotoIndex - 1
        if (currentPhotoIndex < 0) {
            currentPhotoIndex = photoList.size - 1
        }
        imageView.setImageResource(photoList[currentPhotoIndex])
    }

    fun nextButtonTouched(button: View) {
        showNextPhoto()
    }

    fun startSlideshow() {
        countDownTimer = object : CountDownTimer(3000,3000) {
            override fun onFinish() {
                showNextPhoto()
                startSlideshow()
            }

            override fun onTick(millisUntilFinished: Long) { }
        }
        countDownTimer?.start()
    }

    fun showNextPhoto() {
        currentPhotoIndex = currentPhotoIndex + 1
        if (currentPhotoIndex >= photoList.size) {
            currentPhotoIndex = 0
        }
        imageView.setImageResource(photoList[currentPhotoIndex])
    }
}
