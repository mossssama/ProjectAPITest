package com.example.testapionly;

import com.example.testapionly.Graph.AllNodes;
import com.example.testapionly.Graph.ShortestPathInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/* Interface to defines requests & their EndPoints*/
/* It manage Api usage*/
public interface Api {

    String BASE_URL="https://public-transportations.herokuapp.com/"; /* Api doc: BaseURL used in every Api request */

    /* GET request (rootThatWillBeAddedToBaseURL) */
    /* It returns with JSON array of Hero; so we stores it in List<Hero> */
    @GET(".")           /* GET request URL = Base URL */
    Call<AllNodes> getAllNodes();

    @FormUrlEncoded
    @POST("showResult")
    Call<ShortestPathInfo> getShortestPath(
            @Field("Location") String Location,
            @Field("Destination") String Destination
    );

   /* @POST("showResults")
    Call<PathEndPoints> getRoute();*/



}
