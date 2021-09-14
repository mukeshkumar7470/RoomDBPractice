package com.hk.roomdatabaseandroid.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.hk.roomdatabaseandroid.models.Name;
import com.hk.roomdatabaseandroid.repos.CourseRepository;

import java.util.List;

public class CustomViewModel extends AndroidViewModel {

    // creating a new variable for course repository.
    private CourseRepository repository;

    // below line is to create a variable for live
    // data where all the courses are present.
    private LiveData<List<Name>> allCourses;

    // constructor for our view modal.
    public CustomViewModel(@NonNull Application application) {
        super(application);
        repository = new CourseRepository(application);
        allCourses = repository.getAllCourses();
    }

    // below method is use to insert the data to our repository.
    public void insert(Name model) {
        repository.insert(model);
    }

    // below line is to update data in our repository.
    public void update(Name model) {
        repository.update(model);
    }

    // below line is to delete the data in our repository.
    public void delete(Name model) {
        repository.delete(model);
    }

    // below method is to delete all the courses in our list.
    public void deleteAllCourses() {
        repository.deleteAllCourses();
    }

    // below method is to get all the courses in our list.
    public LiveData<List<Name>> getAllCourses() {
        return allCourses;
    }
}
