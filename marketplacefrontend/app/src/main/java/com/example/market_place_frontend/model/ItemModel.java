package com.example.market_place_frontend.model;

import android.os.Parcel;
import android.os.Parcelable;


public class ItemModel implements Parcelable {
    private String itemPrice;
    private String itemDescription;
    private int imageResource;
    private float rating;

    public ItemModel(String itemPrice, String itemDescription, int imageResource, float rating) {
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.imageResource = imageResource;
        this.rating = rating;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    // Parcelable implementation
    protected ItemModel(Parcel in) {
        imageResource = in.readInt();
        itemPrice = in.readString();
        itemDescription = in.readString();
        rating = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageResource);
        dest.writeString(itemPrice);
        dest.writeString(itemDescription);
        dest.writeFloat(rating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemModel> CREATOR = new Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel in) {
            return new ItemModel(in);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };

    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
}
