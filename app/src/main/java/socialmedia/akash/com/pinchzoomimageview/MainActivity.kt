package socialmedia.akash.com.pinchzoomimageview

import android.opengl.Matrix
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.ScaleGestureDetector.OnScaleGestureListener
import android.widget.ImageView
import kotlin.math.min

class MainActivity : AppCompatActivity() {
//lateinit var scaleGestureListener:ScaleGestureDetector
// lateinit var img:ImageView


    internal var scale: Float? = 1f
    internal lateinit var imageView: ImageView
    lateinit internal var scaleGestureDetector: ScaleGestureDetector
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.img_view)
        scaleGestureDetector = ScaleGestureDetector(this, scalelistener())


    }

    private inner class scalelistener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            scale = scale!! * detector.scaleFactor
            scale = Math.max(0.1f, Math.min(scale!!, 5f))
            imageView.setScaleX(scale!!)
            imageView.setScaleY(scale!!)
            return true


        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(event)
        return true
    }
//private class Scalelistener (): ScaleGestureDetector.SimpleOnScaleGestureListener() {
//
//
//    override fun onScale(detector: ScaleGestureDetector?): Boolean {
//      var sf = detector!!.scaleFactor
//        sf= Math.max(0.1f, Math.min(sf,0.5f))
//
//
//
//    }

}



