package login;

public class Authorisation {

        private int id;//serial pk
        private String username;//unique
        private String password;
        private String role; //admin/user

        //empty constructor
        public Authorisation(){

        }

        //getters setters
        public void setId(int id) {
            this.id = id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setRole(String role) {
            this.role = role;
        }


        public int getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }

