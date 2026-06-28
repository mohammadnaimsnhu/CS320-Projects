import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {

        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "123 Main Street"
        );

        assertEquals("123", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    public void testInvalidContactId() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "Address");
        });
    }

    @Test
    public void testInvalidPhone() {

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "123", "Address");
        });
    }

    @Test
    public void testUpdateFirstName() {

        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "Address"
        );

        contact.setFirstName("Jane");

        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    public void testUpdateLastName() {

        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "Address"
        );

        contact.setLastName("Smith");

        assertEquals("Smith", contact.getLastName());
    }

    @Test
    public void testUpdatePhoneValid() {

        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "Address"
        );

        contact.setPhone("0987654321");

        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    public void testUpdatePhoneInvalid() {

        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "Address"
        );

        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("123");
        });
    }

    @Test
    public void testUpdateAddress() {

        Contact contact = new Contact(
                "123",
                "John",
                "Doe",
                "1234567890",
                "Address"
        );

        contact.setAddress("New Address");

        assertEquals("New Address", contact.getAddress());
    }
}