package org.jayantiandhale;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.concurrent.ExecutionException;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import jdk.incubator.http.HttpResponse.BodyHandler;
/**
 * 
 * @author jandhal
 *
 */
public class HttpTwoClient {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ExecutionException { 
		/**
		 *---------------------------With HTTP URL Connection API---------------------------------
		 */
		URL url = new URL("http://stackoverflow.com/"); //Specify the URL
		URLConnection urlConnection = url.openConnection(); //Create the connection
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(urlConnection.getInputStream())); //Create input stream and load into reader
		String inputLine;
		while ((inputLine = reader.readLine()) != null) { //Loop through and output each line in stream.
		    System.out.println(inputLine);
		}
		reader.close(); //Close Reader
		
		/**
		 * ---------------------------With HTTP Client in Java 9---------------------------
		 */
		//specify HTTP client
		HttpClient client=HttpClient.newHttpClient();
		//specify HTTP request
		HttpRequest request = HttpRequest.newBuilder()
		  .uri(new URI("http://stackoverflow.com/")) //setup URI
		  .version(HttpClient.Version.HTTP_2) //mention version - support for HTTP1.1 as well as HTTP2
		  .timeout(Duration.ofMillis(10000)) //timeout
		  .GET()
		  .build();
		//Receive http response synchronously
		HttpResponse<String> responseForSyncRequest=client.send(request, BodyHandler.asString()); //body handlers
		System.out.println(responseForSyncRequest.body());

		
		
		/**
		 * ---------------------------Send Async request with Java 9---------------------------
		 */
		/*
		CompletableFuture<HttpResponse<String>> responseForAsyncRequest = client
				.sendAsync(request, HttpResponse.BodyHandler.asString()); 
		if(responseForAsyncRequest.isDone()) {
		    System.out.println(responseForAsyncRequest.get().statusCode());
		    System.out.println(responseForAsyncRequest.get().body());
		} else {
			responseForAsyncRequest.cancel(true);
		}
		
	*/
	}

}
