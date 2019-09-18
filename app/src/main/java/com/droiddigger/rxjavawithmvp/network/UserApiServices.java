package com.droiddigger.rxjavawithmvp.network;

import com.droiddigger.rxjavawithmvp.model.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/*In this class we configure our API Endpoints*/

public interface UserApiServices {
    @GET("/posts/")
    Observable<List<User>> getUsersList();/*Returns an Observable of type list, RX converts server response to an Observable*/
}
