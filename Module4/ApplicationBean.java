// Alisa Steensen Module 4 Bean

package model;

public class ApplicationBean implements java.io.Serializable {
    private String fullname;
    private String email;
    private String address;
    private String city;
    private String state;
    private int zipcode;            
    private String phone;           
    private String position;
    private String linkedin;
    private String resume;
    private String reference;

    public ApplicationBean() {
        
    }

    // Full Name
    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }

    // Email
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Address
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    // City
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    // State
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    // Zipcode
    public String getZipcode() {
        return Integer.toString(zipcode);
    }
    public void setZipcode(String zipcode) {
        try {
            this.zipcode = Integer.parseInt(zipcode);
        } catch (NumberFormatException e) {
            this.zipcode = 0; 
        }
    }

    // Phone
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    // Position
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    // LinkedIn
    public String getLinkedin() { return linkedin; }
    public void setLinkedin(String linkedin) { this.linkedin = linkedin; }

    // Resume
    public String getResume() { return resume; }
    public void setResume(String resume) { this.resume = resume; }

    // Reference
    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }
}
