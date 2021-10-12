package com.example.retrofitcoroutinesexample1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.example.retrofitcoroutinesexample1.databinding.ActivityMainBinding
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var retrofitServiceInstance: RetrofitServiceInterface
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        retrofitServiceInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitServiceInterface::class.java)
        //getAlbumsWithPathParameter()
        //getAllAlbumsList()
        getAlbums()
    }

    private fun getAlbumsWithPathParameter() {
        val albumsResponse: LiveData<Response<Albums>> = liveData {
           val response = retrofitServiceInstance.getAlbumsForId(3)
           emit(response)
        }
        albumsResponse.observe(this, Observer {
            val responseAlbumItemList = it.body()?.listIterator()
            if(responseAlbumItemList != null) {
                while(responseAlbumItemList.hasNext()) {
                    val albumListItem = responseAlbumItemList.next()
                    albumListItem.let {
                        val albumList = "Album id is ${albumListItem.id} \n" +
                                "Album name is ${albumListItem.title} \n" +
                                "Album user id is ${albumListItem.userId} \n\n\n"
                        activityMainBinding.text.append(albumList)
                        activityMainBinding.progressIndicator.visibility = View.GONE
                    }
            }
            }
        })
    }

    private fun getAllAlbumsList() {
        val albumResponse: LiveData<Response<Albums>> = liveData {
            val response = retrofitServiceInstance.getAllAlbums()
            emit(response)
        }
        albumResponse.observe(this, Observer {
            val listOfAlbums = it.body()?.listIterator()
            if(listOfAlbums != null) {
                while (listOfAlbums.hasNext()) {
                    val albumListItem = listOfAlbums.next()
                    val itemResponse = "Album id is ${albumListItem.id} \n" +
                            "Album name is ${albumListItem.title} \n" +
                            "Album user id is ${albumListItem.userId} \n\n\n"
                    activityMainBinding.text.append(itemResponse)
                    activityMainBinding.progressIndicator.visibility = View.GONE
                }
            }
        })
    }

    fun getAlbums() {
        val albumResponse: LiveData<Response<AlbumsItem>> = liveData {
            val response = retrofitServiceInstance.getAlbums(3)
            emit(response)
        }
        albumResponse.observe(this, Observer {
            val album = it.body()
            album?.let {
                     val albumString = "Album id is ${album.id} \n" +
                             "Album name is ${album.title} \n" +
                             "Album user id is ${album.userId} \n\n\n"
                     activityMainBinding.text.append(albumString)
                     activityMainBinding.progressIndicator.visibility = View.GONE
            }
        })
    }
}