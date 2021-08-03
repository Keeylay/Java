public class Project {
    private String name;
    private String description;

    public Project() {
        this.name = "Kyle Myer";
        this.description = "Hes a runner hes a track star";
    }
    public Project(String nameInput) {
        this.name = nameInput;
        this.description = "Will you be my Valentine";
    }
    public Project(String nameInput, String descriptionInput){
        this.name = nameInput;
        this.description = descriptionInput;
    }
    public String elecatorPitch() {
        String pitch = String.format("%s : %s", this.name, this.description);
        return pitch;
    }
}
