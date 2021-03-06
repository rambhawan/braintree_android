package com.braintreepayments.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.braintreepayments.api.models.PostalAddressParser;

import org.json.JSONObject;

/**
 * Java object representing a postal address
 */
public class PostalAddress implements Parcelable {

    private String mRecipientName;
    private String mPhoneNumber;
    private String mStreetAddress;
    private String mExtendedAddress;
    private String mLocality;
    private String mRegion;
    private String mPostalCode;
    private String mSortingCode;
    private String mCountryCodeAlpha2;

    public PostalAddress() {
    }

    public PostalAddress recipientName(String name) {
        mRecipientName = name;
        return this;
    }

    public PostalAddress phoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
        return this;
    }

    public PostalAddress streetAddress(String streetAddress) {
        mStreetAddress = streetAddress;
        return this;
    }

    public PostalAddress extendedAddress(String extendedAddress) {
        mExtendedAddress = extendedAddress;
        return this;
    }

    public PostalAddress locality(String locality) {
        mLocality = locality;
        return this;
    }

    public PostalAddress region(String region) {
        mRegion = region;
        return this;
    }

    public PostalAddress postalCode(String postalCode) {
        mPostalCode = postalCode;
        return this;
    }

    public PostalAddress sortingCode(String sortingCode) {
        mSortingCode = sortingCode;
        return this;
    }

    public PostalAddress countryCodeAlpha2(String countryCodeAlpha2) {
        mCountryCodeAlpha2 = countryCodeAlpha2;
        return this;
    }

    public String getRecipientName() {
        return mRecipientName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getStreetAddress() {
        return mStreetAddress;
    }

    public String getExtendedAddress() {
        return mExtendedAddress;
    }

    public String getLocality() {
        return mLocality;
    }

    public String getRegion() {
        return mRegion;
    }

    public String getPostalCode() {
        return mPostalCode;
    }

    public String getSortingCode() {
        return mSortingCode;
    }

    public String getCountryCodeAlpha2() {
        return mCountryCodeAlpha2;
    }

    /**
     * A {@link PostalAddress} is considered empty if it does not have a country code.
     *
     * @return {@code true} if the country code is {@code null} or empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return TextUtils.isEmpty(mCountryCodeAlpha2);
    }

    @Override
    public String toString() {
        return String.format("%s\n%s\n%s\n%s, %s\n%s %s", mRecipientName, mStreetAddress,
                mExtendedAddress, mLocality, mRegion, mPostalCode, mCountryCodeAlpha2);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mStreetAddress);
        dest.writeString(mExtendedAddress);
        dest.writeString(mLocality);
        dest.writeString(mRegion);
        dest.writeString(mPostalCode);
        dest.writeString(mCountryCodeAlpha2);
        dest.writeString(mRecipientName);
        dest.writeString(mPhoneNumber);
        dest.writeString(mSortingCode);
    }

    private PostalAddress(Parcel in) {
        mStreetAddress = in.readString();
        mExtendedAddress = in.readString();
        mLocality = in.readString();
        mRegion = in.readString();
        mPostalCode = in.readString();
        mCountryCodeAlpha2 = in.readString();
        mRecipientName = in.readString();
        mPhoneNumber = in.readString();
        mSortingCode = in.readString();
    }

    public static final Creator<PostalAddress> CREATOR = new Creator<PostalAddress>() {
        public PostalAddress createFromParcel(Parcel source) {
            return new PostalAddress(source);
        }

        public PostalAddress[] newArray(int size) {
            return new PostalAddress[size];
        }
    };
}
