public class ProjectTest {
    public static void main(String[] args) {
        Project name1 = new Project();
        Project name2 = new Project("Floss Boy Jr.");
        Project name3 = new Project("Rick Ross", "Going to let you down");

        System.out.println(name1.elecatorPitch());
        System.out.println(name2.elecatorPitch());
        System.out.println(name3.elecatorPitch());
    }
}
