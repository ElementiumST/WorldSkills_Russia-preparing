package com.example.worldskillsrussia.data;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.worldskillsrussia.MainActivity;
import com.example.worldskillsrussia.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DatabaseCollector {
    FirebaseAuth firebaseAuth;
    FirebaseStorage storage;
    FirebaseDatabase database;
    DatabaseReference dbr;
    public DatabaseCollector(){
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

    }

    public boolean createUser(UserData ud) {
        DatabaseReference users = database.getReference("users");
        DatabaseReference keys = database.getReference("us-keys");
        String key = users.push().getKey();

        users.child(key).setValue(ud);
        keys.child(ud.getEmail().replace('.',',')).setValue(key);
        return true;
    }
    public UserData getUser(String login, String pass){
        String key = null;
        Searcher<String> sUsKeys= new Searcher<>(String.class);
        key = sUsKeys.getValue(database.getReference("us-keys"), login.replace('.', ','));
        Searcher<UserData> sUser = new Searcher<>(UserData.class);
        UserData ud =  sUser.getValue(database.getReference("users"), key);

        Bitmap result = null;
        try {
            URL url = new URL("https://firebasestorage.googleapis.com/v0/b/worldskillsrussia-cd854.appspot.com/o/pain.jpg?alt=media&token=96714ac0-d258-42d1-be20-9522d8298a70");
            HttpURLConnection connection =(HttpURLConnection) url.openConnection();
            connection.setAllowUserInteraction(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream is = connection.getInputStream();
            result = BitmapFactory.decodeStream(is);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(ud != null && ud.getPass().equals(pass)) {
            Log.i("password", ud.getPass());
            return ud;
        }
        else
            return null;
    }

}

class Searcher<T> {
    Class<T> type;
    public Searcher(Class<T> type) {

        this.type= type;
    }
    public T getValue(DatabaseReference parent, String child){
        if(child != null){
            parent = parent.child(child);
        }
        final List<T> out = new ArrayList<>();
        parent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                out.add(dataSnapshot.getValue(type));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("Database Error", "NotFound");
            }
        });
        if(out.size() <1) return null;
        return out.get(0);
    }
}
