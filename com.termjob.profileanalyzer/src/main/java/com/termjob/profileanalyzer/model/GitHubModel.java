package com.termjob.profileanalyzer.model;

/**
 * Model class for git-hub metadata
 * 
 * @author Anoop Abraham
 *
 */
public class GitHubModel {

	/**
	 * git-hub tocken of the 
	 */
    private String gitHubTocken;
    
    /**
     * User id of the term-job user who is logged-in
     */
    private String userId;

    public GitHubModel() {
    }

    public GitHubModel(String gitHubTocken, String userId) {
        this.gitHubTocken = gitHubTocken;
        this.userId = userId;
    }

	/**
	 * @return the gitHubTocken
	 */
	public String getGitHubTocken() {
		return gitHubTocken;
	}

	/**
	 * @param gitHubTocken the gitHubTocken to set
	 */
	public void setGitHubTocken(String gitHubTocken) {
		this.gitHubTocken = gitHubTocken;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
