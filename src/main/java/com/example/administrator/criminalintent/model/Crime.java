package com.example.administrator.criminalintent.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/3/8.
 */
public class Crime {
    private static final String JSON_ID = "id";
    private static final String JSON_TITLE = "title";
    private static final String JSON_SOLVED = "solved";
    private static final String JSON_DATE = "date";
    private static final String JSON_PHOTO="photo";

    private UUID mId;
    private String mTitle;
    private Date mDate;
    private Photo mPhoto;
    private boolean mSolved;

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Crime(JSONObject object) throws JSONException {
        mId = UUID.fromString(object.getString(JSON_ID));
        if (object.has(JSON_TITLE)) {
            mTitle = object.getString(JSON_TITLE);
        }
        mSolved = object.getBoolean(JSON_SOLVED);
        mDate = new Date(object.getLong(JSON_DATE));
        if (object.has(JSON_PHOTO)){
            mPhoto=new Photo(object.getJSONObject(JSON_PHOTO));
        }
    }


    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public Photo getPhoto() {
        return mPhoto;
    }

    public void setPhoto(Photo photo) {
        mPhoto = photo;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject object = new JSONObject();
        object.put(JSON_ID, mId.toString());
        object.put(JSON_TITLE, mTitle);
        object.put(JSON_SOLVED, mSolved);
        object.put(JSON_DATE, mDate.getTime());
        if (mPhoto!=null)
            object.put(JSON_PHOTO,mPhoto);
        return object;
    }
}
