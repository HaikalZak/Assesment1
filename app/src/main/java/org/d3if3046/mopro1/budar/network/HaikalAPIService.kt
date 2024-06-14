package org.d3if3046.mopro1.budar.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if3046.mopro1.budar.model.Haikal
import org.d3if3046.mopro1.budar.model.OpStatus
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Query

private const val BASE_URL = "https://unspoken.my.id/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HaikalApiService {
    @GET("json.php  ")
    suspend fun getHaikal(
        @Query("auth") userId: String
    ): List<Haikal>

    @Multipart
    @POST("api_haikal.php")
    suspend fun postHaikal(
        @Part("auth") userId: String,
        @Part("judul") judul: RequestBody,
        @Part("deskripsi") deskripsi: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus

    @DELETE("api_haikal.php")
    suspend fun deleteHudan(
        @Query("auth") userId: String,
        @Query("id") id: String
    ): OpStatus
}

object HaikalApi {
    val service: HaikalApiService by lazy {
        retrofit.create(HaikalApiService::class.java)
    }
    fun getHaikalUrl(imageId: String): String {
        return "${BASE_URL}$imageId"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }