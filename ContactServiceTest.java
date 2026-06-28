import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);

        assertEquals(contact, service.getContact("1"));
    }

    @Test
    public void testDuplicateContactIdThrowsException() {
        ContactService service = new ContactService();

        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "Address");
        Contact c2 = new Contact("1", "Jane", "Smith", "0987654321", "Address");

        service.addContact(c1);

        assertThrows(IllegalArgumentException.class, () ->
                service.addContact(c2));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();

        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);
        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    public void testDeleteNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                service.deleteContact("999"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();

        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);

        service.updateFirstName("1", "Jane");

        assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();

        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);

        service.updateLastName("1", "Smith");

        assertEquals("Smith", service.getContact("1").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();

        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);

        service.updatePhone("1", "0987654321");

        assertEquals("0987654321", service.getContact("1").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();

        Contact contact = new Contact("1", "John", "Doe", "1234567890", "Address");
        service.addContact(contact);

        service.updateAddress("1", "New Address");

        assertEquals("New Address", service.getContact("1").getAddress());
    }

    @Test
    public void testUpdateNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName("999", "Test"));
    }
}
