package com.dtechterminal.relawable;

import android.graphics.drawable.Drawable;
import android.widget.RatingBar;

public class PersonUtils {
    private String personName;
    private String jobProfile;
    private Drawable profileImage;
    private float ratingBar;


    public PersonUtils(String personName, String jobProfile,Drawable profileImage,float ratingBar) {
        this.personName = personName;
        this.jobProfile = jobProfile;
        this.profileImage = profileImage;
        this.ratingBar = ratingBar;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(String jobProfile) {
        this.jobProfile = jobProfile;
    }

    public Drawable getProfileImage() { return profileImage; }

    public void setProfileImage(Drawable profileImage) { this.profileImage = profileImage; }

    public float getRating() { return ratingBar; }

    public void setRating(float ratingBar) { this.ratingBar = ratingBar; }
}
