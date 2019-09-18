package com.droiddigger.rxjavawithmvp.network;
/*This class binds our APIClient and the APIServices together */
public class NetworkingUtils {
    private static UserApiServices userService;

    public static UserApiServices getUserApiInstance() {
        if (userService == null)
            userService = ApiClient.getInstance().create(UserApiServices.class);

        return userService;
    }
}
