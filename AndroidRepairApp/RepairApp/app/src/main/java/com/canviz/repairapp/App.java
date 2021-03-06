package com.canviz.repairapp;

import android.app.Application;

import com.canviz.repairapp.data.IncidentModel;
import com.canviz.repairapp.utility.ListHelper;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.listservices.SharepointListsClient;
import com.microsoft.listservices.http.OAuthCredentials;

public class App extends Application {
    private String Token;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    private String IncidentId;

    public String getIncidentId() {
        return IncidentId;
    }

    public void setIncidentId(String incidentId) {
        IncidentId = incidentId;
    }

    private String PropertyId;

    public String getPropertyId() {
        return PropertyId;
    }

    public void setPropertyId(String propertyId) {
        PropertyId = propertyId;
    }

    private String UserId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public ListHelper getDataSource() {
        //String accessToken = mAuthManager.getAccessToken();

        SharepointListsClient client = new SharepointListsClient(
                Constants.SHAREPOINT_URL,
                Constants.SHAREPOINT_SITE_PATH,
                new OAuthCredentials(Token)
        );
        return new ListHelper(client);
    }

    private IncidentModel SelectedIncidentModel;

    public void setSelectedIncidentModel(IncidentModel incidentModel){
        SelectedIncidentModel = incidentModel;
    }

    public IncidentModel getSelectedIncidentModel(){
        return SelectedIncidentModel;
    }

    private AuthenticationContext authenticationContext;

    public void setAuthenticationContext(AuthenticationContext value){
        authenticationContext = value;
    }

    public AuthenticationContext getAuthenticationContext(){
        return authenticationContext;
    }


}
