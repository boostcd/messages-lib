package io.boostcd.messages.github;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ref",
    "before",
    "after",
    "repository",
    "pusher",
    "organization",
    "sender",
    "created",
    "deleted",
    "forced",
    "base_ref",
    "compare",
    "commits",
    "head_commit",
    "hook_id",
    "hook"
})
public class GitHubHook {

    @JsonProperty("ref")
    private String ref;
    @JsonProperty("before")
    private String before;
    @JsonProperty("after")
    private String after;
    @JsonProperty("repository")
    private Repository repository;
    @JsonProperty("pusher")
    private Pusher pusher;
    @JsonProperty("organization")
    private Organization organization;
    @JsonProperty("sender")
    private Sender sender;
    @JsonProperty("created")
    private Boolean created;
    @JsonProperty("deleted")
    private Boolean deleted;
    @JsonProperty("forced")
    private Boolean forced;
    @JsonProperty("base_ref")
    private Object baseRef;
    @JsonProperty("compare")
    private String compare;
    @JsonProperty("commits")
    private List<Commit> commits = null;
    @JsonProperty("head_commit")
    private HeadCommit headCommit;
    @JsonProperty("hook_id")
    private Integer hookId;
    @JsonProperty("hook")
    private Hook hook;

    @JsonProperty("ref")
    public String getRef() {
        return ref;
    }

    @JsonProperty("ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    @JsonProperty("before")
    public String getBefore() {
        return before;
    }

    @JsonProperty("before")
    public void setBefore(String before) {
        this.before = before;
    }

    @JsonProperty("after")
    public String getAfter() {
        return after;
    }

    @JsonProperty("after")
    public void setAfter(String after) {
        this.after = after;
    }

    @JsonProperty("repository")
    public Repository getRepository() {
        return repository;
    }

    @JsonProperty("repository")
    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    @JsonProperty("pusher")
    public Pusher getPusher() {
        return pusher;
    }

    @JsonProperty("pusher")
    public void setPusher(Pusher pusher) {
        this.pusher = pusher;
    }

    @JsonProperty("organization")
    public Organization getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @JsonProperty("sender")
    public Sender getSender() {
        return sender;
    }

    @JsonProperty("sender")
    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @JsonProperty("created")
    public Boolean getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(Boolean created) {
        this.created = created;
    }

    @JsonProperty("deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    @JsonProperty("deleted")
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @JsonProperty("forced")
    public Boolean getForced() {
        return forced;
    }

    @JsonProperty("forced")
    public void setForced(Boolean forced) {
        this.forced = forced;
    }

    @JsonProperty("base_ref")
    public Object getBaseRef() {
        return baseRef;
    }

    @JsonProperty("base_ref")
    public void setBaseRef(Object baseRef) {
        this.baseRef = baseRef;
    }

    @JsonProperty("compare")
    public String getCompare() {
        return compare;
    }

    @JsonProperty("compare")
    public void setCompare(String compare) {
        this.compare = compare;
    }

    @JsonProperty("commits")
    public List<Commit> getCommits() {
        return commits;
    }

    @JsonProperty("commits")
    public void setCommits(List<Commit> commits) {
        this.commits = commits;
    }

    @JsonProperty("head_commit")
    public HeadCommit getHeadCommit() {
        return headCommit;
    }

    @JsonProperty("head_commit")
    public void setHeadCommit(HeadCommit headCommit) {
        this.headCommit = headCommit;
    }

    @JsonProperty("hook_id")
    public Integer getHookId() {
        return hookId;
    }

    @JsonProperty("hook_id")
    public void setHookId(Integer hookId) {
        this.hookId = hookId;
    }

    @JsonProperty("hook")
    public Hook getHook() {
        return hook;
    }

    @JsonProperty("hook")
    public void setHook(Hook hook) {
        this.hook = hook;
    }

}
