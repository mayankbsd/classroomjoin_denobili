package com.denobili.app.loginPage.loiginMicroService

import android.content.Context
import com.denobili.app.R
import com.denobili.app.helper.RxFunctions
import com.denobili.app.helper_utils.ApiInterface
import com.denobili.app.utils.SharedPreferencesData
import com.google.gson.Gson
import com.google.gson.JsonObject
import rx.Observer


class LoginMicroApiManager {

    private var context: Context? = null

    fun postdata(otPverifyModel: String, apiInterface: ApiInterface, listener: LoginMicroRequestListener, context11: Context?) {
        context = context11
        apiInterface.validateLoginEmail(otPverifyModel).compose(RxFunctions.applySchedulers()).subscribe(observer(listener))

    }

    fun observer(listener: LoginMicroRequestListener): Observer<JsonObject> {
        return object : Observer<JsonObject> {
            override fun onCompleted() {

            }

            override fun onNext(map: JsonObject) {

                if (map.has("errormessage")) {

                    println("Data11--->onNext--->" + map.get("errormessage").asString)
                    listener.onError("Dear User, \n" +
                            "This mobile number of yours is not registered with us. Either login with your registered mobile number or contact De Nobili school of your ward to find out your registered mobile number.")

                }

                if (map.has("errorcode")) {

                    println("Data11--->onNext--->" + map.get("errorcode"))
                }

                if (map.has("data")) {
                    println("Data11--->onNext--" + "data---" + map.get("data").toString())
                    val response = Gson().fromJson(map.get("data").toString(), LoginMicroDataReponser::class.java)
                    System.out.println(response.userTypeId);
                    try {
                        var sharedPreferencesData = SharedPreferencesData(context);
                        sharedPreferencesData.saveUserTypeId(response.userTypeId)
                        sharedPreferencesData.saveSocialId(response.googleToken)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                    println("Data11--->response.otp--->" + response.userTypeId)
                    listener.onRequestSuccesful()

                }

                if (map.has("status")) {

                    println("Data11--->onNext--->" + map.get("status"))

                }


            }

            override fun onError(e: Throwable?) {
                // println("Data11--->onNext" + "onError--->"+e.toString())

                listener.onRequestError(context!!.getString(R.string.serverError))
            }

        }
    }

    interface LoginMicroRequestListener {

        fun onRequestSuccesful()

        fun onRequestError(error: String)

        fun onError(error: String)


    }

}