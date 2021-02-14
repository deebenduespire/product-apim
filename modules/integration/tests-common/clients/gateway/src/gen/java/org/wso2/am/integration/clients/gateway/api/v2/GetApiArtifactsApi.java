/*
 * WSO2 API Manager - Gateway
 * This document specifies a **RESTful API** for WSO2 **API Manager** - Gateway. Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.5.176/components/apimgt/org.wso2.carbon.apimgt.rest.api.admin/src/main/resources/admin-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: v2
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.gateway.api.v2;

import org.wso2.am.integration.clients.gateway.api.ApiCallback;
import org.wso2.am.integration.clients.gateway.api.ApiClient;
import org.wso2.am.integration.clients.gateway.api.ApiException;
import org.wso2.am.integration.clients.gateway.api.ApiResponse;
import org.wso2.am.integration.clients.gateway.api.Configuration;
import org.wso2.am.integration.clients.gateway.api.Pair;
import org.wso2.am.integration.clients.gateway.api.ProgressRequestBody;
import org.wso2.am.integration.clients.gateway.api.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.wso2.am.integration.clients.gateway.api.v2.dto.APIArtifactDTO;
import org.wso2.am.integration.clients.gateway.api.v2.dto.EndpointsDTO;
import org.wso2.am.integration.clients.gateway.api.v2.dto.ErrorDTO;
import org.wso2.am.integration.clients.gateway.api.v2.dto.LocalEntryDTO;
import org.wso2.am.integration.clients.gateway.api.v2.dto.SequencesDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetApiArtifactsApi {
    private ApiClient apiClient;

    public GetApiArtifactsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public GetApiArtifactsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for apiArtifactGet
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call apiArtifactGetCall(String apiName, String version, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api-artifact";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (apiName != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("apiName", apiName));
        if (version != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("version", version));
        if (tenantDomain != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("tenantDomain", tenantDomain));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call apiArtifactGetValidateBeforeCall(String apiName, String version, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiName' is set
        if (apiName == null) {
            throw new ApiException("Missing the required parameter 'apiName' when calling apiArtifactGet(Async)");
        }
        
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new ApiException("Missing the required parameter 'version' when calling apiArtifactGet(Async)");
        }
        

        com.squareup.okhttp.Call call = apiArtifactGetCall(apiName, version, tenantDomain, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get API artifact from the storage
     * This operation is used to get the local entries, sequences and endpoints from the storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @return APIArtifactDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public APIArtifactDTO apiArtifactGet(String apiName, String version, String tenantDomain) throws ApiException {
        ApiResponse<APIArtifactDTO> resp = apiArtifactGetWithHttpInfo(apiName, version, tenantDomain);
        return resp.getData();
    }

    /**
     * Get API artifact from the storage
     * This operation is used to get the local entries, sequences and endpoints from the storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @return ApiResponse&lt;APIArtifactDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<APIArtifactDTO> apiArtifactGetWithHttpInfo(String apiName, String version, String tenantDomain) throws ApiException {
        com.squareup.okhttp.Call call = apiArtifactGetValidateBeforeCall(apiName, version, tenantDomain, null, null);
        Type localVarReturnType = new TypeToken<APIArtifactDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get API artifact from the storage (asynchronously)
     * This operation is used to get the local entries, sequences and endpoints from the storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call apiArtifactGetAsync(String apiName, String version, String tenantDomain, final ApiCallback<APIArtifactDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = apiArtifactGetValidateBeforeCall(apiName, version, tenantDomain, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<APIArtifactDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for endPointsGet
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call endPointsGetCall(String apiName, String version, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/end-points";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (apiName != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("apiName", apiName));
        if (version != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("version", version));
        if (tenantDomain != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("tenantDomain", tenantDomain));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call endPointsGetValidateBeforeCall(String apiName, String version, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiName' is set
        if (apiName == null) {
            throw new ApiException("Missing the required parameter 'apiName' when calling endPointsGet(Async)");
        }
        
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new ApiException("Missing the required parameter 'version' when calling endPointsGet(Async)");
        }
        

        com.squareup.okhttp.Call call = endPointsGetCall(apiName, version, tenantDomain, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get end-points from the storage for the API
     * This operation is used to get the end-points from the storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @return EndpointsDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public EndpointsDTO endPointsGet(String apiName, String version, String tenantDomain) throws ApiException {
        ApiResponse<EndpointsDTO> resp = endPointsGetWithHttpInfo(apiName, version, tenantDomain);
        return resp.getData();
    }

    /**
     * Get end-points from the storage for the API
     * This operation is used to get the end-points from the storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @return ApiResponse&lt;EndpointsDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<EndpointsDTO> endPointsGetWithHttpInfo(String apiName, String version, String tenantDomain) throws ApiException {
        com.squareup.okhttp.Call call = endPointsGetValidateBeforeCall(apiName, version, tenantDomain, null, null);
        Type localVarReturnType = new TypeToken<EndpointsDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get end-points from the storage for the API (asynchronously)
     * This operation is used to get the end-points from the storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call endPointsGetAsync(String apiName, String version, String tenantDomain, final ApiCallback<EndpointsDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = endPointsGetValidateBeforeCall(apiName, version, tenantDomain, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<EndpointsDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for localEntryGet
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call localEntryGetCall(String apiName, String version, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/local-entry";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (apiName != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("apiName", apiName));
        if (version != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("version", version));
        if (tenantDomain != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("tenantDomain", tenantDomain));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call localEntryGetValidateBeforeCall(String apiName, String version, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiName' is set
        if (apiName == null) {
            throw new ApiException("Missing the required parameter 'apiName' when calling localEntryGet(Async)");
        }
        
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new ApiException("Missing the required parameter 'version' when calling localEntryGet(Async)");
        }
        

        com.squareup.okhttp.Call call = localEntryGetCall(apiName, version, tenantDomain, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get Local Entry from the storage
     * This operation is used to get local entry from the storage.If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @return LocalEntryDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public LocalEntryDTO localEntryGet(String apiName, String version, String tenantDomain) throws ApiException {
        ApiResponse<LocalEntryDTO> resp = localEntryGetWithHttpInfo(apiName, version, tenantDomain);
        return resp.getData();
    }

    /**
     * Get Local Entry from the storage
     * This operation is used to get local entry from the storage.If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @return ApiResponse&lt;LocalEntryDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<LocalEntryDTO> localEntryGetWithHttpInfo(String apiName, String version, String tenantDomain) throws ApiException {
        com.squareup.okhttp.Call call = localEntryGetValidateBeforeCall(apiName, version, tenantDomain, null, null);
        Type localVarReturnType = new TypeToken<LocalEntryDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get Local Entry from the storage (asynchronously)
     * This operation is used to get local entry from the storage.If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call localEntryGetAsync(String apiName, String version, String tenantDomain, final ApiCallback<LocalEntryDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = localEntryGetValidateBeforeCall(apiName, version, tenantDomain, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<LocalEntryDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for sequenceGet
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call sequenceGetCall(String apiName, String version, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/sequence";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (apiName != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("apiName", apiName));
        if (version != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("version", version));
        if (tenantDomain != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("tenantDomain", tenantDomain));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call sequenceGetValidateBeforeCall(String apiName, String version, String tenantDomain, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'apiName' is set
        if (apiName == null) {
            throw new ApiException("Missing the required parameter 'apiName' when calling sequenceGet(Async)");
        }
        
        // verify the required parameter 'version' is set
        if (version == null) {
            throw new ApiException("Missing the required parameter 'version' when calling sequenceGet(Async)");
        }
        

        com.squareup.okhttp.Call call = sequenceGetCall(apiName, version, tenantDomain, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get sequences from the storage
     * This operation is used to get the API sequence from the storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @return SequencesDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public SequencesDTO sequenceGet(String apiName, String version, String tenantDomain) throws ApiException {
        ApiResponse<SequencesDTO> resp = sequenceGetWithHttpInfo(apiName, version, tenantDomain);
        return resp.getData();
    }

    /**
     * Get sequences from the storage
     * This operation is used to get the API sequence from the storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @return ApiResponse&lt;SequencesDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<SequencesDTO> sequenceGetWithHttpInfo(String apiName, String version, String tenantDomain) throws ApiException {
        com.squareup.okhttp.Call call = sequenceGetValidateBeforeCall(apiName, version, tenantDomain, null, null);
        Type localVarReturnType = new TypeToken<SequencesDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get sequences from the storage (asynchronously)
     * This operation is used to get the API sequence from the storage. If the Tenant domain is not provided carbon.super will be picked as the Tenant domain. 
     * @param apiName Name of the API  (required)
     * @param version version of the API  (required)
     * @param tenantDomain Tenant Domain of the API  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call sequenceGetAsync(String apiName, String version, String tenantDomain, final ApiCallback<SequencesDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = sequenceGetValidateBeforeCall(apiName, version, tenantDomain, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<SequencesDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
