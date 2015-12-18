package io.github.pedrofraca.leancodeandroid;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addToCartTest() throws Exception {
        Cart cart = new Cart();
        cart.addItem("cherries");
        assertEquals (cart.getTotal(), Cart.CHERRIES);
    }

    @Test
    public void addThreePommes() throws Exception {
        Cart cart = new Cart();
        cart.addItem("pommes");
        cart.addItem("pommes");
        cart.addItem("pommes");
        assertEquals(200, cart.getTotal());
    }

    @Test
    public void testDue() throws  Exception{
        Cart cart = new Cart();
        cart.addItem("mele,pommes,pommes,mele");
        assertEquals(250, cart.getTotal());
    }
}