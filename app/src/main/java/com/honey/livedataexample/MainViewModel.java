package com.honey.livedataexample;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.honey.livedataexample.model.FoodList;

public class MainViewModel extends AndroidViewModel {

    public static final String TAG = "";

    private FoodRepository foodRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        foodRepository = new FoodRepository(application);
    }

    public LiveData<FoodList> getFoodList(String keyword, int num, int start, String appkey) {
        return foodRepository.getMutableLiveData(keyword, num, start, appkey);
    }

    public LiveData<FoodList> getFoodList() {
        return foodRepository.getMutableLiveData();
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        Log.d(TAG, "onCleared: ");
    }
}
