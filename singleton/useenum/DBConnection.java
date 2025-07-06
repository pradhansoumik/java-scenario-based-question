package useenum;

/**
 * Cannot be subclassed
 * Safe from serialization, reflection, and cloning issues
 * by-default constructors are private
 */
public enum DBConnection {
    INSTANCE;
}
