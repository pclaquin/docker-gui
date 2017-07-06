package container;

public class ContainerState {

	private String Status;
	private String Running;
	private String Paused;
	private String COMKilled;
	private String Dead;
	private String Pid;
	private String ExitCode;
	private String Error;
	private String StartedAt;
	private String FinishedAt;
	
	
	public ContainerState() {
		this.Status = "undefined";
		this.Running = "undefined";
		this.Paused = "undefined";
		this.COMKilled = "undefined";
		this.Dead = "undefined";
		this.Pid = "undefined";
		this.ExitCode = "undefined";
		this.Error = "undefined";
		this.StartedAt = "undefined";
		this.FinishedAt = "undefined";
	}
	
	public ContainerState(String status, String running, String paused, String comKilled, String dead, String pid,
			String exitCode, String error, String startedAt, String finishedAt) {
		this.Status = status;
		this.Running = running;
		this.Paused = paused;
		this.COMKilled = comKilled;
		this.Dead = dead;
		this.Pid = pid;
		this.ExitCode = exitCode;
		this.Error = error;
		this.StartedAt = startedAt;
		this.FinishedAt = finishedAt;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		this.Status = status;
	}

	public String getRunning() {
		return Running;
	}

	public void setRunning(String running) {
		this.Running = running;
	}

	public String getPaused() {
		return Paused;
	}

	public void setPaused(String paused) {
		this.Paused = paused;
	}

	public String getComKilled() {
		return COMKilled;
	}

	public void setComKilled(String comKilled) {
		this.COMKilled = comKilled;
	}

	public String getDead() {
		return Dead;
	}

	public void setDead(String dead) {
		this.Dead = dead;
	}

	public String getPid() {
		return Pid;
	}

	public void setPid(String pid) {
		this.Pid = pid;
	}

	public String getExitCode() {
		return ExitCode;
	}

	public void setExitCode(String exitCode) {
		this.ExitCode = exitCode;
	}

	public String getError() {
		return Error;
	}

	public void setError(String error) {
		this.Error = error;
	}

	public String getStartedAt() {
		return StartedAt;
	}

	public void setStartedAt(String startedAt) {
		this.StartedAt = startedAt;
	}

	public String getFinishedAt() {
		return FinishedAt;
	}

	public void setFinishedAt(String finishedAt) {
		this.FinishedAt = finishedAt;
	}

}
