package src.user_data.interfaces;

import src.user_data.User;

public interface IUserData {
    public User getUser(int id);
    public int getCount();
    public void setUser(User user);
}
