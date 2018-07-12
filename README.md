# Java9-Http2Client
Sample client using http2 client
Unlike HttpURLConnection, HTTP Client provides synchronous and asynchronous request mechanisms.
The API consists of 3 core classes:
1. HttpRequest – represents the request to be sent via the HttpClient
2. HttpClient – behaves as a container for configuration information common to multiple requests
3. HttpResponse – represents the result of an HttpRequest call

Why?
Java provided only the HttpURLConnection API – which is low-level and isn’t known for being feature-rich and user-friendly.Therefore, some widely used third-party libraries were commonly used – such as Apache HttpClient, Jetty, and Spring’s RestTemplate.
Improvements:
    	Header Compression. HTTP/2 uses HPACK compression, which reduces overhead.
	Single Connection to the server, reduces the number of round trips needed to set up multiple TCP connections.
	Multiplexing. Multiple requests are allowed at the same time, on the same connection.
	Server Push. Additional future needed resources can be sent to a client.
	Binary format. More compact.


# Java9-ImmutableCollection
Factory Methods for creating unmodifiable collections
Ref: https://docs.oracle.com/javase/9/core/creating-immutable-lists-sets-and-maps.htm#JSCOR-GUID-930A5334-9413-4E87-A1D7-6FF4E9E421B2

Why?