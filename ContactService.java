import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact (must have unique ID)
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }

        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Duplicate contact ID");
        }

        contacts.put(contact.getContactId(), contact);
    }

    // Delete contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }

        contacts.remove(contactId);
    }

    // Update first name
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setFirstName(firstName);
    }

    // Update last name
    public void updateLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setLastName(lastName);
    }

    // Update phone
    public void updatePhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setPhone(phone);
    }

    // Update address
    public void updateAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);

        if (contact == null) {
            throw new IllegalArgumentException("Contact not found");
        }

        contact.setAddress(address);
    }

    // Helper method for testing
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}