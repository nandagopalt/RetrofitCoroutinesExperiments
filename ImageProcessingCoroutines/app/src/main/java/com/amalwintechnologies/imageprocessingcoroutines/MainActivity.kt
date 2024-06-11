package com.amalwintechnologies.imageprocessingcoroutines

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.amalwintechnologies.imageprocessingcoroutines.databinding.ActivityMainBinding
import com.devtides.imageprocessingcoroutines.Filter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity"
    private val imageView: ImageView? = null
    private val textView: TextView? = null
    private val progressBar: ProgressBar? = null

    private lateinit var binding: ActivityMainBinding
    private val IMAGE_URL =
        "https://raw.githubusercontent.com/DevTides/JetpackDogsApp/master/app/src/main/res/drawable/dog.png"
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Started.")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coroutineScope.launch {
            Log.d(TAG, "Inside coroutineScope launch: " + Thread.currentThread().name)
            val originalDeferred: Deferred<Bitmap> = coroutineScope.async(Dispatchers.IO) {
                Log.d(TAG, "Inside Dispatchers IO: " + Thread.currentThread().name)
                getOriginalBitmap()
            }
            Log.d(TAG, "Outside coroutineScope launch: " + Thread.currentThread().name)
            val originalBitmap = originalDeferred.await()
            Log.d(
                TAG,
                "Awaiting for completion of coroutine without blocking the thread: " + Thread.currentThread().name
            )
            val filteredImage: Deferred<Bitmap> = coroutineScope.async(Dispatchers.Default) {
                applyFilter(originalBitmap)
            }
            val latestImage = filteredImage.await()
            loadImage(latestImage)
        }
    }

    private fun getOriginalBitmap() =
        URL(IMAGE_URL).openStream().use {
            BitmapFactory.decodeStream(it)
        }

    private fun applyFilter(originalBitmap: Bitmap) = Filter.apply(originalBitmap)

    private fun loadImage(bitmap: Bitmap) {
        Log.d(TAG, "Inside loadImage: " + Thread.currentThread().name)
        binding.apply {
            imageView.setImageBitmap(bitmap)
            progressBar.visibility = View.GONE
        }
    }
}


