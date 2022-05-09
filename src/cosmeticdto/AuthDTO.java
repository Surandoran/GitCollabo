package cosmeticdto;

public class AuthDTO extends DTO{
    private String id;
    private String pw;
    private String addr;
    private String phone;

    public AuthDTO(String id, String pw, String addr, String phone) {
        this.id = id;
        this.pw = pw;
        this.addr = addr;
        this.phone = phone;
    }

    public AuthDTO(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AuthDTO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", addr='" + addr + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
