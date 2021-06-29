package com.example.test_app;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TaskService {
    @GET("tasks")
    Call<List<Task>> getTasks();

    @POST("tasks")
    Call<Integer> createTask(@Body Task task);

    @GET("tasks/{id}")
    Call<Task> getTask(@Path("id") Integer taskId);
}
