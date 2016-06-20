package burrows.apps.giphy.example.rest.service;

import burrows.apps.giphy.example.rest.model.GiphyResponse;
import burrows.apps.giphy.example.util.ServiceUtil;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Giphy Api Service for getting "trending" and "search" api results.
 *
 * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
 */
public final class GiphyService {

    /**
     * URL for Giphy.
     */
    private static final String BASE_URL = "http://api.giphy.com/";

    /**
     * Giphy limit results.
     */
    public static final int RESULTS_COUNT = 24;

    /**
     * Giphy public API key.
     */
    public static final String PUBLIC_API_KEY = "dc6zaTOxFJmzC";

    /**
     * Contains the methods that will be used for retrieving the mModel.
     */
    private static GiphyApi sApi;

    /**
     * Instance to be reused for all calls.
     */
    private static volatile GiphyService sInstance;

    /**
     * GiphyService.
     *
     * @param endPoint Custom URL.
     */
    private GiphyService(final String endPoint) {
        sApi = ServiceUtil.createService(GiphyApi.class, endPoint);
    }

    /**
     * Giphy Service.
     */
    public static GiphyService getInstance() {
        return getInstance(BASE_URL);
    }

    /**
     * Giphy Service.
     *
     * @param endPoint Custom URL.
     */
    static GiphyService getInstance(final String endPoint) {
        if (sInstance == null) {
            synchronized (GiphyService.class) {
                if (sInstance == null) {
                    sInstance = new GiphyService(endPoint);
                }
            }
        }

        return sInstance;
    }

    /**
     * Get trending gif results. Default limit to 24.
     *
     * @return Response of trending results.
     */
    public Observable<GiphyResponse> getTrendingResults() {
        return this.getTrendingResults(PUBLIC_API_KEY);
    }

    /**
     * Get search gif results by a search string. Default limit to 24.
     *
     * @param apiKey Api key for Giphy.
     * @return Response of trending results.
     */
    Observable<GiphyResponse> getTrendingResults(final String apiKey) {
        return this.getTrendingResults(RESULTS_COUNT, apiKey);
    }

    /**
     * Get search gif results by a search string.
     *
     * @param limit  Limit results.
     * @param apiKey Api key for Giphy.
     * @return Response of trending results.
     */
    Observable<GiphyResponse> getTrendingResults(final int limit, final String apiKey) {
        return sApi.getTrendingResults(limit, apiKey);
    }

    /**
     * Get search gif results by a search string. Default limit to 24.
     *
     * @param searchString Search string to find gifs.
     * @return Response of search results.
     */
    public Observable<GiphyResponse> getSearchResults(final String searchString) {
        return this.getSearchResults(searchString, PUBLIC_API_KEY);
    }

    /**
     * Get search gif results by a search string. Default limit to 24.
     *
     * @param searchString Search string to find gifs.
     * @param apiKey       Api key for Giphy.
     * @return Response of search results.
     */
    Observable<GiphyResponse> getSearchResults(final String searchString, final String apiKey) {
        return this.getSearchResults(searchString, RESULTS_COUNT, apiKey);
    }

    /**
     * Get search gif results by a search string.
     *
     * @param searchString Search string to find gifs.
     * @param limit        Limit results.
     * @param apiKey       Api key for Giphy.
     * @return Response of search results.
     */
    Observable<GiphyResponse> getSearchResults(final String searchString, final int limit, final String apiKey) {
        return sApi.getSearchResults(searchString, limit, apiKey);
    }

    /**
     * Custom Api interfaces for the Giphy Api.
     *
     * @author <a href="mailto:jaredsburrows@gmail.com">Jared Burrows</a>
     */
    public interface GiphyApi {

        /**
         * Get trending gif results.
         * <p>
         * URL: http://api.giphy.com/v1/gifs/trending
         * Path: /v1/gifs/trending
         * Query: api_key
         *
         * @param limit  Limit results.
         * @param apiKey Api key for Giphy.
         * @return Response of trending results.
         */
        @GET("/v1/gifs/trending")
        Observable<GiphyResponse> getTrendingResults(@Query("limit") final int limit,
                                                     @Query("api_key") final String apiKey);

        /**
         * Get search gif results by a search string.
         * <p>
         * URL: http://api.giphy.com/v1/gifs/search
         * Path: /v1/gifs/search
         * Query: q
         * Query: api_key
         *
         * @param searchString Search string to find gifs.
         * @param limit        Limit results.
         * @param apiKey       Api key for Giphy.
         * @return Response of search results.
         */
        @GET("/v1/gifs/search")
        Observable<GiphyResponse> getSearchResults(@Query("q") final String searchString,
                                                   @Query("limit") final int limit,
                                                   @Query("api_key") final String apiKey);
    }
}
