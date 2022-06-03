package carrefour2018;

public class ShowAllFromDB {

    int id;
    String position;

   
    String first;
    String lastName;
    String age;
    String gender;
    String country;
    String passport;
    String joinDate;
    String mobile;
    String department;
    String section;
    int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public ShowAllFromDB(int id, String first, String lastName, String age, String gender, String country, String passport, String joinDate, String mobile, String department, String section,String position ,int grade) {
        super();
        this.id = id;
        this.first = first;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.passport = passport;
        this.joinDate = joinDate;
        this.mobile = mobile;
        this.department = department;
        this.section = section;
        this.position= position;
        this.grade = grade;
    }

    public ShowAllFromDB() {

    }

}
