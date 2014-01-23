package com.denimgroup.threadfix.remote;

import com.denimgroup.threadfix.data.entities.*;
import com.denimgroup.threadfix.remote.response.RestResponse;

/**
 * Created with IntelliJ IDEA.
 * User: stran
 * Date: 11/19/13
 * Time: 3:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ThreadFixRestClient {

    public RestResponse<String> getRules(String wafId);
    public RestResponse<Waf> searchForWafByName(String name);
    public RestResponse<Waf> searchForWafById(String wafId);
    public RestResponse<Waf> createWaf(String name, String type);

    public RestResponse<Application> addWaf(String appId, String wafId);
    public RestResponse<Application> createApplication(String teamId, String name, String url);
    public RestResponse<Application> setParameters(String appId, String frameworkType, String repositoryUrl);
    public RestResponse<Application> searchForApplicationById(String id);
    public RestResponse<Application> searchForApplicationByName(String name, String teamName);

    public RestResponse<Organization[]> getAllTeams();
    public RestResponse<Organization> createTeam(String name);
    public RestResponse<String> getAllTeamsPrettyPrint();
    public RestResponse<Organization> searchForTeamById(String id);
    public RestResponse<Organization> searchForTeamByName(String name);

    public void setKey(String key);
    public void setUrl(String url);
    public void setMemoryKey(String key);
    public void setMemoryUrl(String url);

    public RestResponse<Scan> uploadScan(String applicationId, String filePath);
    public RestResponse<Application> addAppUrl(String appId, String url);

    public RestResponse<Object> queueScan(String applicationId, String scannerType);
    public RestResponse<String> requestTask(String scanners, String agentConfig);
    public RestResponse<String> taskStatusUpdate(String scanQueueTaskId, String message);
    public RestResponse<String> setTaskConfig(String appId, String scannerType, String filePath);
    public RestResponse<String> completeTask(String scanQueueTaskId, String filePath, String secureTaskKey);
    public RestResponse<String> failTask(String scanQueueTaskId, String message, String secureTaskKey);

    public RestResponse<Finding> addDynamicFinding(String applicationId, String vulnType, String severity,
                                    String nativeId, String parameter, String longDescription,
                                    String fullUrl, String path);
    public RestResponse<Finding> addStaticFinding(String applicationId, String vulnType, String severity,
                                   String nativeId, String parameter, String longDescription,
                                   String filePath, String column, String lineText, String lineNumber);
}
