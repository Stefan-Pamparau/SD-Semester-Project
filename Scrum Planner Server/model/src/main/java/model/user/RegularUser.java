package model.user;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Model class which represents a regular user of the application.
 *
 * @author Stefan Pamparau
 */
@Entity
@DiscriminatorValue("REGULAR_USER")
public class RegularUser extends User {

}
