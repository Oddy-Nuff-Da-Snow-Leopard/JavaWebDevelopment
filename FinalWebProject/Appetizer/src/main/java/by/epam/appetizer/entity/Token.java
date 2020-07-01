package by.epam.appetizer.entity;

import java.util.Date;
import java.util.Objects;

public class Token extends Entity {

    private String hash;
    private Date creationDate;
    private int userId;

    public Token() {
    }

    public Token(int id, String hash, Date creationDate, int userId) {
        super(id);
        this.hash = hash;
        this.creationDate = creationDate;
        this.userId = userId;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        Token token = (Token) obj;
        return Objects.equals(hash, token.hash)
                && Objects.equals(creationDate, token.creationDate)
                && userId == token.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hash, creationDate, userId);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(super.toString());
        str.append("hash=").append(hash).append(", ");
        str.append("creationDate=").append(creationDate).append(", ");
        str.append("userId=").append(userId).append("]");
        return str.toString();
    }
}
