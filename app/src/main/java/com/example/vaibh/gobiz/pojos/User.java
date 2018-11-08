package com.example.vaibh.gobiz.pojos;

import com.example.vaibh.gobiz.utils.DatabaseConnection;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class User {
 private String objectId;
 private String name;
 private String email;


 public User(DatabaseConnection dao){
     FirebaseUser user = dao.mAuth.getCurrentUser();
     name = user.getDisplayName();
     email = user.getEmail();
     objectId = user.getUid();
 }

 public String getObjectId(){
     return this.objectId;
 }

 public String getName(){
     return name;
 }

 public String getEmail(){
     return this.email;
 }
}
