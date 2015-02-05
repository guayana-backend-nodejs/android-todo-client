package com.example.ronsuez.loginclient.Api;

/**
 * Created by Mariangela Salcedo on 07/08/14.
 */
public class Status {
    /* ***********************************************
     *************** CONSTANTS ***********************
     * ********************************************* */

    public static final int LOGIN_SUCCESS = 100;
    public static final int LOGIN_FAILED = 101;

    public static final int SIGN_UP_SUCCESS = 102;
    public static final int SIGN_UP_FAILED = 103;
    public static final int SIGN_UP_FAILED_USERNAME_EXISTS = 104;
    public static final int SIGN_UP_FAILED_EMAIL_EXISTS = 105;
    public static final int SIGN_UP_FAILED_USERNAME_EMPTY = 106;
    public static final int SIGN_UP_FAILED_PASSWORD_EMPTY = 107;

    public static final int REMINDER_PASSWORD_SUCCESS = 108;
    public static final int REMINDER_PASSWORD_EMAIL_FAILED = 109;
    public static final int REMINDER_PASSWORD_FAILED = 110;

    public static final int SIGN_IN_USER_REGISTERED = 111;
    public static final int SIGN_IN_USER_UNREGISTERED = 112;

    public static final int UPLOAD_PHOTO_PROFILE_SUCCESS = 113;
    public static final int UPLOAD_PHOTO_PROFILE_FAILED = 114;

    public static final int UPLOAD_SELFIE_SUCCESS = 115;
    public static final int UPLOAD_SELFIE_FAILED = 116;


    public static final int USER_SELFIES_SUCCESS = 119;
    public static final int USER_SELFIES_FAILED = 120;

    public static final int USER_FOLLOWERS_SUCCESS = 121;
    public static final int USER_FOLLOWERS_FAILED = 122;

    public static final int USER_FOLLOWINGS_SUCCESS = 123;
    public static final int USER_FOLLOWINGS_FAILED = 124;
    public static final int USER_FOLLOW_SUCCESS = 125;
    public static final int USER_FOLLOW_FAILED = 126;
    public static final int USER_IS_FOLLOW_SUCCESS = 127;
    public static final int USER_IS_FOLLOW_FAILED = 128;
    public static final int USER_UNFOLLOW_SUCCESS = 129;
    public static final int USER_UNFOLLOW_FAILED = 130;


    public static final int USER_IMAGE_USERNAME_SUCCESS = 131;
    public static final int USER_IMAGE_USERNAME_FAILED = 132;
    public static final int USER_FAVORITE_SUCCESS = 133;
    public static final int USER_FAVORITE_FAILED = 134;


    public static final int USER_SUCCESS = 135;
    public static final int USER_FAILED = 136;

    public static final int  EXPLORER_USERS_SUCCESS = 137;
    public static final int  EXPLORER_PHOTOS_SUCCESS = 138;
    public static final int  EXPLORER_FAILED = 139;


    public static final int USER_MESSAGE_CREATE_SUCCESS = 140;
    public static final int USER_MESSAGE_CREATE_FAILED = 141;

    public static final int USER_MESSAGES_SUCCESS = 142;
    public static final int USER_MESSAGES_FAILED = 143;


    public static final int VOTE_SUCCESS = 144;
    public static final int VOTE_FAILED = 145;
    public static final int VOTE_EXIST = 146;
    public static final int VOTE_NOT_EXIST = 147;


}
