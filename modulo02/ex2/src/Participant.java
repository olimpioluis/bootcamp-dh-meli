public class Participant {
    private int code;
    private String RG;
    private String name;
    private String surname;
    private int age;
    private String phoneNumber;
    private String emergencyNumber;
    private String bloodGroup;

    public Participant(String RG, String name, String surname, int age, String phoneNumber, String emergencyNumber, String bloodGroup) {
        this.RG = RG;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.emergencyNumber = emergencyNumber;
        this.bloodGroup = bloodGroup;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return this.age;
    }

    public String getRG() {
        return this.RG;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "Codigo=" + code +
                ", RG='" + RG + '\'' +
                ", nome='" + name + '\'' +
                ", sobrenome='" + surname + '\'' +
                ", idade=" + age +
                ", numero de emergencia='" + phoneNumber + '\'' +
                ", grupo sanguineo='" + bloodGroup + '\'' +
                '}';
    }
}
