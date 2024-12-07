
public class Main {
    public static void main(String[] args) {
        User user1 = new User.UserBuilder("Иван", "Иванов")
                .email("ivan.ivanov@example.com")
                .phoneNumber("+1234567890")
                .address("г. Москва, ул. Ленина, д. 1")
                .build();

        User user2 = new User.UserBuilder("Анна", "Смирнова")
                .email("anna.smirnova@example.com")
                .build();

        System.out.println(user1);
        System.out.println(user2);
    }
}

class User {
    private final String firstName;
    private final String lastName;

    private final String email;
    private final String phoneNumber;
    private final String address;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User {" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;

        private String email;
        private String phoneNumber;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}