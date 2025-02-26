package quarkus;

public class CreateUserRequest {
    private String firstName;
    private int age;

    // Construtor padrão necessário para desserialização do JSON
    public CreateUserRequest() {}

    public CreateUserRequest(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
