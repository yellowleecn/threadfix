package com.denimgroup.threadfix.cli;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: stran
 * Date: 11/22/13
 * Time: 10:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class ThreadFixRestClientTests {

    private static final int TEAM_ID = 1;
    private static final String TEAM_NAME = "team";
    private static final int APPLICATION_ID = 1;
    private static final String APPLICATION_NAME = "app";
    private static final int WAF_ID = 1;
    private static final String WAF_NAME = "waf1";
    private static final String MOD_SECURITY = "mod_security";
    private static final String FILE_PATH = "C:\\Users\\stran\\Desktop\\CLIJTest\\ZAPRESULTS.xml";
    private static final String ACUNETIX = "Acunetix WVS";
    private static final String ACUNETIX_CONFIG_FILE = "C:\\Users\\stran\\Desktop\\CLIJTest\\acunetixConfig";
    private static final String TASK_ID = "3";

    /**
     * !!!!!!! ATTENTION: Before running these testcases, please making sure:
     *      + ThreadFix server is running with API_KEY
     *      + There TEAM_ID with TEAM_NAME in ThreadFix server
     *      + There APPLICATION_ID with APPLICATION_NAME in ThreadFix server
     *      + There's WAF_ID with WAF_NAME in TF, and rules are generated
     *      + There's TASK_ID
     *      + There's config file ACUNETIX_CONFIG_FILE
     */

//    @Test
//    public void testCreateApplication() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        Random randomGenerator = new Random();
//        String appRet = client.createApplication(String.valueOf(TEAM_ID), "appFromRest" + randomGenerator.nextInt(100),
//                "http://www.test.com");
//
//        assertNotNull(TestUtils.getJSONObject(appRet));
//    }
//
//    @Test
//    public void testSetParameters() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String appRet = client.setParameters(String.valueOf(APPLICATION_ID), "DETECT", "http://repositoryUrl.com");
//
//        assertNotNull(TestUtils.getJSONObject(appRet));
//    }
//
//    @Test
//    public void testCreateTeam() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        Random randomGenerator = new Random();
//        String teamRet = client.createTeam("teamFromRest" + randomGenerator.nextInt(100));
//
//        assertNotNull(TestUtils.getJSONObject(teamRet));
//    }
//
//    @Test
//    public void testGetRules() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String rulesRet = client.getRules(String.valueOf(WAF_ID));
//
//        assertNotNull(rulesRet);
//    }
//
//    @Test
//    public void testSearchForWafByName() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String wafRet = client.searchForWafByName(WAF_NAME);
//
//        assertNotNull(TestUtils.getJSONObject(wafRet));
//    }
//
//    @Test
//    public void testSearchForWafById() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String wafRet = client.searchForWafById(String.valueOf(WAF_ID));
//
//        assertNotNull(TestUtils.getJSONObject(wafRet));
//    }
//
//    @Test
//    public void testCreateWaf() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String wafRet = client.createWaf("waf2", MOD_SECURITY);
//
//        assertNotNull(TestUtils.getJSONObject(wafRet));
//    }
//
//    @Test
//    public void testAddWaf() {
//
//    }
//
//    @Test
//    public void testGetAllTeams() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String teamsRet = client.getAllTeams();
//        assertNotNull(TestUtils.getJSONObject(teamsRet));
//    }
//
//    @Test
//    public void testSearchForApplicationById() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String appRet = client.searchForApplicationById(String.valueOf(APPLICATION_ID));
//
//        assertNotNull(TestUtils.getJSONObject(appRet));
//    }
//
//    @Test
//    public void testSearchForApplicationByName() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String appRet = client.searchForApplicationByName(APPLICATION_NAME, TEAM_NAME);
//
//        assertNotNull(TestUtils.getJSONObject(appRet));
//    }
//
//    @Test
//    public void testSearchForTeamById() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String teamRet = client.searchForTeamById(String.valueOf(TEAM_ID));
//
//        assertNotNull(TestUtils.getJSONObject(teamRet));
//    }
//
//    @Test
//    public void testSearchForTeamByName() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String teamRet = client.searchForTeamByName(TEAM_NAME);
//
//        assertNotNull(TestUtils.getJSONObject(teamRet));
//    }
//
//    @Test
//    public void testSetKey() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        client.setKey(TestUtils.API_KEY);
//
//        PropertiesManager manager = new PropertiesManager();
//        assertEquals(TestUtils.API_KEY, manager.getKey());
//    }
//
//    @Test
//    public void testSetUrl() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        client.setUrl(TestUtils.URL);
//
//        PropertiesManager manager = new PropertiesManager();
//        assertEquals(TestUtils.URL, manager.getKey());
//    }
//
//    @Test
//    public void testUploadScan() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String scanRet = client.uploadScan(String.valueOf(APPLICATION_ID), FILE_PATH);
//
//        assertNotNull(TestUtils.getJSONObject(scanRet));
//    }
//
//    @Test
//    public void testQueueScan() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        Object obj = client.queueScan(String.valueOf(APPLICATION_ID),ACUNETIX );
//
//        assertTrue(Integer.valueOf(String.valueOf(obj)) > 0);
//    }
//
//    @Test
//    public void testAddAppUrl() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String appRet = client.addAppUrl(String.valueOf(APPLICATION_ID), "http://urlfromrest.com");
//
//        assertNotNull(TestUtils.getJSONObject(appRet));
//    }
//
//    @Test
//    public void testRequestTask() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String taskRet = client.requestTask(ACUNETIX,"Windows 7 User stran");
//
//        assertNotNull(TestUtils.getJSONObject(taskRet));
//
//    }
//
//    @Test
//    public void testTaskStatusUpdate() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String statusRet = client.taskStatusUpdate(TASK_ID, "updatefromtest");
//
//        assertTrue(Boolean.valueOf(statusRet));
//    }
//
//    @Test
//    public void testSetTaskConfig() {
//        ThreadFixRestClient client = new ThreadFixRestClientImpl(TestUtils.URL, TestUtils.API_KEY);
//        String setTaskRet = client.setTaskConfig(String.valueOf(APPLICATION_ID), ACUNETIX, ACUNETIX_CONFIG_FILE);
//
//        assertTrue(Boolean.valueOf(setTaskRet));
//    }

    @Test
    public void testCompleteTask() {
    }

    @Test
    public void testFailTask() {

    }

    @Test
    public void testAddDynamicFinding() {

    }

    @Test
    public void testAddStaticFinding() {

    }

}
