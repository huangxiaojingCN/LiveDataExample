package com.honey.livedataexample;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.honey.livedataexample.model.FoodList;
import com.honey.livedataexample.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodRepository {

    private Application application;

    private MutableLiveData<FoodList> mutableLiveData = new MutableLiveData<>();

    public FoodRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<FoodList> getMutableLiveData(String keyword, int num, int start, String appkey) {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<Result> call = apiService.getFoodList(keyword, num, start, appkey);
        call.enqueue(new Callback<Result>() {

            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.code() == 200) {
                    Result result = response.body();
                    if (result != null) {
                        FoodList foodList = result.getFoodList();
                        mutableLiveData.setValue(foodList);
                    }
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e("kevin", "onFailure: " + t.getMessage());
            }
        });

        return mutableLiveData;
    }

    public MutableLiveData<FoodList> getMutableLiveData() {
        return mutableLiveData;
    }
}
