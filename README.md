Retrofitsquare
2.0

1.	
@GETURLURLdemoURLownerrepoContributor
public interface GitHub {
    @GET("/repos/{owner}/{repo}/contributors")
    Call<List<Contributor>> contributors(
        @Path("owner") String owner,
        @Path("repo") String repo);
  }
public static class Contributor {
    public final String login;
    public final int contributions;

    public Contributor(String login, int contributions) {
      this.login = login;
      this.contributions = contributions;
    }
  }
2.	Newclient,demojsonGsonretrofitsquarejar
	 Gson: com.squareup.retrofit2:converter-gson
	Jackson: com.squareup.retrofit2:converter-jackson
	Moshi: com.squareup.retrofit2:converter-moshi
	Protobuf: com.squareup.retrofit2:converter-protobuf
	Wire: com.squareup.retrofit2:converter-wire
	Simple XML: com.squareup.retrofit2:converter-simplexml
	Scalars (primitives, boxed, and String): com.squareup.retrofit2:converter-scalars
addConverterFactoryConverter.Factoryconverter 
// Create a very simple REST adapter which points the GitHub API.
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();
3.	
// Create an instance of our GitHub API interface.
    GitHub github = retrofit.create(GitHub.class);

    // Create a call instance for looking up Retrofit contributors.
    Call<List<Contributor>> call = github.contributors("square", "retrofit");
4.	

// Synchronous Call in Retrofit 2.0
  
List<Contributor> contributors = call.execute().body();

NetworkOnMainThreadExceptionexecute

// Synchronous Call in Retrofit 2.0
  
call.enqueue(List<Contributor> () {
    @Override
    public void onResponse(Response List<Contributor> response) {
        // Get result Repo from response.body()
    }
  
    @Override
    public void onFailure(Throwable t) {
  
    }
});
response response.body()onResponseonFailure

5.	

