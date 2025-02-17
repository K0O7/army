package solvd.army;

public class TrainingProgram {
    private long id;
    private String program_name;

    public TrainingProgram(long id, String programName) {
        this.id = id;
        this.program_name = programName;
    }
    
    public TrainingProgram() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProgramName() {
		return program_name;
	}

	public void setProgramName(String program_name) {
		this.program_name = program_name;
	}
    
}
