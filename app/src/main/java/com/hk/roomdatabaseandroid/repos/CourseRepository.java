package com.hk.roomdatabaseandroid.repos;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.hk.roomdatabaseandroid.roomDB.NameDao;
import com.hk.roomdatabaseandroid.roomDB.NameDatabase;
import com.hk.roomdatabaseandroid.models.Name;

import java.util.List;

public class CourseRepository {

    // below line is the create a variable
    // for dao and list for all courses.
    private NameDao dao;
    private LiveData<List<Name>> allCourses;

    // creating a constructor for our variables
    // and passing the variables to it.
    public CourseRepository(Application application) {
        NameDatabase database = NameDatabase.getInstance(application);
        dao = database.NameDao();
        allCourses = dao.getAllCourses();
    }

    // creating a method to insert the data to our database.
    public void insert(Name model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }

    // creating a method to update data in database.
    public void update(Name model) {
        new UpdateCourseAsyncTask(dao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(Name model) {
        new DeleteCourseAsyncTask(dao).execute(model);
    }

    // below is the method to delete all the courses.
    public void deleteAllCourses() {
        new DeleteAllCoursesAsyncTask(dao).execute();
    }

    // below method is to read all the courses.
    public LiveData<List<Name>> getAllCourses() {
        return allCourses;
    }

    // we are creating a async task method to insert new course.
    private static class InsertCourseAsyncTask extends AsyncTask<Name, Void, Void> {
        private NameDao dao;

        private InsertCourseAsyncTask(NameDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Name... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    // we are creating a async task method to update our course.
    private static class UpdateCourseAsyncTask extends AsyncTask<Name, Void, Void> {
        private NameDao dao;

        private UpdateCourseAsyncTask(NameDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Name... models) {
            // below line is use to update
            // our modal in dao.
            dao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete course.
    private static class DeleteCourseAsyncTask extends AsyncTask<Name, Void, Void> {
        private NameDao dao;

        private DeleteCourseAsyncTask(NameDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Name... models) {
            // below line is use to delete
            // our course modal in dao.
            dao.delete(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete all courses.
    private static class DeleteAllCoursesAsyncTask extends AsyncTask<Void, Void, Void> {
        private NameDao dao;
        private DeleteAllCoursesAsyncTask(NameDao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            // on below line calling method
            // to delete all courses.
            dao.deleteAllCourses();
            return null;
        }
    }
}
