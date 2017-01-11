package be.kdg.shop.model.user;

import be.kdg.shop.model.shopping.Cart;
import be.kdg.shop.model.shopping.CartItem;
import be.kdg.shop.model.shopping.LineItem;
import be.kdg.shop.model.shopping.Order;
import be.kdg.shop.model.user.exceptions.LoginException;

import java.util.ArrayList;
import java.util.Collection;

public final class User
{
    private final String username;
    private Person person;
    private Cart cart;
    private Role role;
    private Collection<Order> orders;
    private String password;

    public User(Person person, String username, String password, Role role)
    {
        this.person = person;
        this.username = username;
        this.password = password;
        this.role = role;
        this.cart = new Cart();
        this.orders = new ArrayList<Order>();
    }

    /**
     * Maakt een bestelling op basis van de huidige winkelkarinhoud.
     *
     * @return Order
     */
    public Order createOrder()
    {
        Order order = new Order();
        for (CartItem cartItem : getCart().getCartItems().values())
        {
            order.addLineItem(new LineItem(cartItem.getProduct().getDescription(), cartItem.getAmount(), cartItem.getPrice()));
        }
        getCart().clearCart();
        synchronized (this)
        {
            orders.add(order);
        }
        return order;
    }

    /**
     * Geef het winkelkarretje van deze gebruiker
     *
     * @return cart
     */
    public Cart getCart()
    {
        return cart;
    }

    public synchronized void setCart(Cart cart)
    {
        this.cart = cart;
    }

    /**
     * Geef de username terug van deze gebruiker
     *
     * @return
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Geeft de persoon terug die bij deze gebruiker hoort
     *
     * @return
     */
    public Person getPerson()
    {
        return person;
    }

    public synchronized void setPerson(Person person)
    {
        this.person = person;
    }

    public Role getRole()
    {
        return role;
    }

    public synchronized void setRole(Role role)
    {
        this.role = role;
    }

    /**
     * Geeft alle Orders terug die deze gebruiker tot nog toe gemaakt heeft.
     *
     * @return orders
     */
    public Collection<Order> getOrders()
    {
        return orders;
    }

    public synchronized void setOrders(Collection<Order> orders)
    {
        this.orders = orders;
    }

    public synchronized void changePassword(String oldPassword, String newPassword) throws LoginException
    {
        // check oldpassword throws LoginException
        if (!this.checkPassword(oldPassword.toCharArray()))
            throw new LoginException("Password incorrect");
        this.password = newPassword;
    }

    /**
     * Controleert of het password wel correct is.
     *
     * @param password
     * @return
     */
    public boolean checkPassword(char[] password)
    {
        //String encrypted = encrypt(password);
        return this.password.equals(String.valueOf(password));
    }
}