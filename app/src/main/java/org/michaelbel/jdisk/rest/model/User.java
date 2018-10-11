package org.michaelbel.jdisk.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    @SerializedName("first_name")
    public String firstName;

    @SerializedName("last_name")
    public String lastName;

    @SerializedName("display_name")
    public String displayName;

    @SerializedName("emails")
    public List<String> emails;

    @SerializedName("default_email")
    public String email;

    @SerializedName("real_name")
    public String name;

    @SerializedName("is_avatar_empty")
    public boolean isAvatarEmpty;

    @SerializedName("birthday")
    public String birthday;

    @SerializedName("default_avatar_id")
    public String avatarId;

    @SerializedName("openid_identities")
    public List<String> identities;

    @SerializedName("login")
    public String login;

    @SerializedName("old_social_login")
    public String oldLogin;

    @SerializedName("sex")
    public String sex;

    @SerializedName("id")
    public String id;
}